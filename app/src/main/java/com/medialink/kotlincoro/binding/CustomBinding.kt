package com.medialink.kotlincoro.binding

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.medialink.kotlincoro.LoadingState
import com.squareup.picasso.Picasso


@BindingAdapter(value = ["setImageUrl"])
fun ImageView.bindImageUrl(url: String?) {
    if (url != null && url.isNotBlank()) {

        Picasso.get()
            .load(url)
            .into(this)
    }
}

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerView(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter(value = ["setupVisibility"])
fun ProgressBar.progressVisibility(loadingState: LoadingState?) {
    loadingState?.let {
        val isVisible = when(it.status) {
            LoadingState.Status.RUNNING -> true
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED -> false
        }

        visibility = if(isVisible) View.VISIBLE else View.GONE
    }


}