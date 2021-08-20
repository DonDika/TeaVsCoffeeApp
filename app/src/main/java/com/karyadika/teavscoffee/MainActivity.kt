package com.karyadika.teavscoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.karyadika.teavscoffee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Data binding
    private lateinit var binding: ActivityMainBinding
    /*Drawer Layout
    private lateinit var drawerLayout: DrawerLayout*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Syntetic kotlin = setContentView(R.layout.activity_main)

        //Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Deklarasi secara langsung, val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        /*Drawer layout
        drawerLayout = binding.layoutDrawer*/

        //Tombol back pada Action Bar
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCtrl)

        //Menyambungkan NavigationUI ke navBottom
        NavigationUI.setupWithNavController(binding.navBottom, navCtrl)

        /*Menyambungkan NavigationUI ke navView
        NavigationUI.setupWithNavController(binding.navView, navCtrl)*/
    }

    //Tombol back pada Action Bar
    override fun onSupportNavigateUp(): Boolean {
        val navCtrl = this.findNavController(R.id.navhost_fragment)
        return navCtrl.navigateUp()
        //return NavigationUI.navigateUp(navCtrl, drawerLayout)
    }
}