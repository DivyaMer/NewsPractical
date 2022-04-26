package com.app.newspractical.ui.news_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.newspractical.base.BaseViewModel
import com.app.newspractical.model.NewsModel
import com.app.newspractical.network.APIConstant
import com.app.newspractical.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class NewsListViewModel @Inject constructor(private val repository: UserRepository) : BaseViewModel() {

    val newsResponseObservable: MutableLiveData<NewsModel> = MutableLiveData()

    fun getMainList(offset: Int = 1, limit: Int = 10) {
        var response: Response<NewsModel>? = null
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                response = repository.getNewsList()
            }
            withContext(Dispatchers.Main) {
                response?.run {
                    if (isSuccessful && code() == APIConstant.STATUS_SUCCESS)
                        newsResponseObservable.postValue(this.body())
                }
            }
        }
    }
}