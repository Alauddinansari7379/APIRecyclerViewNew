package com.example.apirecyclerview.activity

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apirecyclerview.adapter.AdapterTherapies
import com.example.apirecyclerview.databinding.ActivityMainBinding
import com.example.apirecyclerview.model.TherapyResponse
import com.example.ehcf_doctor.Retrofit.ApiInterface
import com.example.myrecyview.apiclient.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val context: Context = this@MainActivity
    private lateinit var binding:ActivityMainBinding
    var progressDialog : ProgressDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        apiCall()
    }

    private fun apiCall() {

        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog!!.setMessage("Loading..")
        progressDialog!!.setTitle("Please Wait")
        progressDialog!!.isIndeterminate = false
        progressDialog!!.setCancelable(true)
        progressDialog!!.show()

        ApiClient.apiService.therapies().enqueue(object :Callback<TherapyResponse>
        {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<TherapyResponse>,
                response: Response<TherapyResponse>
            )
            {
                binding.rvTherapy.apply {
                    adapter = AdapterTherapies(this@MainActivity, response.body()!!)
                    progressDialog!!.dismiss()

                }
            }


            override fun onFailure(call: Call<TherapyResponse>, t: Throwable) {

            }


        })
    }

}