package com.yoenas.movietvshow.presentation.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.awesomedialog.AwesomeDialog
import com.example.awesomedialog.icon
import com.example.awesomedialog.onPositive
import com.example.awesomedialog.title
import com.yoenas.movietvshow.R
import com.yoenas.movietvshow.presentation.home.MainActivity
import com.yoenas.movietvshow.utils.NetworkHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        CoroutineScope(Main).launch {
            checkNetwork()
        }

    }

    private suspend fun checkNetwork() {
        delay(2000L)

        val statusNetwork = NetworkHelper.isNetworkConnected(this)
        if (statusNetwork) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            withContext(Main) {
                showAlert()
            }
        }
    }

    private fun showAlert() {
        AwesomeDialog.build(this)
            .title(getString(R.string.txt_no_internet))
            .icon(R.drawable.ic_congrts)
            .onPositive(getString(R.string.txt_go_to_setting)) {
                val intent = Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                startActivity(intent)
            }
    }

    override fun onRestart() {
        super.onRestart()
        CoroutineScope(Main).launch {
            checkNetwork()
        }
    }
}