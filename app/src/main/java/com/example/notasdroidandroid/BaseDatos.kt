package com.example.notasdroidandroid

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos(context: Context) : SQLiteOpenHelper(context, BDNOMBRE, null, BDVERSION) {
    companion object{
        private val BDVERSION=1
        private val BDNOMBRE="NotasDroid.bd"

        //Estructura de la tabla
        private val NOMBRETABLA="Usuario"
        private val COL_ID="ID"
        private val COL_NOMBRE="Nombre"
        private val COL_CONTRASENA="Contraseña"
        private val COL_EMAIL="Email"

    }


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE:String="Create table "+NOMBRETABLA+"(\n" +
                COL_ID+ " integer primary key,\n" +
                COL_NOMBRE+" text,\n" +
                COL_CONTRASENA+" text,\n" +
                COL_EMAIL +" text\n" +
                ")"
        db!!.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS "+ NOMBRETABLA)
        onCreate(db)
    }

}