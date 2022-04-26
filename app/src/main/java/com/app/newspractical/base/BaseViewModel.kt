package com.app.newspractical.base

import androidx.lifecycle.ViewModel
import com.app.newspractical.network.ApiService
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var provideApiService: ApiService
}