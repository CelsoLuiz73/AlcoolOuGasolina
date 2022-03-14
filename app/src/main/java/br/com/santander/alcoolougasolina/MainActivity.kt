package br.com.santander.alcoolougasolina

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnCalcular(view: View){

        //para fazer o github

        /*capturar valores digitados - utilizando recursos do Java
        val precoAlcool = findViewById(R.id.editText_preco_alcool) as EditText
        val textoRecuperado = precoAlcool.text.toString()
        Log.i("Resultado", " Texto recuperado: $textoRecuperado ")*/

        val precoAlcool = editText_preco_alcool.text.toString()
        val precoGasolina = editText_preco_gasolina.text.toString()

        //mostra resultado de valores pegos no aplicativo
        /*Log.i("Resultado", " Texto recuperado: $precoAlcool ")
        Log.i("Resultado", " Texto recuperado: $precoGasolina ")*/

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else {
            textView_resultado.setText("Preencha os preços primeiro")
        }
    }

    fun validarCampos (precoAlcool: String, precoGasolina: String) : Boolean{
        var camposValidados: Boolean = true

        if (precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        //Converte valores string para números
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if (resultadoPreco >= 0.7){
            textView_resultado.setText("Melhor utilizar Gasolina")
        } else {
            textView_resultado.setText("Melhor utilizar Álcool")
        }

    }
}