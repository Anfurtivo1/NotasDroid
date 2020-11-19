package com.example.notasdroidandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_registro.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnIniciarSesion.setOnClickListener { abrirPrincipal() }
        btnRegistrarse.setOnClickListener { abrirRegistro() }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    /**
     * Se abre el fragment de registro
     */
    fun abrirRegistro(){
        val registro = RegistroFragment()
        val transaction = fragmentManager!!.beginTransaction()

//		//Llamamos al replace
        transaction.replace(R.id.nav_host_fragment, registro)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /**
     * Se abre el fragment principal
     */
    fun abrirPrincipal(){
        val principal = SecondFragment()
        val transaction = fragmentManager!!.beginTransaction()

//		//Llamamos al replace
        transaction.replace(R.id.nav_host_fragment, principal)
        transaction.addToBackStack(null)
        transaction.commit()
    }
/*
    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.run {
            //los recogemos de la interfaz
            putString("USUARIO", txtUsuario.text.toString())
            putString("CONTRASENA",txtContrasena.text.toString())
            Log.i("CICLO", "Salvando el estado")
        }
        // Siempre se llama a la superclase para salvar las cosas
        super.onSaveInstanceState(savedInstanceState)
    }
    */

    // Para recuperar el estado al volver a un estado de ciclo de vida de la Interfaz
    fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos del Bundle
        savedInstanceState.run {
            txtUsuario.setText(getString("RECEPTOR").toString())
            txtContrasena.setText(getString("ASUNTO").toString())
            Log.i("CICLO", "Recuperando el estado")
        }
    }

}