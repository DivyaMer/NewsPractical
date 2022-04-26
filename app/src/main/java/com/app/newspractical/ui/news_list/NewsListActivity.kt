package com.app.newspractical.ui.news_list

import android.os.Bundle
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListActivity : BaseActivity<ActivityUserListBinding, NewsListViewModel>() {

    override val layoutId = R.layout.activity_news_list

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpObserver() {
        TODO("Not yet implemented")
    }

    override fun init() {
        TODO("Not yet implemented")
    }
}