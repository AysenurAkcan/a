package com.aysenurakcan.dg_son

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public lateinit var kullaniciAdi: EditText
    public lateinit var sifre: EditText
    public lateinit var btn: Button
    public lateinit var btn2: Button
    public lateinit var baslik: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kullaniciAdi = findViewById(R.id.editTextText)
        sifre = findViewById(R.id.editTextTextPassword)
        btn = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        baslik = findViewById(R.id.textView2)

        btn.setOnClickListener(View.OnClickListener {
            val gkullaniciAdi = kullaniciAdi.text.toString()
            val gsifre = sifre.text.toString()
            val db = Database(applicationContext, "DiyetGünlüğüm", null, 1)
            if (kullaniciAdi.length() == 0 || sifre.length() == 0) {
                Toast.makeText(applicationContext, "Boşlukları doldurunuz", Toast.LENGTH_SHORT).show()
            } else {
                if (db.login(gkullaniciAdi, gsifre) == 1) {
                    Toast.makeText(applicationContext, "Giriş başarılı", Toast.LENGTH_SHORT).show()
                    val sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                    val editor = sharedpreferences.edit()
                    editor.putString("kullaniciAdi", gkullaniciAdi)
                    editor.apply()
                    startActivity(Intent(this@MainActivity,MenuBotActivity::class.java))
                } else {

                    Toast.makeText(applicationContext, "Geçersiz kullanıcı adı ve şifre", Toast.LENGTH_SHORT).show()
                }
            }
        })

        btn2.setOnClickListener {
            startActivity(Intent(this@MainActivity, KayitOlActivity::class.java))
        }
    }
}