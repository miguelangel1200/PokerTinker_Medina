package com.medina.pokertinker.ui.view
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.medina.pokertinker.databinding.ActivityLoginBinding
import com.medina.pokertinker.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        val builder = AlertDialog.Builder(this)
        loginViewModel = LoginViewModel(this)
        loginViewModel.OnCreate()
        loginViewModel.emptyFieldsError.observe(this){
            builder.setTitle("Notificación").setMessage("Están vacios los campos").show()
        }
        loginViewModel.fieldsAuthenticateError.observe(this){
            builder.setTitle("Notificación").setMessage("Error del usuario o contraseña").show()
        }
        loginViewModel.goSuccessActivity.observe(this){
            val intent=Intent( this,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun startRegister(view: View){
        val intent=Intent( this, RegisterActivity::class.java)
        startActivity(intent)
    }
    fun startLogin(view: View){
        loginViewModel.validateInputs(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
    }
}