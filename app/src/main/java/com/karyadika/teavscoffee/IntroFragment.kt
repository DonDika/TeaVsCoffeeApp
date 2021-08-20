package com.karyadika.teavscoffee

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.karyadika.teavscoffee.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {

        //Mengganti tittle fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Game Teh atau Kopi"

        //Data binding
        val binding: FragmentIntroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_intro, container, false)

        //Tombol mulai
        binding.btnStart.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_introFragment_to_quizFragment)
        )

        //Tombol option menu pada Action Bar
        //setHasOptionsMenu(true)

        return binding.root
    }

    /*Memanggil About yang kita buat
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }*/

    //Tombol option menu about
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }*/
}