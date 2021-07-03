package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*

class RegistrarClase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)

        //        Btn Handler
        btnOnBack2.setOnClickListener{onBackPressed()}
        btnSaveClass.setOnClickListener{}
    }
}