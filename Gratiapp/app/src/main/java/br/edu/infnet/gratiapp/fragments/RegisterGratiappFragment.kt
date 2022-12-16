package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.edu.infnet.gratiapp.databinding.FragmentRegisterGratiappBinding
import br.edu.infnet.gratiapp.models.Gratiapp
import br.edu.infnet.gratiapp.viewmodel.MainViewModel

class RegisterGratiappFragment : Fragment() {

    val viewModel by activityViewModels<MainViewModel>()
    private var _binding: FragmentRegisterGratiappBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterGratiappBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRegisterGratiapp.setOnClickListener {
            val gratiapp = getGratiappFromInputs()
            viewModel.registerGratiapp(gratiapp)
                .addOnSuccessListener {
                    toast("${gratiapp.nomeGratiapp} Cadastrada com sucesso.")
                }
                .addOnFailureListener {
                    //Log.w(Companion.TAG, "setupClickListeners: Failure")
                    toast("Falha ao cadastrar.")
                }
        }
    }

    private fun getGratiappFromInputs(): Gratiapp {
        binding.apply {
            return Gratiapp(
                nomeGratiapp = inputNome.text.toString(),
                data = inputData.text.toString(),
                humor = inputHumor.text.toString(),
                agradecer = inputAgradecer.text.toString()
            )
        }
    }

    private fun setupViews() {
        activity?.setTitle("Cadastrar Gratidão")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "Gratiapp"
    }
}