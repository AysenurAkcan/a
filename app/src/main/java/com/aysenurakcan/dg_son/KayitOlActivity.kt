package com.aysenurakcan.dg_son

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class KayitOlActivity : AppCompatActivity() {

    public lateinit var kbaslıkKayıt: TextView
    public lateinit var kkullaniciAdi: EditText
    public lateinit var keposta: EditText
    public lateinit var kyas: EditText
    public lateinit var kboy: EditText
    public lateinit var kkilo: EditText
    public lateinit var ksifre: EditText
    public lateinit var ksifreTekrar: EditText
    public lateinit var kbtnKayit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kayit_ol)
        kbaslıkKayıt = findViewById(R.id.baslıkKayit)
        kkullaniciAdi = findViewById(R.id.kullaniciAdi)
        keposta = findViewById(R.id.eposta)
        kyas = findViewById(R.id.yas)
        kboy = findViewById(R.id.boy)
        kkilo = findViewById(R.id.kilo)
        ksifre = findViewById(R.id.sifre)
        ksifreTekrar = findViewById(R.id.sifre2)
        kbtnKayit = findViewById(R.id.btnKayit)

        fun isValid(passwordhere: String): Boolean {
            if (passwordhere.length < 8) {
                return false
            }

            var hasLetter = false
            var hasDigit = false
            for (p in 0 until passwordhere.length) {
                val c = passwordhere[p]
                if (Character.isLetter(c)) {
                    hasLetter = true
                } else if (Character.isDigit(c)) {
                    hasDigit = true
                }
            }

            return hasLetter && hasDigit
        }




        kbtnKayit.setOnClickListener {

            val kullaniciAdi = kkullaniciAdi.text.toString()
            val eposta = keposta.text.toString()
            val yas = kyas.text.toString()
            val boy = kboy.text.toString()
            val kilo = kkilo.text.toString()
            val sifre = ksifre.text.toString()
            val sifreTekrar=ksifreTekrar.text.toString()
            val db = Database(applicationContext, "DiyetGünlüğüm", null, 1)


            if ( kullaniciAdi.isEmpty() || eposta.isEmpty() || yas.isEmpty() || boy.isEmpty() || kilo.isEmpty()
                || sifre.isEmpty() || sifreTekrar.isEmpty()) {
                Toast.makeText(applicationContext, "Boşlukları doldurunuz.", Toast.LENGTH_SHORT).show()
            }
            else {
                if (sifre == sifreTekrar) {
                    if (isValid(sifre)) {
                        db.register(kullaniciAdi, eposta,yas.toInt(),boy.toInt(),kilo.toInt(),sifre )
                        Toast.makeText(applicationContext, "Kayıt Olundu", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@KayitOlActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(applicationContext, "Şifre harf veya rakamlardan oluşan en az 8 karakter içermelidir", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Parolalar eşleşmiyor", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}