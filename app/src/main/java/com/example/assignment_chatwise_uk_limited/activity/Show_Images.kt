package com.example.assignment_chatwise_uk_limited.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_chatwise_uk_limited.Adapter.ImageAdapter
import com.example.assignment_chatwise_uk_limited.api.ApiInterface

import com.example.assignment_chatwise_uk_limited.databinding.ActivityShowImagesBinding
import com.example.assignment_chatwise_uk_limited.model.ImageModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class Show_Images : AppCompatActivity() {
    private lateinit var binding: ActivityShowImagesBinding
private lateinit var list: ArrayList<ImageModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityShowImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title="Images"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        list= ArrayList()

        val adapter=ImageAdapter(this,list)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)

        val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api:ApiInterface=retrofit.create(ApiInterface::class.java)

        val call :Call<ArrayList<ImageModel>> = api.getData()

call.enqueue(object : Callback<ArrayList<ImageModel>?>{
    override fun onResponse(
        call: Call<ArrayList<ImageModel>?>,
        response: Response<ArrayList<ImageModel>?>
    ) {

        if(response.isSuccessful){
            list.clear()

            for (myData in response.body()!!){
                list.add(myData)
            }
adapter.notifyDataSetChanged()
            binding.recyclerView.adapter=adapter
        }

    }

    override fun onFailure(call: Call<ArrayList<ImageModel>?>, t: Throwable) {
        Toast.makeText(this@Show_Images,"Error",Toast.LENGTH_SHORT).show()
    }

})


    }


    }


