package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    /***
     * Responsável pela lógica de negócio da aplicação, verifica se o dado está correto, faz as
     * validações, faz as consultas no banco de dados, faz a requisição em alguma API e etc, o
     * ViewModel do MVVM é responsável pelos dados.
     */

    private var mRepository = PersonaRepository()

    private var mTextWelcome = MutableLiveData<String>()
    var textWelcome = mTextWelcome

    private var mLogin = MutableLiveData<Boolean>()
    var login = mLogin

    init {
        mTextWelcome.value = "Hello World!"
    }

    fun login(login: String) {
        val ret = mRepository.login(login)
        mLogin.value = ret
    }

}