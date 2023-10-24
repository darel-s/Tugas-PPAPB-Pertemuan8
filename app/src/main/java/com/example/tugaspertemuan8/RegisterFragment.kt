package com.example.tugaspertemuan8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.Intent
import android.widget.Toast
import com.example.tugaspertemuan8.HomeActivity
import com.example.tugaspertemuan8.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToHome.setOnClickListener {
            if (isInputValid()) {
                val intent = Intent(activity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Harap isi semua field dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isInputValid(): Boolean {
        val username = binding.registerUsername.text.toString()
        val email = binding.registerEmail.text.toString()
        val phone = binding.registerPhone.text.toString()
        val password = binding.registerPassword.text.toString()

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            return false
        }

        return true
    }
}
