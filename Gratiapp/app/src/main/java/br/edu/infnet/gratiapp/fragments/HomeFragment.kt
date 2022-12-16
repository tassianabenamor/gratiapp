package br.edu.infnet.gratiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.infnet.gratiapp.R
import br.edu.infnet.gratiapp.databinding.FragmentHomeBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        setup()
        return view
    }

    private fun setup() {
        setupViews()
        setupClickListeners()
    }

    private fun setupViews() {
        activity?.setTitle("Principal")
    }

    private fun setupClickListeners() {
        binding.apply {
            btnGratiapps.setOnClickListener {
                nav(R.id.action_homeFragment_to_gratiappFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}