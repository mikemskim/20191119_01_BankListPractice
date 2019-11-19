package com.tj.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    var mContext = this

    abstract fun setupEvent()
    abstract fun setValue()
}