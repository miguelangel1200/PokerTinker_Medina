package com.medina.pokertinker.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medina.pokertinker.Data.model.User
import com.medina.pokertinker.Util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldNameError = MutableLiveData<Boolean>()
    val fieldEmailError = MutableLiveData<Boolean>()
    val fieldPasswordError = MutableLiveData<Boolean>()
    val fieldsPassword2Error = MutableLiveData<Boolean>()
    val fieldPasswordAuthenticateError = MutableLiveData<Boolean>()
    val goSucessActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInput(name: String, email: String, password: String, password2: String) {
        val user = User(
            id = "1",
            name = name,
            email = email,
            password = password,
            password2 = password2)
        sharedPreferenceUtil.saveFacebookUser(user)

        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty() && (password == password2)) {
            goSucessActivity.postValue(true)
        }
        else {
            if (name.isEmpty() && email.isEmpty() && password.isEmpty() && password2.isEmpty()) {
                emptyFieldsError.postValue(true)
            } else if (name.isEmpty()) {
                fieldNameError.postValue(true)
            } else if (email.isEmpty()) {
                fieldEmailError.postValue(true)
            } else if (password.isEmpty()) {
                fieldPasswordError.postValue(true)
            } else if (password2.isEmpty())  {
                fieldsPassword2Error.postValue(true)
            }
            else if (password != password2) {
                if(password.isNotEmpty() && password2.isNotEmpty())
                    fieldPasswordAuthenticateError.postValue(true)
            }
        }
    }
}