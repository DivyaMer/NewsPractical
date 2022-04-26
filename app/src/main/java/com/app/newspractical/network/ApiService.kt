package com.app.newspractical.network

import com.app.newspractical.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(APIConstant.API_USERS)
    suspend fun getNewsList(
        @Query(APIConstant.PARAM_OFFSET) offset: Int,
        @Query(APIConstant.PARAM_LIMIT) limit: Int,
    ): Response<NewsModel>

}