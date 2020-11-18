package com.example.notasdroidandroid

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toFile
import java.io.File
import java.util.*

object Utilidades {
    /**
     * Función para opbtener el nombre del fichero
     */
    public fun crearNombreFichero(): String {
        return "camara-" + UUID.randomUUID().toString() + ".jpg"
    }

    /**
     * Salva un fichero en un directorio
     */
    fun salvarImagen(imagenDir: String, imagenNombre: String, context: Context): File? {
        return null
    }

    /**
     * Añade una imagen a la galería
     */
    fun añadirImagenGaleria(foto: Uri, nombre: String, context: Context): Uri? {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "imagen")
        values.put(MediaStore.Images.Media.DISPLAY_NAME, nombre)
        values.put(MediaStore.Images.Media.DESCRIPTION, "")
        values.put(MediaStore.Images.Media.DATA, foto.toFile().absolutePath)
        return context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

    }

     fun mandarCorreo(receptor:String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"

         val asunto:String = "Datos de NotasDroid"
         val mensaje:String="Mira estos datos de mi aplicacion Android!!!"


        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receptor))
        intent.putExtra(Intent.EXTRA_SUBJECT,asunto)
        intent.putExtra(Intent.EXTRA_TEXT,mensaje)
        try{
            //startActivity(Intent.createChooser(intent, "Enviar usando..."))
        }catch(e: Exception){

        }
    }

}