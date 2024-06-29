package com.ba.optimizacionderutas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ba.optimizacionderutas.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setUp(email ?:"", provider ?:"")
    }

    private fun setUp(email: String, provider: String){
        binding.emailTextView.text = email
        binding.providerTextView.text = provider

        binding.logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressedDispatcher.onBackPressed()
        }

        binding.linkImageView1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        binding.linkImageView2.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.linkImageView3.setOnClickListener {
//            val intent = Intent(this, ThirdActivity::class.java)
//            startActivity(intent)
//        }
//
//        binding.linkImageView4.setOnClickListener {
//            val intent = Intent(this, FourthActivity::class.java)
//            startActivity(intent)
//        }
    }
}