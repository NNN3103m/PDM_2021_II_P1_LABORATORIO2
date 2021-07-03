package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class IngresarNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)



        val spinner = findViewById<Spinner>(R.id.spinnerStntToEvaluate)

        val list = listOf("Daniel el papu maravilla","Nestor Chaparrin","Godoys bebo guapo")

        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item, list)
        spinner.adapter = adaptador

    }
}