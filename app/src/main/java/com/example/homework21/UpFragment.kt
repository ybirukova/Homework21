package com.example.homework21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class UpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val background = view.findViewById<FrameLayout>(R.id.fragment_background)
        arguments?.getInt(COLOR)?.let { background.setBackgroundColor(it) }
    }

    companion object {
        private val COLOR = "color"

        fun newInstance(color: Int): UpFragment {
            val fragment = UpFragment()
            val args: Bundle = Bundle()
            args.putInt(COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }
}