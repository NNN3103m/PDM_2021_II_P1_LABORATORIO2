package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class RealizarMatricula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        //        Btn Handler
        btnOnBack3.setOnClickListener{onBackPressed()}
        btnSaveEnroll.setOnClickListener{}
    }
}