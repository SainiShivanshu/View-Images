package com.example.assignment_chatwise_uk_limited.api

import com.example.assignment_chatwise_uk_limited.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getData():Call<ArrayList<ImageModel>>
}