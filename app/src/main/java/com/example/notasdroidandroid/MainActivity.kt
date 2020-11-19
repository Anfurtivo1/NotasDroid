package com.example.notasdroidandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.notasdroidandroid.Login
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }


    override fun onStart() {
        super.onStart()
        Log.i("Ciclo","Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo","Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo","Stop")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo","Pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo","Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo","Destroy")
    }

}