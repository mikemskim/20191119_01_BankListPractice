package com.tj.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tj.a20191119_01_banklistpractice.datas.BankData

class MainActivity : BaseActivity() {

    var bankList = ArrayList<BankData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvent()
        setValue()
    }

    override fun setupEvent() {
    }

    override fun setValue() {
        getBanksFromServer()
    }

    fun getBanksFromServer() {

    }
}
