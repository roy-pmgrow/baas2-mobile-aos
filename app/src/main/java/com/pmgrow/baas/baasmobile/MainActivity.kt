package com.pmgrow.baas.baasmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
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
        binding.webview.settings.domStorageEnabled = true
        binding.webview.loadUrl("http://192.168.0.143:3000/")
        binding.webview.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                consoleMessage?.apply {
                    Log.d("MyApplication", "${message()} -- From line ${lineNumber()} of ${sourceId()}")
                }
                return true
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.webview.reload();
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}