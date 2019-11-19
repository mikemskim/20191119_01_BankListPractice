package com.tj.a20191119_01_banklistpractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tj.a20191119_01_banklistpractice.R
import com.tj.a20191119_01_banklistpractice.datas.BankData

class BankAdapter(context: Context, res:Int, list: ArrayList<BankData>) : ArrayAdapter<BankData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<BankData>) : this (context, R.layout.bank_item_list, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.bank_item_list, null)
        }

        var row = tempRow!!

        var bankData = mList.get(position)

        var bankNameTxt = row.findViewById<TextView>(R.id.bankNameTxt)
        var bankLogoImg = row.findViewById<ImageView>(R.id.bankLogoImg)

        bankNameTxt.text = bankData.bankName
        Glide.with(mContext).load(bankData.bankLogoUrl).into(bankLogoImg)

        return row
    }
}