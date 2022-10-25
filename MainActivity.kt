package mx.edu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import mx.edu.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datos = listOf("+", "-", "x", "/")

        val adaptador = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, datos)

        binding.spTipo.adapter = adaptador

        binding.btnCalcular.setOnClickListener {
            var resultado = 0

            val val1 = binding.edtNum1.text.toString()
            val val2 = binding.edtNumber2.text.toString()

            if (val1 == "") {
                binding.txtResultado.text = "No has ingresado nada en el primer cuadro"

            } else if (val2 == "") {
                binding.txtResultado.text = "No has ingresado nada en el segundo cuadro"

            }else {
                val num1 = val1.toInt()
                val num2 = val2.toInt()

                when(binding.spTipo.selectedItem.toString()){
                    "+" -> resultado = num1 + num2
                    "-" -> resultado = num1 - num2
                    "x" -> resultado = num1 * num2
                    "/" -> resultado = num1 / num2
                    else -> resultado = 0

                }

                binding.txtResultado.text = resultado.toString()

            }
        }

        binding.btnLimpiar.setOnClickListener {
            binding.edtNum1.text = null
            binding.edtNumber2.text = null
            binding.txtResultado.text = null
        }
    }
}