package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.lang.StringBuilder
import java.util.HashMap

class RegistrarClase : AppCompatActivity() {
    var ClassValues : HashMap<Int, String> = hashMapOf()
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)

        //        Btn Handler
        btnOnBack.setOnClickListener{onBackPressed()}
        btnSaveClass.setOnClickListener{SaveClass()}


    }


    private fun SaveClass(){
        val dataClass = StringBuilder()
        number +=1
        dataClass.append(txtClassCode.text.toString().trim()).append("|")
        dataClass.append(txtClassName.text.toString().trim()).append("|")
        dataClass.append(txtClassSection.text.toString().trim()).append("|")
        dataClass.append(txtClassTime.text.toString().trim()).append("|")
        dataClass.append(txtLocation.text.toString())
        ClassValues.put(number, dataClass.toString())
        val intent2 = Intent(this,RealizarMatricula::class.java)
        intent.putExtra("valores clase", ClassValues)
        startActivity(intent)
    }
}