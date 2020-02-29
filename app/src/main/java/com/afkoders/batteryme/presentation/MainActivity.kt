package com.afkoders.batteryme.presentation

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.main.MainFragment.Companion.PUSH_NOTIFICATION_EXTRA
import com.afkoders.batteryme.utils.extensions.navigateTo
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        /*with(window) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = Color.TRANSPARENT
        }*/


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (intent?.hasExtra(NOTIFICATION_INTENT) == true) {
            intent = null
            nav_host_fragment.findNavController().setGraph(R.navigation.push_notification_nav_graph, Bundle().apply {
                putBoolean(PUSH_NOTIFICATION_EXTRA, true)
            })
            /*nav_host_fragment.findNavController().navigate(R.id.mainFragment, Bundle().apply {
                putBoolean(PUSH_NOTIFICATION_EXTRA, true)
            })*/
        }
    }

    companion object {
        const val NOTIFICATION_INTENT = "NOTIFICATION_INTENT"
    }
}
