package com.example.notasdroidandroid

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
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

}