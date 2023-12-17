package com.aysenurakcan.dg_son

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView


class MenuFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val cardGunluk = view.findViewById<CardView>(R.id.cardGunluk)
        val cardKaloriBilgisi = view.findViewById<CardView>(R.id.cardKaloriBilgisi)

        cardGunluk.setOnClickListener {
            val intent = Intent(activity, GunlukActivity::class.java)
            startActivity(intent)
        }

        cardKaloriBilgisi.setOnClickListener {
            val intent = Intent(activity, KaloriBilgisiActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}