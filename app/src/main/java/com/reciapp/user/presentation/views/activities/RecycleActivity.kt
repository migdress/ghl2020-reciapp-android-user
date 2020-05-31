package com.reciapp.user.presentation.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.reciapp.user.R
import com.reciapp.user.presentation.states.ScoreState
import com.reciapp.user.presentation.viewModels.ScoreViewModel
import com.reciapp.user.utils.viewExtensions.visible
import kotlinx.android.synthetic.main.activity_recycle.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class RecycleActivity : AppCompatActivity() {

    private val scoreViewModel: ScoreViewModel by viewModel()

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        setToolbar()
        initObservers()

        scoreViewModel.getUserScore()
    }

    private fun initObservers() {
        scoreViewModel.getScoreLiveData.observe(this, Observer {
            renderPointState(it)
        })
    }

    private fun renderPointState(pointState: ScoreState) {
        when (pointState) {
            is ScoreState.Success -> {
                clpNavLoader.hide()
                txvPointsValue.apply {
                    visible()
                    text = pointState.points.toString()
                }
            }
            is ScoreState.Failure -> {
                clpNavLoader.hide()
                txvPointsValue.apply {
                    visible()
                    text = getString(R.string.general_empty_points)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        toolbar.title = ""
    }
}
