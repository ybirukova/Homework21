package com.example.homework21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment

class DownFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_down, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val colorsStr = resources.getStringArray(R.array.choice_of_the_color)
        val colorsInt = resources.getIntArray(R.array.color_array)
        val spinner = view.findViewById<Spinner>(R.id.spinner_color)

        if (spinner != null) {
            val adapter =
                ArrayAdapter(view.context, android.R.layout.simple_spinner_item, colorsStr)
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

                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .add(R.id.up_fragment, newFragment)
                    .commit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}