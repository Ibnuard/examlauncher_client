package com.ardclient.ccomplauncher

import android.app.ActivityManager
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.icu.text.SymbolTable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webview)
        val exitBtn: TextView = findViewById(R.id.exitBtn)
        val url = intent.getStringExtra("URL")

        exitBtn.setOnClickListener {
            val mDialog = Dialog(this)
            mDialog.setContentView(R.layout.exit_dialog)
            mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.setCancelable(false)
            val okBtn: CardView = mDialog.findViewById(R.id.notifOk)
            val cancelBtn: CardView = mDialog.findViewById(R.id.notifCancel)

            okBtn.setOnClickListener {
                exitProcess(0)
                finish()
            }

            cancelBtn.setOnClickListener {
                mDialog.dismiss()
            }

            mDialog.show()
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.canGoForward()
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Toast.makeText(this,"You Are Not Allowed to Exit the App", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        val activityManager: ActivityManager = applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.moveTaskToFront(taskId, 0)
        Toast.makeText(this,"You Are Not Allowed to Exit the App", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        exitProcess(0)
    }
}
