package com.example.homework21

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upFragment = UpFragment()
        val downFragment = DownFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.up_fragment, upFragment)
            .add(R.id.down_fragment, downFragment)
            .commit()
    }
}