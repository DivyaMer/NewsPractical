package com.app.newspractical.repository

import com.app.newspractical.model.NewsModel
import com.app.newspractical.network.ApiService
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val service: ApiService) {

    suspend fun getNewsList(): Response<NewsModel> {
        return service.getNewsList("google-news", "4862ca4e8f6d4774bee79ffa09b48882")
    }

}