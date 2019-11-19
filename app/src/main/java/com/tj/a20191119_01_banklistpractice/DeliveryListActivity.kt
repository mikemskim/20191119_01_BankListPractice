package com.tj.a20191119_01_banklistpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tj.a20191119_01_banklistpractice.adapters.CompanyAdapter
import com.tj.a20191119_01_banklistpractice.datas.CompanyData
import com.tj.a20191119_01_banklistpractice.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_delivery_list.*
import org.json.JSONObject

class DeliveryListActivity : BaseActivity() {

    var companyList = ArrayList<CompanyData>()
    var companyAdapter:CompanyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_list)

        setupEvent()
        setValue()
    }

    override fun setupEvent() {
    }

    override fun setValue() {
        getCompaniesFromServer()

        companyAdapter = CompanyAdapter(mContext, companyList)
        deliveryCompanyList.adapter = companyAdapter
    }

    fun getCompaniesFromServer() {
        ServerUtil.getRequestCompanyList(mContext, object : ServerUtil.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("응답확인", json.toString())

                val code = json.getInt("code")

                if (code == 200) {
                    val data = json.getJSONObject("data")
                    val banks = data.getJSONArray("company")

                    for (i in 0..(banks.length()-1)) {
                        var companyData =  CompanyData.getCompaniesFromJsonObject(banks.getJSONObject(i))
                        companyList.add(companyData)
                    }

                    runOnUiThread {
                        companyAdapter?.notifyDataSetChanged()
                    }

                } else {
                    Toast.makeText(mContext, "서버 통신에 문제가 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}
