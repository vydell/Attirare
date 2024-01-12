package com.beginning.attirare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_auth.*

class Auth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btnSignIn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}