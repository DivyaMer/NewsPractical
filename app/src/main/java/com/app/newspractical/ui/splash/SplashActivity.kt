package com.app.newspractical.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivitySplashBinding
import com.app.newspractical.ktx.startNewActivity
import com.app.newspractical.ui.news_list.NewsListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val layoutId = R.layout.activity_splash

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moveToNext()
    }

    private fun moveToNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            startNewActivity(NewsListActivity::class.java, true)
        }, 3000)
    }

    override fun setUpObserver() {
        //TODO("Not yet implemented")
    }

    override fun init() {
        //TODO("Not yet implemented")
    }
}