package com.example.supplifyz.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.supplifyz.LoginActivity
import com.example.supplifyz.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit  var bindind: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindind = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.TVStartBTN.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}