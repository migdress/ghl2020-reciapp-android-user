package com.reciapp.user.presentation.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.reciapp.user.R

private const val TIMER_THREAD = 2500L

class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //se construye el hilo
        val timerThread: Thread = object : Thread() {
            override fun run() {
                try {
                    //Duracion en milisegundos en el que se muestra el splash
                    sleep(TIMER_THREAD)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    findNavController().navigate(R.id.loginFragment)
                }
            }
        }

        timerThread.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }
}
