package br.edu.infnet.gratiapp.repository

import br.edu.infnet.gratiapp.models.Gratiapp
import br.edu.infnet.gratiapp.models.UserInfo
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

const val TAG = "Gratiapp"

class GratiappRepository private constructor() {

    companion object {

        lateinit var auth: FirebaseAuth
        lateinit var db: FirebaseFirestore
        lateinit var colGratiapp: CollectionReference
        lateinit var colUserInfo: CollectionReference
        var userInfoCurrent: UserInfo? = null

        private var INSTANCE: GratiappRepository? = null
        fun initialize(){
            if(INSTANCE == null){
                INSTANCE = GratiappRepository()
            }
            auth = Firebase.auth
            db = Firebase.firestore
            
            colGratiapp = db.collection("gratidões")

            // Aqui pega a coleção de UserInfo (Informações complementares do cadastro)
            colUserInfo = db.collection("userinfo")


        }

        fun get(): GratiappRepository {
            return INSTANCE
                ?: throw IllegalStateException("GratiappRepository precisa ser inicializado!")
        }
    }

    fun getCurrentUser() = auth.currentUser

    fun isLoggedIn(): Boolean{
        return getCurrentUser()!=null
    }

    fun getUserInfo(uid: String) : Task<DocumentSnapshot> {
        return colUserInfo.document(uid).get()
    }

    fun registerUserWithPassword(email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
    }


    fun login(email: String, password: String): Task<AuthResult>{
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun logout(){
        auth.signOut()
    }

    fun registerUser(userInfo: UserInfo): Task<Void> {
        return colUserInfo.document(userInfo.usuarioId).set(userInfo)
    }

    fun registerGratiapp(gratiapp: Gratiapp): Task<DocumentReference>{
        return colGratiapp.add(gratiapp)
    }

    fun getGratiapps() : Task<QuerySnapshot>{
        return colGratiapp.get()
    }

    fun getGratiappColecao(): CollectionReference {
        return colGratiapp
    }

    fun deleteGratiapp(id: String){
        colGratiapp.document(id).delete()
    }

    fun updateGratiapp(id: String?, gratiapp: Gratiapp){
        if(id!=null){
            colGratiapp.document(id).set(gratiapp)
        }
    }
}