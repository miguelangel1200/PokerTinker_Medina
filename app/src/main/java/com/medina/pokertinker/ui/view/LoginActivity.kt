package com.medina.pokertinker.ui.view
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.medina.pokertinker.databinding.ActivityLoginBinding
import com.medina.pokertinker.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)
        loginViewModel.onCreate()
        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this,"Ingrese los datos de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this,"Error de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSucessActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun startLogin(view: View){
        loginViewModel.validateInput(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
    }

    fun startRegister(view: View){
        val intent = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(intent)
    }
}