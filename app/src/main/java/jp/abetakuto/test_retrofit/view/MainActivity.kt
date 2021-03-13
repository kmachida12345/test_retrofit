package jp.abetakuto.test_retrofit.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import jp.abetakuto.test_retrofit.R
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivityClass"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("onCreate: start")
        setContentView(R.layout.activity_main)
        Timber.d("onCreate: end")
    }

}