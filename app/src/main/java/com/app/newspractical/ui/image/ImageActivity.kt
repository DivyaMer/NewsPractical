package com.app.newspractical.ui.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.newspractical.BR
import com.app.newspractical.R
import com.app.newspractical.base.BaseActivity
import com.app.newspractical.databinding.ActivityImageBinding
import com.app.newspractical.databinding.ActivityImageBindingImpl
import com.app.newspractical.databinding.ActivityNewsDetailBinding
import com.app.newspractical.ktx.loadImage
import com.app.newspractical.ui.news_list.NewsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageActivity : BaseActivity<ActivityImageBinding, ImageViewModel>() {

    override val layoutId = R.layout.activity_image

    override val bindingVariable = BR.viewModel

    var image = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        image = intent.extras!!.getString("image", "")
        Log.e("tag image", image)

        binding.ivNews.loadImage(image, R.drawable.ic_placeholder)

    }

    override fun setUpObserver() {

    }

    override fun init() {
    }
}