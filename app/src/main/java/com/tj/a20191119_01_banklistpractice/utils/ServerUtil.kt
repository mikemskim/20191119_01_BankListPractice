package com.tj.a20191119_01_banklistpractice.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface  jsonResponseHandler {
        fun onResponse(json: JSONObject)
    }

    companion object {

        var BASE_URL = "http://192.168.0.26:5000"

        fun getRequestBankList(context: Context, handler: jsonResponseHandler?) {
            var client = OkHttpClient()
            var urlBuilder = HttpUrl.parse("${BASE_URL}/info/bank")!!.newBuilder()
//          파라미터 첨부가 필요 없다.

            val requestUrl = urlBuilder.build().toString()
            Log.d("요청URL", requestUrl)

//            Intent와 비슷한 개념, 어디로 갈지 세팅 완료
//            실제 출발은 아직 안함
            val request = Request.Builder().url(requestUrl).build()


            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("서버통신에러", e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {
                    var body = response.body()!!.string()
                    Log.d("서버", body)
                    var json = JSONObject(body)

                    handler?.onResponse(json)
                }

            })
        }


        fun getRequestCompanyList(context: Context, handler: jsonResponseHandler?) {
            var client = OkHttpClient()
            var urlBuilder = HttpUrl.parse("${BASE_URL}/info/company")!!.newBuilder()
//          파라미터 첨부가 필요 없다.

            val requestUrl = urlBuilder.build().toString()
            Log.d("요청URL", requestUrl)

//            Intent와 비슷한 개념, 어디로 갈지 세팅 완료
//            실제 출발은 아직 안함
            val request = Request.Builder().url(requestUrl).build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("서버통신에러", e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {
                    var body = response.body()!!.string()
                    Log.d("서버", body)
                    var json = JSONObject(body)

                    handler?.onResponse(json)
                }

            })
        }
    }
}