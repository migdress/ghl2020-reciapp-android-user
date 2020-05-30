package com.reciapp.user.presentation.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.reciapp.user.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        findNavController(R.id.fraNavigationLogin)
            .setGraph(R.navigation.login_nav_graph, intent.extras)
    }
}
