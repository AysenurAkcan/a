package com.aysenurakcan.dg_son;

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        val qry1 = "CREATE TABLE users (kullaniciAdi TEXT, eposta TEXT, yas INTEGER, boy INTEGER, kilo INTEGER, sifre TEXT)"
        sqliteDatabase.execSQL(qry1)
    }

    override fun onUpgrade(sqliteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Upgrade logic here
    }

    fun register(kullaniciAdi: String, eposta: String, yas: Int, boy: Int, kilo: Int, sifre: String) {
        val cv = ContentValues()
        cv.put("kullaniciAdi", kullaniciAdi)
        cv.put("eposta", eposta)
        cv.put("yas", yas)
        cv.put("boy", boy)
        cv.put("kilo", kilo)
        cv.put("sifre", sifre)

        val db = writableDatabase
        db.insert("users", null, cv)
        db.close()
    }

    fun login(username: String, password: String): Int {
        var result = 0
        val str = arrayOf(username, password)

        val db = readableDatabase
        val c = db.rawQuery("SELECT * FROM users WHERE kullaniciAdi=? AND sifre=?", str)

        if (c.moveToFirst()) {
            result = 1
        }
        c.close()
        db.close()

        return result
    }
}

