package com.medina.pokertinker.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.medina.pokertinker.Util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    val emptyFieldsError = MutableLiveData<Boolean>()
    val fieldsPasswordsError = MutableLiveData<Boolean>()
    val goSuccessActivity = MutableLiveData<Boolean>()

    fun OnCreate(){
        sharedPreferenceUtil=SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }
    fun validateInputs(email:String, password:String, username:String, password2: String){
        if (password.isEmpty() != password2.isEmpty()){
            emptyFieldsError.postValue(true)
        }
        if (email.isEmpty()){
            emptyFieldsError.postValue(true)
        }
        if(password.isEmpty()){
            emptyFieldsError.postValue(true)
        }
        if (password2.isEmpty()){
            emptyFieldsError.postValue(true)
        }
        if (username.isEmpty()){
            emptyFieldsError.postValue(true)
        }
    }
}