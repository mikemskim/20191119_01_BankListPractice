package com.tj.a20191119_01_banklistpractice.datas

import org.json.JSONObject

class BankData(var id:Int, var code:String, var bankName:String, var bankLogoUrl:String) {
    init {
        id = 0
        code = ""
        bankName = ""
        bankLogoUrl = ""
    }
    
    companion object {
        
        fun getBankFromJsonObject(json:JSONObject) : BankData {
            var bank = BankData()
            
//           파싱 코드를 작성
            
            return bank
        }
    }
}