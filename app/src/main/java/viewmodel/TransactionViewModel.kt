package com.example.alkewallet_6.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewallet_6.data.api.RetrofitClient
import com.example.alkewallet_6.model.Transaction
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionViewModel : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>(emptyList())
    val transactions: LiveData<List<Transaction>> = _transactions

    fun cargarTransactions() {
        RetrofitClient.instance.getTransactions().enqueue(object : Callback<List<Transaction>> {

            override fun onResponse(
                call: Call<List<Transaction>>,
                response: Response<List<Transaction>>
            ) {
                if (response.isSuccessful) {
                    val lista = response.body() ?: emptyList()
                    _transactions.value = lista
                    Log.d("API_SUCCESS", "Transacciones cargadas: ${lista.size}")
                } else {
                    Log.e("API_ERROR", "Error en respuesta: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                Log.e("API_ERROR", "Fallo de conexión: ${t.message}")
            }
        })
    }

    fun addTransaction(transaction: Transaction) {
        val listaActual = _transactions.value?.toMutableList() ?: mutableListOf()
        listaActual.add(0, transaction)
        _transactions.value = listaActual
    }
}