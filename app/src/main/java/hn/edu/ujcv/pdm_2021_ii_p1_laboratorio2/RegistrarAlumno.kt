package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class RegistrarAlumno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_alumno)

//        Btn Handler
        btnOnBack2.setOnClickListener{onBackPressed()}
        btnSaveStnt.setOnClickListener{}

    }
}