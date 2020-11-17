package com.example.notasdroidandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed


class SplashActivity : AppCompatActivity() {
    private val tiempoEspera:Long=3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val main = Intent(this, MainActivity::class.java)

        Handler().postDelayed(Runnable {
            startActivity(main)
            finish()
        }, this.tiempoEspera)
    }

}

