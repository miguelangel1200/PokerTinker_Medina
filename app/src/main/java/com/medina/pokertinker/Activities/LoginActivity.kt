package com.medina.pokertinker.Activities
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.medina.pokertinker.Data.User
import com.medina.pokertinker.MainActivity
import com.medina.pokertinker.databinding.ActivityLoginBinding
import com.medina.pokertinker.Util.SharedPreferenceUtil
class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        sharedPreferenceUtil=SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun validateInput(){
        if (binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            //agregar toast
        }
    }
    fun startRegister(view: View){
        val intent=Intent( this,RegisterActivity::class.java)
        startActivity(intent)
    }
    fun startLogin(view: View){

        val builder = AlertDialog.Builder(this)

        if (binding.edtEmail.text.isEmpty()){
            builder.setTitle("Notificación").setMessage("Error de Correo").show()
        }else{
            val user: User?=sharedPreferenceUtil.getUser()

            if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
                val intent=Intent( this,MainActivity::class.java)
                intent.putExtra("user",user)
                startActivity(intent)
            }else{
                builder.setTitle("Notificación").setMessage("Error de Usuario").show()
            }
        }

    }
}