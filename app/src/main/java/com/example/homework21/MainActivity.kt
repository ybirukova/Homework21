package com.example.homework21

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val upFragment = UpFragment()

        val colorsStr = resources.getStringArray(R.array.choice_of_the_color)
        val colorsInt = resources.getIntArray(R.array.color_array)
        val spinner = findViewById<Spinner>(R.id.spinner_color)

        if (spinner != null) {
            val adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, colorsStr)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val newFragment = UpFragment.newInstance(colorsInt[position])

                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.up_fragment, newFragment)
                    .commit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.up_fragment, upFragment)
            .commit()
    }
}