package com.ardclient.ccomplauncher

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class LoginActivity : AppCompatActivity() {
    private lateinit var btnLogin: CardView
    private lateinit var inputUrl: EditText
    private var LINK: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val mSettings: SharedPreferences = this.getSharedPreferences("Link", Context.MODE_PRIVATE)
        var oldLink: String? = mSettings.getString("link", "")

        btnLogin = findViewById(R.id.btnLogin)
        inputUrl = findViewById(R.id.inputUrl)

        if (oldLink!!.isNotEmpty()){
            inputUrl.setText(oldLink)
        }

        btnLogin.setOnClickListener {
            var url = inputUrl.text
            if (url.isNotEmpty()){
                LINK = url.toString()
                saveLink(LINK)

                val intent = Intent(this, LoadingActivity::class.java)
                intent.putExtra("LINK", LINK)
                startActivity(intent)
                finish()
            }else{
                inputUrl.error = "IP / URL tidak boleh kosong!"
            }
        }
    }

    private fun saveLink(url:String) {
        val mSettings: SharedPreferences = this.getSharedPreferences("Link", Context.MODE_PRIVATE)
        val editor = mSettings.edit()
        editor.putString("link", url)
        editor.apply()
    }
}
