package br.edu.infnet.gratiapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.gratiapp.models.Gratiapp
import br.edu.infnet.gratiapp.models.GratiappWithId
import br.edu.infnet.gratiapp.repository.GratiappRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.toObject

class MainViewModel: ViewModel() {

    val TAG = "ViewModel"
    val repository = GratiappRepository.get()

    // Login
    fun getCurrentUserEmail(): String{
        return repository.getCurrentUser()?.email ?: "Email não encontrado"
    }

    fun logout(){
        repository.logout()
    }


    fun registerGratiapp(gratiapp: Gratiapp): Task<DocumentReference>{
        return repository.registerGratiapp(gratiapp)
    }

    fun observeColecaoGratiapps() {
        repository.getGratiappColecao()
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    Log.w(TAG, "listen:error", e)
                    return@addSnapshotListener
                }
                val listaInput = mutableListOf<GratiappWithId>()
                val listaRemocao = mutableListOf<String>()
                val listaModificacao = mutableListOf<GratiappWithId>()
                for (dc in snapshots!!.documentChanges) {
                    when (dc.type) {
                        DocumentChange.Type.ADDED -> {
                            val gratiapp = dc.document.toObject<Gratiapp>()
                            val id = dc.document.id
                            val gratiappWithId = gratiappToGratiappWithId(gratiapp, id)
                            Log.i(TAG, "gratidaoComId: ${gratiappWithId}")
                            listaInput.add(gratiappWithId)
                        }
                        DocumentChange.Type.MODIFIED -> {
                            val gratiapp = dc.document.toObject<Gratiapp>()
                            val id = dc.document.id
                            val gratiappWithId = gratiappToGratiappWithId(gratiapp, id)
                            Log.i(TAG, "Modificacao - gratidaoComId: ${gratiappWithId}")
                            listaModificacao.add(gratiappWithId)
                        }
                        DocumentChange.Type.REMOVED -> {
                            val id = dc.document.id
                            Log.i(TAG, "id removido: ${id}")
                            listaRemocao.add(dc.document.id)
                        }
                    }
                }
                addListaToGratiappWithId(listaInput)
                removeFromGratiappWithId(listaRemocao)
                modifyInGratiappWithId(listaModificacao)
            }
    }

    private val _gratiappWithId = MutableLiveData<List<GratiappWithId>>()
    val gratiappWithId: LiveData<List<GratiappWithId>> = _gratiappWithId

    fun addListaToGratiappWithId(listaInput: List<GratiappWithId>) {
        val listaOld = gratiappWithId.value
        val listaNew = mutableListOf<GratiappWithId>()

        listaOld?.forEach {
            listaNew.add(it)
        }

        listaInput.forEach {
            listaNew.add(it)
        }
        setGratiappWithId(listaNew)
    }

    private fun removeFromGratiappWithId(listaRemocao: List<String>) {
        val listOld = gratiappWithId.value
        val listNew = mutableListOf<GratiappWithId>()
        Log.i(TAG, "listaRemocao: ${listaRemocao}")
        if(listaRemocao.isNotEmpty()){
            listOld?.forEach {
                Log.i(TAG, "item da lista Antiga: ${it.id}")
                if (it.id in listaRemocao) {
                    Log.i(TAG, "item ${it.id} está dentro da listaRemocao")
                } else {
                    Log.i(TAG, "item ${it.id} _NÃO_ está dentro da listaRemocao")
                    listNew.add(it)
                }
            }
            setGratiappWithId(listNew)
        }
    }

    private fun modifyInGratiappWithId(listaModificacao: List<GratiappWithId>) {
        Log.i(TAG, "listaModificacao: ${listaModificacao}")
        if (listaModificacao.isNotEmpty()) {
            for (itemModificado in listaModificacao) {
                modifyItemInListaGratiappWithId(itemModificado)
            }
        }
    }

    fun modifyItemInListaGratiappWithId(itemModificado: GratiappWithId) {
        val listOld = gratiappWithId.value
        val listNew = mutableListOf<GratiappWithId>()

        listOld?.forEach { itemDaLista ->
            if (itemModificado.id == itemDaLista.id) {
                listNew.add(itemModificado)
            } else {
                listNew.add(itemDaLista)
            }
        }
        setGratiappWithId(listNew)
    }

    fun setGratiappWithId(value: List<GratiappWithId>) {
        _gratiappWithId.postValue(value)
    }

    private val _selectedGratiappWithId = MutableLiveData<GratiappWithId>()
    val selectedGratiappWithId: LiveData<GratiappWithId> = _selectedGratiappWithId

    private fun gratiappToGratiappWithId(gratiapp: Gratiapp, id: String): GratiappWithId {
        return GratiappWithId(
            nomeGratiapp = gratiapp.nomeGratiapp,
            data = gratiapp.data,
            humor = gratiapp.humor,
            agradecer = gratiapp.agradecer,
            id = id
        )
    }

    fun getGratiapps(): List<Gratiapp> {
        val lista = mutableListOf<Gratiapp>()
        repository.getGratiapps()
            .addOnSuccessListener{ documents ->
                for(document in documents){
                    val gratiapp = document.toObject<Gratiapp>()
                    lista.add(gratiapp)
                    Log.i(TAG, "document: ${document}")
                    Log.i(TAG, "Gratidão: ${gratiapp}")
                }
            }
            .addOnFailureListener{ exception ->
                Log.w(TAG, "Ocorreu um erro ao buscar registros salvos", exception)
            }
        return lista
    }

    fun deleteGratiapp(id: String) {
        repository.deleteGratiapp(id)
    }

    fun setSelectedGratiappWithId(value: GratiappWithId) {
        _selectedGratiappWithId.postValue(value)
    }

    private val _gratiapps = MutableLiveData<List<Gratiapp>>()
    val gratiapps: LiveData<List<Gratiapp>> = _gratiapps

    fun setGratiapps(value: List<Gratiapp>) {
        _gratiapps.postValue(value)
    }

    fun updateGratiapp(gratiapp: Gratiapp) {
        repository.updateGratiapp(selectedGratiappWithId.value?.id, gratiapp)
    }

    init {
        observeColecaoGratiapps()
    }

}