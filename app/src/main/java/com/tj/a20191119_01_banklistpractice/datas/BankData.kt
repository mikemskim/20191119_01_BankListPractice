package com.tj.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class BankData() {

    var id = 0
    var code = ""
    var bankName = ""
    var bankLogoUrl = ""

    
    companion object {
        
        fun getBankFromJsonObject(json:JSONObject) : BankData {

            var bank = BankData()

//           파싱 코드를 작성

            bank.id = json.getInt("id")
            bank.code = json.getString("code")
            bank.bankName =  json.getString("name")
            bank.bankLogoUrl = json.getString("logo")
            
            return bank
        }
    }
}