package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.System.out

private val TAG= "MainActivity"
private val TEXT="TEXT_CONTENT"

class MainActivity : AppCompatActivity() {

    //private var btn1: Button?=null
    private var textView: TextView?=null
    private var textView2: TextView?=null
    var valor = 0
    var valor1 = 0
    var valor2 = 0
    var operacion = 0 //Suma 1 Resta 2 Mult 3 Div 4
    var resultado = 0
    var bandera = 0//0=enteros 1=decimales
    var contador = 1// de decimales

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"OnCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById<Button>(R.id.button1)
        val btn2: Button = findViewById<Button>(R.id.button2)
        val btn3: Button = findViewById<Button>(R.id.button3)
        val btn4: Button = findViewById<Button>(R.id.button4)
        val btn5: Button = findViewById<Button>(R.id.button5)
        val btn6: Button = findViewById<Button>(R.id.button6)
        val btn7: Button = findViewById<Button>(R.id.button7)
        val btn8: Button = findViewById<Button>(R.id.button8)
        val btn9: Button = findViewById<Button>(R.id.button9)
        val btn0: Button = findViewById<Button>(R.id.button0)
        val btnSuma: Button = findViewById<Button>(R.id.buttonSuma)
        val btnResta: Button = findViewById<Button>(R.id.buttonResta)
        val btnMult: Button = findViewById<Button>(R.id.buttonMult)
        val btnDiv: Button = findViewById<Button>(R.id.buttonDiv)
        val btnDot: Button = findViewById<Button>(R.id.buttonDOT)
        val btnEqual: Button = findViewById<Button>(R.id.buttonEqual)
        val btnBorrar: Button = findViewById<Button>(R.id.buttonBorrar)

        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView2 = findViewById<TextView>(R.id.textView2)
        textView2?.text = ""
        textView?.movementMethod= ScrollingMovementMethod()

        btn1?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(1)
            }
        })
        btn2?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(2)
            }
        })
        btn3?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(3)
            }
        })
        btn4?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(4)

            }
        })
        btn5?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(5)

            }
        })
        btn6?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(6)

            }
        })
        btn7?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(7)

            }
        })
        btn8?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(8)

            }
        })
        btn9?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(9)

            }
        })
        btn0?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                construirValor(0)

            }
        })
        btnSuma.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                operacion(1)
            }
        })
        btnResta.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                operacion(2)
            }
        })
        btnMult.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                operacion(3)
            }
        })
        btnDiv.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                operacion(4)
            }
        })
        btnEqual.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                valor2=valor

                when(operacion)
                {
                    1 -> resultado= valor1+valor2
                    2 -> resultado= valor1-valor2
                    3 -> resultado= valor1*valor2
                    4 -> resultado= valor1/valor2
                }

                textView2?.append(" = $resultado " )
                textView?.append(textView2?.text)
                textView?.append("\n")
                textView2?.text=""
                valor=0
                valor1=0
                valor2=0
            }
        })
        btnBorrar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                valor1=0
                valor=0
                valor2=0
                operacion = 0
                textView2?.text=("")

            }
        })
        btnDot.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                /*textView?.append("Decimales en desarrollo...")
                textView2?.text=("")
                valor1=0
                valor=0
                valor2=0
                operacion = 0
                textView2?.append(".")
                bandera=1*/


            }
        })
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT, "")
    }
    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())
    }
    fun construirValor(a: Int){

        if(bandera==0)
        {
            textView2?.append("$a")
            valor=(valor*10)+a
        }
        /*else
        {
            textView2?.append("$a")
            for (x in 1..contador)
            {
                b=b/10
            }
            contador=contador+1
            textView?.append(" al valor se le sumó: $b")
        }*/

    }
    fun operacion(b: Int)
    {
        contador=1
        valor1=valor
        when(b)
        {
            1 -> textView2?.append(" + " )
            2 -> textView2?.append(" - " )
            3 -> textView2?.append(" * " )
            4 -> textView2?.append(" / " )
        }
        when(b)
        {
            1 -> operacion=1
            2 -> operacion=2
            3 -> operacion=3
            4 -> operacion=4
        }
        valor=0
    }
}