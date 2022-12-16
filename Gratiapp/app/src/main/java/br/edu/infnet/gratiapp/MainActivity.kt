package br.edu.infnet.gratiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import br.edu.infnet.gratiapp.databinding.ActivityMainBinding
import br.edu.infnet.gratiapp.models.UserInfo
import br.edu.infnet.gratiapp.repository.GratiappRepository
import br.edu.infnet.gratiapp.viewmodel.MainViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var repository: GratiappRepository

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        setup()
    }

    private fun setup() {
        repository = GratiappRepository.get()
        setupViews()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogout.setOnClickListener {
            repository.logout()
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun setupViews() {
        setTitle("Principal")
        var userId = FirebaseAuth.getInstance().currentUser!!.uid
        val documentReference = repository.getUserInfo(userId)
        documentReference
            .addOnSuccessListener { document ->
                if (document != null) {
                    binding.tvWelcome.text = "Olá ${document.get("usuarioNome")}"
                    Log.d(br.edu.infnet.gratiapp.repository.TAG, "DocumentSnapshot data: ${document}")
                } else {
                    Log.d(br.edu.infnet.gratiapp.repository.TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(br.edu.infnet.gratiapp.repository.TAG, "get failed with ", exception)
            }

    }
}