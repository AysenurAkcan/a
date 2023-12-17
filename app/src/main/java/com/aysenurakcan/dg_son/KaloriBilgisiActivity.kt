package com.aysenurakcan.dg_son

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class KaloriBilgisiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalori_bilgisi)


        val corbalar=findViewById<CardView>(R.id.kartCorbalar)
        corbalar.setOnClickListener {
            val intent= Intent(this@KaloriBilgisiActivity,corbalarActivity::class.java)
            startActivity(intent)
        }

        val anaYemek =findViewById<CardView>(R.id.kartAnayemek)
        anaYemek.setOnClickListener {
            val intent=Intent(this@KaloriBilgisiActivity,anaOgunActivity::class.java)
            startActivity(intent)
        }

        val araOgun=findViewById<CardView>(R.id.kartAraOgun)
        araOgun.setOnClickListener {
            val intent=Intent(this@KaloriBilgisiActivity,araOgunActivity::class.java)
            startActivity(intent)
        }

        val fastFood=findViewById<CardView>(R.id.kartFastFood)
        fastFood.setOnClickListener {
            val intent=Intent(this@KaloriBilgisiActivity,fastFoodActivity::class.java)
            startActivity(intent)
        }

        val icecekler=findViewById<CardView>(R.id.kartIcecekler)
        icecekler.setOnClickListener {
            val intent=Intent(this@KaloriBilgisiActivity,iceceklerActivity::class.java)
            startActivity(intent)
        }

        val tatlilar=findViewById<CardView>(R.id.kartTatlilar)
        tatlilar.setOnClickListener {
            val intent=Intent(this@KaloriBilgisiActivity,tatlilarActivity::class.java)
            startActivity(intent)
        }

    }
}