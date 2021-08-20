package com.karyadika.teavscoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //title fragment
        (activity as AppCompatActivity).supportActionBar?.title = "About Tea vs Coffee"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

}