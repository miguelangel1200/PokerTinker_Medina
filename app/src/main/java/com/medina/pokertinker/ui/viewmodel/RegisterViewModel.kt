package com.medina.pokertinker.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medina.pokertinker.Data.model.User
import com.medina.pokertinker.Util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    val emptyName = MutableLiveData<Boolean>()
    val emptyEmail = MutableLiveData<Boolean>()
    val emptyPassword = MutableLiveData<Boolean>()
    val emptyPassword2 = MutableLiveData<Boolean>()
    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsPasswordsError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun OnCreate(){
        sharedPreferenceUtil=SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInputs(email:String, password:String, name:String, password2: String){
        val user = User(
            id="1",
            name = name,
            email = email,
            password = password,
            password2 = password2)
        sharedPreferenceUtil.saveFacebookUser(user)

        if ((password == password2) && name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()){
            goSuccessActivity.postValue(true)
        } else {
            if(name.isEmpty() && email.isEmpty() && password.isEmpty() && password2.isEmpty()){
                emptyFieldsError.postValue(true)
            } else if(name.isEmpty()) {
                emptyName.postValue(true)
            } else if(email.isEmpty()) {
                emptyEmail.postValue(true)
            } else if(password.isEmpty()) {
                emptyPassword.postValue(true)
            } else if(password2.isEmpty()) {
                emptyPassword2.postValue(true)
            }
        }
    }
}