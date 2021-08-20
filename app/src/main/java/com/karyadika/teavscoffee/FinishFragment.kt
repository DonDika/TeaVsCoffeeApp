package com.karyadika.teavscoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.karyadika.teavscoffee.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Mengganti title fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Selesai"

        val binding: FragmentFinishBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish, container, false)

        //Menerima arguments
        var args = FinishFragmentArgs.fromBundle(arguments!!)
        binding.tvExplain.text = args.result

        return binding.root
    }

}