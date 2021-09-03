package com.light.hogwartslibrary.ui.scenes.hat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.light.hogwartslibrary.R

class HatActivity : AppCompatActivity() {

    private lateinit var hatViewModel: HatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hat)

        hatViewModel = ViewModelProvider(this).get(HatViewModel::class.java)
    }
}