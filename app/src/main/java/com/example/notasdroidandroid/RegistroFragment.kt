package com.example.notasdroidandroid

import android.database.Cursor
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        var UsuariosController = (RegistroFragment);

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

    fun CrearUsuario(){
        val usuario=Usuario(txtNombreRegistro.text.toString(),txtEmailRegistro.text.toString(),txtContrasenaRegistro.text.toString())
        UsuariosController.anadirUsuario(usuario)
    }

    fun SacarUsuarios(): String {
        var resultado=UsuariosController.leerUsuario()
        return resultado
    }
}