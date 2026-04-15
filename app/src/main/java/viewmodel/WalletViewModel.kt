package com.example.alkewallet_6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletViewModel : ViewModel() {

    private val _saldo = MutableLiveData(0)
    val saldo: LiveData<Int> = _saldo

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> = _mensaje

    fun depositar(monto: Int) {
        val actual = _saldo.value ?: 0
        _saldo.value = actual + monto
        _mensaje.value = "Depósito realizado con éxito"
    }

    fun retirar(monto: Int) {
        val actual = _saldo.value ?: 0

        if (monto > actual) {
            _mensaje.value = "Saldo insuficiente"
        } else {
            _saldo.value = actual - monto
            _mensaje.value = "Retiro realizado correctamente"
        }
    }

}