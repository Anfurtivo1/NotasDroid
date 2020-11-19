package com.example.notasdroidandroid

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

object UsuariosController {
    private var ayudanteBaseDeDatos: BaseDatos? = null
    private val NombreTabla = "Usuario"

    fun MascotasController(contexto: Context?) {
        ayudanteBaseDeDatos = contexto?.let { BaseDatos(it) }
    }

    /**
     * Para añadir usuarios
     */
    fun anadirUsuario(usuario: Usuario): Long {

        val sqlite = ayudanteBaseDeDatos!!.writableDatabase
        val valoresParaInsertar = ContentValues()
        valoresParaInsertar.put("Nombre", usuario.nombre)
        valoresParaInsertar.put("Email", usuario.email)
        valoresParaInsertar.put("Contrase�a", usuario.contrasena)
        return sqlite.insert(NombreTabla, null, valoresParaInsertar);

    }

    /**
     * Para leer Usuarios
     */
    fun leerUsuario(): String {
        var resultado=""
        val columnasAConsultar = arrayOf("nombre", "email", "contrasena")
        val c:Cursor
        val baseDeDatos = ayudanteBaseDeDatos!!.readableDatabase
        c=baseDeDatos.query(NombreTabla,columnasAConsultar,
            null,
            null,
            null,
            null,
            null)

        do {
            // El 0 es el numero de la columna, como seleccionamos
            // nombre, email,contrasena entonces el nombre es 0, email 1 y contrasena es 2
            val nombreObtenidoDeBD: String = c.getString(0)
            val emailObtenidoDeBD: String = c.getString(1)
            val contrasena: String = c.getString(2)
            resultado=resultado+" Nombre: "+nombreObtenidoDeBD+" email: "+emailObtenidoDeBD+" contrasena "+contrasena
        } while (c.moveToNext())
        c.close()
        return resultado
    }

}