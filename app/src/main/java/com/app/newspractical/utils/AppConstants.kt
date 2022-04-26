package com.app.newspractical.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.newspractical.R
import com.bumptech.glide.Glide

object AppConstants {

    interface SharedPrefKey {
        companion object {
            /*@JvmStatic
            @BindingAdapter("imageUrl")
            fun loadImage(
                view: ImageView,
                url: String,
                placeholder: Int = R.drawable.ic_placeholder
            ) {

                // This methods should not have any return type, = declaration would make it return that object declaration.
                Glide.with(view.context)
                    .load(url.toInt())
                    .placeholder(placeholder)
                    .error(placeholder)
                    .into(view)
            }*/
        }
    }
}