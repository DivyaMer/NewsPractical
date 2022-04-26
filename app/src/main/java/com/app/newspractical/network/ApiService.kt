package com.app.newspractical.network

import com.app.newspractical.model.NewsModel
import com.app.newspractical.network.APIConstant.API_USERS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(API_USERS)
    suspend fun getNewsList(@Query("sources") source : String, @Query("apiKey") apiKey : String): Response<NewsModel>

}