package com.tes.app.view.base

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.tes.app.helper.Loading
import com.tes.app.helper.SessionManager
import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class BaseActivity : AppCompatActivity(){

    private var toast: Toast? = null
    lateinit var pLoading : Loading

    lateinit var BOLD: Typeface
    lateinit var SEMIBOLD: Typeface
    lateinit var REGUlAR: Typeface
    lateinit var ITALIC: Typeface

    lateinit var session: SessionManager
    lateinit var progressBar: ProgressBar

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pLoading = Loading(this)
        session = SessionManager(this)

        progressBar = ProgressBar(this)
    }

    fun toast(@StringRes message: Int) {
        toast(getString(message))
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    fun setOveridePendingTransisi(context: Activity) {
        try {
            context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    fun toast(toastMessage: String?) {
        if (toastMessage != null && !toastMessage.isEmpty()) {
            if (toast != null) toast!!.cancel()
            toast = Toast.makeText(this.applicationContext, toastMessage, Toast.LENGTH_LONG)
            toast!!.show()

        }
    }

}
