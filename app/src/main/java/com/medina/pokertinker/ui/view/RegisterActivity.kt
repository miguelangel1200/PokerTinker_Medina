package com.medina.pokertinker.ui.view
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.medina.pokertinker.Data.model.User
import com.medina.pokertinker.ui.viewmodel.RegisterViewModel
import com.medina.pokertinker.databinding.ActivityRegisterBinding
class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val builder = AlertDialog.Builder(this)
        registerViewModel = RegisterViewModel(this)
        registerViewModel.OnCreate()

        registerViewModel.emptyFieldsError.observe(this) {
            builder.setTitle("Notificación").setMessage("Están vacios los campos").show()
        }
        registerViewModel.fieldsPasswordsError.observe(this) {
            if (binding.edtPassword.text.toString() != binding.edtPassword2.text.toString()) {
                builder.setTitle("Notificación").setMessage("No coinciden las contraseñas").show()
            } else {
                builder.setTitle("Notificación").setMessage("Cuenta creada con éxito").show()

            }
            registerViewModel.goSuccessActivity.observe(this) {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }

    fun registerUser(view: View) {
        registerViewModel.validateInputs(
            binding.edtEmail.text.toString(), binding.edtPassword.text.toString(),
            binding.edtUserName.text.toString(), binding.edtPassword2.text.toString()
        )
    }

    fun loginUser(view: View) {
        val intent = Intent(applicationContext, LoginActivity::class.java)

        startActivity(intent)
    }
}