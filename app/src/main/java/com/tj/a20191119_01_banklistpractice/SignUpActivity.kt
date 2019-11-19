package com.tj.a20191119_01_banklistpractice

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupEvent()
        setValue()
    }

    override fun setupEvent() {

        pwdEdt.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                Log.d("텍스트변경", s.toString())

                if (s.toString().length == 0) {
                    passwordStatusTxt.text = "비밀번호를 입력해 주세요."
                    passwordStatusTxt.setTextColor(Color.parseColor("#00EFEF"))
                } else if (s.toString().length < 6) {
                    passwordStatusTxt.text = "길이가 너무 짧습니다."
                    passwordStatusTxt.setTextColor(Color.parseColor("#FF0000"))
                } else {
                    passwordStatusTxt.text = "사용해도 좋은 비밀번호 입니다."
                    passwordStatusTxt.setTextColor(Color.parseColor("#0000FF"))
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


        })
    }

    override fun setValue() {
    }
}
