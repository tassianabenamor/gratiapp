package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.gratiapp.R
import br.edu.infnet.gratiapp.databinding.FragmentGratiappBinding
import br.edu.infnet.gratiapp.adapters.GratiappWithIdAdapter
import br.edu.infnet.gratiapp.adapters.GratiappWithIdListener
import br.edu.infnet.gratiapp.models.GratiappWithId
import br.edu.infnet.gratiapp.viewmodel.MainViewModel

class GratiappFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentGratiappBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGratiappBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup(){
        setupViews()
        setupClickListeners()
        setupRecyclerView()
        setupObservers()
    }

    private fun setupClickListeners() {
        binding.btnRegisterGratiapp.setOnClickListener {
            nav(R.id.action_gratiappFragment_to_registerGratiappFragment)
        }
    }

    private fun setupViews() {
        activity?.setTitle("Gratidões")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        binding.rvGratiapps.adapter = adapter
        binding.rvGratiapps.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    private fun setupObservers() {
        viewModel.gratiappWithId.observe(viewLifecycleOwner) {
            atualizaRecyclerView(it)
        }
    }

    fun atualizaRecyclerView(lista: List<GratiappWithId>) {
        adapter.submitList(lista)
        binding.rvGratiapps.adapter = adapter
    }

}