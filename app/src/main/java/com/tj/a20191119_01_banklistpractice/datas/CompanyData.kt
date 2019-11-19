package com.tj.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class CompanyData() {
    var id = 0
    var name = ""
    var logo = ""

    companion object {

        fun getCompaniesFromJsonObject(json: JSONObject) : CompanyData {

            var company = CompanyData()

//           파싱 코드를 작성

            company.id = json.getInt("id")
            company.name =  json.getString("name")
            company.logo = json.getString("logo")

            return company
        }
    }
}