package com.app.newspractical.ui.weview

import android.os.Bundle
import android.util.Log
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
        url = intent.extras!!.getString("link", "")
        Log.e("tag web", url)

        binding.apply {
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
            webView.settings.javaScriptEnabled = true
            webView.settings.setSupportZoom(true)
        }
    }

    override fun setUpObserver() {
    }

    override fun init() {

    }
}