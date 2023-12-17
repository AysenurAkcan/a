package com.aysenurakcan.dg_son

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuBotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_bot)
        val menuFragment=MenuFragment()
        val hesabimFragment=HesabimFragment()


        val bottomNavigationMenuView=findViewById<BottomNavigationView>(R.id.bottomNavigation)

        replaceFragment(menuFragment)
        bottomNavigationMenuView.setOnItemSelectedListener {
            when(it.itemId){
               R.id.ic_home->replaceFragment(menuFragment)
                R.id.ic_hesap->replaceFragment(hesabimFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment !=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }
    }
}