package com.example.basecalculator

import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Анимации
        val alphaAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.alpha)

        //Обработчики основных кнопок
        btn_0.setOnClickListener {
            btn_0.startAnimation(alphaAnimation)
            if (math_operation.text.startsWith("0") && math_operation.length() == 1)

            else
                setTextFields("0")
        }
        btn_1.setOnClickListener {
            btn_1.startAnimation(alphaAnimation)
            setTextFields("1")
        }
        btn_2.setOnClickListener {
            btn_2.startAnimation(alphaAnimation)
            setTextFields("2")
        }
        btn_3.setOnClickListener {
            btn_3.startAnimation(alphaAnimation)
            setTextFields("3")
        }
        btn_4.setOnClickListener {
            btn_4.startAnimation(alphaAnimation)
            setTextFields("4")
        }
        btn_5.setOnClickListener {
            btn_5.startAnimation(alphaAnimation)
            setTextFields("5")
        }
        btn_6.setOnClickListener {
            btn_6.startAnimation(alphaAnimation)
            setTextFields("6")
        }
        btn_7.setOnClickListener {
            btn_7.startAnimation(alphaAnimation)
            setTextFields("7")
        }
        btn_8.setOnClickListener {
            btn_8.startAnimation(alphaAnimation)
            setTextFields("8")
        }
        btn_9.setOnClickListener {
            btn_9.startAnimation(alphaAnimation)
            setTextFields("9")
        }
        btn_Zup.setOnClickListener {
            btn_Zup.startAnimation(alphaAnimation)
            setTextFields(".")
        }
        btn_Procent.setOnClickListener {
            btn_Procent.startAnimation(alphaAnimation)
            setTextFields(("/100"))
        }

        //Обработчик доп.кнопок
        btn_Minus.setOnClickListener {
            btn_Minus.startAnimation(alphaAnimation)
            setTextFields("-")
            }
        btn_Plus.setOnClickListener {
            btn_Plus.startAnimation(alphaAnimation)
            setTextFields("+")
        }
        btn_Ymn.setOnClickListener {
            btn_Ymn.startAnimation(alphaAnimation)
            setTextFields("*")
        }
        btn_plusMinus.setOnClickListener {
            btn_plusMinus.startAnimation(alphaAnimation)
            setTextFields("*(-1)")
        }
        btn_Del.setOnClickListener {
            btn_Del.startAnimation(alphaAnimation)
            setTextFields("/")
        }
        btn_C.setOnClickListener {
            btn_C.startAnimation(alphaAnimation)
            math_operation.text = ""
            result_out.text = ""
        }
        btn_Backspace.setOnClickListener {
            btn_Backspace.startAnimation(alphaAnimation)
            val strInput = math_operation.text.toString()
            if (strInput.isNotEmpty())
                math_operation.text = strInput.dropLast(1)
            result_out.text = ""
        }


        btn_End.setOnClickListener {
            btn_End.startAnimation(alphaAnimation)
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build() //подключенная библиотека exp4j
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble()) {
                    longRes.toDouble()
                    result_out.text = longRes.toString().format("%.4f")
                }
                else
                    result_out.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    private fun setTextFields(str: String){
        if (result_out.text.isNotEmpty()) {
            math_operation.text = result_out.text
            result_out.text = ""
        }
        math_operation.append(str)
    }
}