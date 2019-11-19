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
import com.tj.a20191119_01_banklistpractice.datas.CompanyData

class CompanyAdapter(context: Context, res:Int, list: ArrayList<CompanyData>) : ArrayAdapter<CompanyData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<CompanyData>) : this (context, R.layout.delivery_company_item_list, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.delivery_company_item_list, null)
        }

        var row = tempRow!!
        var companyData = mList.get(position)

        var companyLogoImg = row.findViewById<ImageView>(R.id.companyLogoImg)
        var companyNameTxt = row.findViewById<TextView>(R.id.companyNameTxt)

        companyNameTxt.text = companyData.name
        Glide.with(mContext).load(companyData.logo).into(companyLogoImg)

        return row
    }
}