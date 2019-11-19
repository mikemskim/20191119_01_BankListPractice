package com.tj.a20191119_01_banklistpractice.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.tj.a20191119_01_banklistpractice.datas.BankData

class BankAdapter(context: Context, res:Int, list: ArrayList<BankData>) : ArrayAdapter<BankData>(context, res, list) {

    var mContext = context

}