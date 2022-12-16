package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import br.edu.infnet.gratiapp.R
import br.edu.infnet.gratiapp.adapters.GratiappWithIdAdapter
import br.edu.infnet.gratiapp.adapters.GratiappWithIdListener
import br.edu.infnet.gratiapp.databinding.FragmentViewGratiappBinding
import br.edu.infnet.gratiapp.models.GratiappWithId
import br.edu.infnet.gratiapp.viewmodel.MainViewModel


class ViewGratiappFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentViewGratiappBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewGratiappBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupListener()
        setupRecyclerView()
        setupObservers()
    }

    val adapter = GratiappWithIdAdapter(
        object : GratiappWithIdListener {
            override fun onEditClick(gratiapp: GratiappWithId) {
                viewModel.setSelectedGratiappWithId(gratiapp)
                nav(R.id.action_gratiappFragment_to_editGratiappFragment)
            }
            override fun onDeleteClick(gratiapp: GratiappWithId) {
                viewModel.deleteGratiapp(gratiapp.id)
            }
            override fun onViewClick(gratiapp: GratiappWithId){
                viewModel.setSelectedGratiappWithId(gratiapp)
                nav(R.id.action_gratiappFragment_to_viewGratiappFragment)
            }
        }
    )

    private fun setupRecyclerView() {
    }

    private fun setupListener() {
    }

    private fun setupObservers() {
        viewModel.selectedGratiappWithId.observe(viewLifecycleOwner){
            binding.apply {
                tvNomeGratiapp.text = it.nomeGratiapp
                tvData.text = it.data
                tvHumor.text = it.humor
                tvAgradecer.text = it.agradecer
            }
        }
    }

    private fun setupViews() {
        activity?.setTitle("Detalhes")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}