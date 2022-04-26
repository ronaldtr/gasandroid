package com.lyons.usat.gas.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.lyons.usat.gas.data.model.UserModel
import com.lyons.usat.gas.databinding.ActivityLoginBinding
import com.lyons.usat.gas.ui.viewmodel.UserViewModel
import com.lyons.usat.gas.util.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            signIn()
        }

        userViewModel.userModel.observe(this) {
            if (it?.code == 0) navigateToMain(it) else toast(this, it?.data.toString())
        }
    }

    private fun signIn() {
        val email = binding.txtEmail.text.toString().trim()
        val pass = binding.txtClave.text.toString().trim()

        if (this.checkEmptyFields(email, pass)) {
            toast(this, "Uno o ambos campos son vacíos")
        } else {
            // Create JSON using JSONObject
            val jsonObject = JsonObject()
            jsonObject.addProperty("email", "camacho@gmail.com")
            jsonObject.addProperty("password", "camacho")

            userViewModel.login(jsonObject)
        }
    }

    private fun checkEmptyFields(email: String, pass: String): Boolean {
        return email.isEmpty() || pass.isEmpty()
    }

    private fun navigateToMain(userModel: UserModel) {
        var gson = Gson()
        var userString = gson.toJson(userModel)

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("menus", userString)
        startActivity(intent)
    }
}