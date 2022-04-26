package com.app.newspractical.ui.weview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityWebviewBinding
import com.app.newspractical.model.NewsModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WebviewActivity : BaseActivity<ActivityWebviewBinding, WebviewViewModel>() {

    override val layoutId = R.layout.activity_webview

    override val bindingVariable = BR.viewModel

    var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setUpObserver() {
    }

    override fun init() {

        val bundle = intent.extras
        if (bundle != null) {

            url = bundle.getString("url","")
        }
            binding.apply {
            // WebViewClient allows you to handle
            // onPageFinished and override Url loading.
            webView.webViewClient = WebViewClient()

            // this will load the url of the website
            webView.loadUrl(url)

            // this will enable the javascript settings
            webView.settings.javaScriptEnabled = true

            // if you want to enable zoom feature
            webView.settings.setSupportZoom(true)
        }
    }
}