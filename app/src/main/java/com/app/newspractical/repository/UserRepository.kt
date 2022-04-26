package com.app.newspractical.repository

import com.app.newspractical.model.NewsModel
import com.app.newspractical.network.ApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val service: ApiService) {

    suspend fun getNewsList(offset: Int = 10, limit: Int = 10): Response<NewsModel> {
        return service.getNewsList(offset, limit)
    }

}