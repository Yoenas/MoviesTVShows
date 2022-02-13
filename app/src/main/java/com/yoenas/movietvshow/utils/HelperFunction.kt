package com.yoenas.movietvshow.utils

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.provider.Settings
import com.example.awesomedialog.AwesomeDialog
import com.example.awesomedialog.icon
import com.example.awesomedialog.onPositive
import com.example.awesomedialog.title
import com.yoenas.movietvshow.R

object HelperFunction {
    fun showErrorConnectionAlert(activity: Activity?) {
        activity?.let {
            AwesomeDialog.build(activity)
                .title(activity.resources.getString(R.string.txt_no_internet))
                .icon(R.drawable.ic_congrts)
                .onPositive(activity.resources.getString(R.string.txt_go_to_setting)) {
                    val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        Intent(Settings.ACTION_WIFI_ADD_NETWORKS)
                    } else {
                        Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS)
                    }
                    activity.startActivity(intent)
                }.setCanceledOnTouchOutside(false)
        }
    }
}