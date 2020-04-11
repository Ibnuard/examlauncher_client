package com.ardclient.ccomplauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        var url: String = intent.getStringExtra("LINK")

        val handler = Handler()
        handler.postDelayed({
            Log.d("TAG", "URL : $url")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("URL", url)
            startActivity(intent)
            finish()
        }, 2500)
    }
}
