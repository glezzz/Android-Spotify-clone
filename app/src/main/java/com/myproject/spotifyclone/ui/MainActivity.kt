package com.myproject.spotifyclone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.myproject.spotifyclone.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// annotation used every time something is injected into any Android component
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}