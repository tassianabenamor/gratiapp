package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.edu.infnet.gratiapp.databinding.FragmentEditGratiappBinding
import br.edu.infnet.gratiapp.models.Gratiapp
import br.edu.infnet.gratiapp.viewmodel.MainViewModel

class EditGratiappFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentEditGratiappBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditGratiappBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupObservers()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            btnUpdateGratiapp.setOnClickListener {
                onAtualizarClick()
            }
        }
    }

    private fun onAtualizarClick() {
        val gratiapp = getGratiappFromInputs()
        viewModel.updateGratiapp(gratiapp)
        navUp()
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

    private fun setupObservers() {
        viewModel.selectedGratiappWithId.observe(viewLifecycleOwner){
            binding.apply {
                inputNome.setText(it.nomeGratiapp)
                inputData.setText(it.data)
                inputHumor.setText(it.humor)
                inputAgradecer.setText(it.agradecer)
            }
        }
    }

    private fun setupViews() {
        activity?.setTitle("Editar Gratidão")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}