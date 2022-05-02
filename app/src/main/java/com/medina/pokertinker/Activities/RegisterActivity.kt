package com.medina.pokertinker.Activities
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.medina.pokertinker.Data.User
import com.medina.pokertinker.Util.SharedPreferenceUtil
import com.medina.pokertinker.databinding.ActivityRegisterBinding
class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun registerUser(view: View){
        val builder = AlertDialog.Builder(this)
        if (binding.edtEmail.text.isEmpty()){
            builder.setTitle("Notificación").setMessage("El email está vacio").show()
        } else if(binding.edtPassword.text.isEmpty()){
            builder.setTitle("Notificación").setMessage("La contraseña está vacio").show()
        } else if (binding.edtPassword2.text.isEmpty()){
            builder.setTitle("Notificación").setMessage("La confirmación de contraseña está vacio").show()
        } else if (binding.edtUserName.text.isEmpty()){
            builder.setTitle("Notificación").setMessage("el usuario está vacio").show()
        } else if (binding.edtPassword.text.toString() != binding.edtPassword2.text.toString()){
            builder.setTitle("Notificación").setMessage("No coinciden las contraseñas").show()
        } else {
            builder.setTitle("Notificación").setMessage("Cuenta creada con éxito").show()
            val user = User(
                "1",
                binding.edtUserName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString())

            sharedPreferenceUtil.saveFacebookUser(user)
            val intent = Intent(applicationContext, LoginActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    fun loginUser(view: View){
        val intent = Intent(applicationContext, LoginActivity::class.java)

        startActivity(intent)
    }
}