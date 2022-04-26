package com.app.newspractical.ui.news_detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityNewsDetailBinding
import com.app.newspractical.ktx.loadImage
import com.app.newspractical.model.NewsModel
import com.app.newspractical.ui.image.ImageActivity
import com.app.newspractical.ui.news_list.NewsListViewModel
import com.app.newspractical.ui.weview.WebviewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailActivity : BaseActivity<ActivityNewsDetailBinding, NewsDetailViewModel>() {

    override val layoutId = R.layout.activity_news_detail

    override val bindingVariable = BR.viewModel

    private var data : NewsModel.Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setUpObserver() {
    }

    override fun init() {

        val bundle = intent.extras
        if (bundle != null) {

            data = bundle.getSerializable("data") as NewsModel.Article?

            binding.apply {
                tvTitleNews.text = data?.title
                tvAuthor.text = data?.author
                ivNews.loadImage(data?.urlToImage ?: "", R.drawable.ic_placeholder)
                tvLink1.text = data?.url
                tvTime.text = data?.publishedAt
                tvDesc.text = data?.description

                tvLink1.setOnClickListener {
                    val intent = Intent(this@NewsDetailActivity, WebviewActivity::class.java)
                    intent.putExtra("link", data?.url)
                    startActivity(intent)
                }

                ivNews.setOnClickListener {
                    val intent = Intent(this@NewsDetailActivity, ImageActivity::class.java)
                    intent.putExtra("image", data?.urlToImage)
                    startActivity(intent)
                }
            }
        }
    }
}