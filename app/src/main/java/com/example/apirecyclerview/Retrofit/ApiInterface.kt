package com.example.ehcf_doctor.Retrofit



import com.example.apirecyclerview.model.TherapyResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("therapies")
    fun therapies(): Call<TherapyResponse>

}