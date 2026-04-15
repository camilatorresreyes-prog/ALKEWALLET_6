package com.example.alkewallet_6.data.api

import com.example.alkewallet_6.model.Transaction
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("transactions")
    fun getTransactions(): Call<List<Transaction>>
}