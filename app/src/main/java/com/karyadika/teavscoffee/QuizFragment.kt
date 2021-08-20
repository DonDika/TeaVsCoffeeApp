package com.karyadika.teavscoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.karyadika.teavscoffee.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    //Membuat array daftar pertanyaan
    val questions = arrayOf("Apa yang kamu minum saat kerja?",
                            "Apa yang kamu minum saat sedang relax?",
                            "Apa yang kamu minum saat ingin menonton film?")
    //Membuat variabel untuk mengecek
    var coffeeScore      = 0
    var teaScore         = 0
    var currentQuestions = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        //Mengganti title fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Quiz"

        //Variabel data binding
        val binding: FragmentQuizBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz, container, false)

        //Textview pertanyaan
        binding.tvQuestion.text = questions[currentQuestions]

        //Ketika tombol teh dipencet menambahkan 1 skor
        binding.btnTea.setOnClickListener {
            teaScore++
            nextQuestions(binding)
        }
        //Ketika tombol kopi dipencet menambahkan 1 skor
        binding.btnCoffee.setOnClickListener {
            coffeeScore++
            nextQuestions(binding)
        }

        return binding.root
    }

    //Membungkus logika dengan sebuah fungsi untuk menghemat baris
    fun nextQuestions(binding: FragmentQuizBinding){
        currentQuestions++
        if (currentQuestions < questions.size){
            binding.tvQuestion.text = questions[currentQuestions]
            Toast.makeText(context,"Berhasil!!!  Teh: " +teaScore + "/ Kopi: " + coffeeScore
                                  ,Toast.LENGTH_SHORT).show()
        } else {
            var result = ""
            if (coffeeScore >= 1 && teaScore >= 1){
                result = "Kamu suka dua-duanya"
            } else if (coffeeScore < 1){
                result = "Kamu pecinta Teh"
            } else {
                result = "Kamu pecinta Kopi"
            }
            //Saat sudah selesai, passing data ke fragment berikutnya menggunakan Navigation Safe Args
            view!!.findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }
    }

}