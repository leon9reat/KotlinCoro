package com.medialink.kotlincoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.medialink.kotlincoro.databinding.ActivityMainBinding
import com.medialink.kotlincoro.viewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }
    private val userViewModel by viewModel<UserViewModel>()
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewModel = userViewModel
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userAdapter = UserAdapter()
        binding.adapter = userAdapter

        userViewModel.data.observe(this, Observer {
            Log.d(TAG, it.toString() )
            it.let(userAdapter::submitList)
        })
    }
}