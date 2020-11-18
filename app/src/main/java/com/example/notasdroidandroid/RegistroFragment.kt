package com.example.notasdroidandroid

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.fragment_registro.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistroFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val GALERIA = 1
    private val CAMARA = 2

    // Si vamos a operar en modo público o privado (es decir si salvamos en nuestro directorio)
    private var PUBLICO = false

    private val IMAGEN_DIR = "/NotasDroid"
    private lateinit var IMAGEN_URI: Uri
    private lateinit var IMAGEN_MEDIA_URI: Uri
    private var IMAGEN_NOMBRE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        ComprobarPermisos()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegistrarseRegistro.setOnClickListener { CrearUsuario() }
        var toast:Toast = Toast.makeText(context,"Se ha registrador el usuario",Toast.LENGTH_SHORT)
        btnRegistrarseRegistro.setOnClickListener { toast.show()}
        var usuarios=""
        btnMostrarRegistros.setOnClickListener { usuarios=SacarUsuarios() }
        var toast2:Toast = Toast.makeText(context,usuarios,Toast.LENGTH_SHORT)
        btnHacerFoto.setOnClickListener { hacerFoto() }

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun initDialogFoto() {
        val fotoDialogoItems = arrayOf(
            "Seleccionar fotografía de galería",
            "Capturar fotografía desde la cámara"
        )
        /*
        // Creamos el dialog con su builder
        AlertDialog.Builder(this)
            .setTitle("Seleccionar Acción")
            .setItems(fotoDialogoItems) { dialog, modo ->
                when (modo) {
                    0 -> elegirFotoGaleria()
                    1 -> hacerFoto()
                }
            }
            .show()*/
    }

    private fun CrearUsuario(){
        val usuario=Usuario(txtNombreRegistro.text.toString(),txtEmailRegistro.text.toString(),txtContrasenaRegistro.text.toString())
        UsuariosController.anadirUsuario(usuario)
    }

    private fun SacarUsuarios(): String {
        var resultado=UsuariosController.leerUsuario()
        return resultado
    }

    private fun hacerFoto(){

        // Si queremos hacer uso de fotos en alta calidad
        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())

        // Eso para alta o baja resolucion
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        // Nombre de la imagen
        IMAGEN_NOMBRE = Utilidades.crearNombreFichero()
        // Salvamos el fichero
        //val fichero = Utilidades.salvarImagen(IMAGEN_DIR, IMAGEN_NOMBRE, this)!!
        //IMAGEN_URI = Uri.fromFile(fichero)

        //intent.putExtra(MediaStore.EXTRA_OUTPUT, IMAGEN_URI)
        // Esto para alta y baja
        startActivityForResult(intent, CAMARA)
    }

    /**
     * Elige una foto de la galeria
     */
    private fun elegirFotoGaleria() {
        val intentGaleria = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(intentGaleria, GALERIA)
    }

    /**
     * Comprobamos los permisos de la aplicación
     */
    private fun ComprobarPermisos() {
        // Indicamos el permisos y el manejador de eventos de los mismos
        Dexter.withContext(activity)
            // Lista de permisos a comprobar
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            // Se va a ejecutar un listener
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    // comprobamos si tenemos todos los permisos necesarios
                    if (report.areAllPermissionsGranted()) {
                        Toast.makeText(context, "¡Se han podido verificar todos los permisos!", Toast.LENGTH_SHORT).show()
                    }

                    // En caso de que no tuvieramos algun permiso concedido hariamos lo siguiente
                    if (report.isAnyPermissionPermanentlyDenied) {
                        // abrimos un diálogo a los permisos
                        //openSettingsDialog();
                    }
                }

                //Aqui mostraremos un toast en caso de que falte algún permiso
                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            }).withErrorListener { Toast.makeText(context, "Existe errores! ", Toast.LENGTH_SHORT).show() }
            .onSameThread()
            .check()
    }

}