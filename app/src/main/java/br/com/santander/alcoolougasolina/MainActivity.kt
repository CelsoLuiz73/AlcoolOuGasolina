package br.com.santander.alcoolougasolina

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.santander.alcoolougasolina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            btnCalcular(it)
        }

    }

    fun btnCalcular(view: View) {
        val precoAlcool = binding.editTextPrecoAlcool.text.toString()
        val precoGasolina = binding.editTextPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if (validaCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            binding.textViewResultado.text = "Preencha os preços primeiro"
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
            binding.textViewResultado.setText("Melhor utilizar Gasolina")
        } else {
            binding.textViewResultado.setText("Melhor utilizar Álcool")
        }
    }
}