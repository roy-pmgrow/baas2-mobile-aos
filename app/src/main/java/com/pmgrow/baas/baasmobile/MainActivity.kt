package com.pmgrow.baas.baasmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.pmgrow.baas.baasmobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.webview.webViewClient = WebViewClient()
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.loadUrl("http://192.168.0.143:3000/")
    }
}