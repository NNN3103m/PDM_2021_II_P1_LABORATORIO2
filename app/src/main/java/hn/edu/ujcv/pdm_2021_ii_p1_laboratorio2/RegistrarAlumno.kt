package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder
import java.util.HashMap

class RegistrarAlumno : AppCompatActivity() {
    var StntValues : HashMap<Int, String> = hashMapOf()
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_alumno)

//        Btn Handler
        btnOnBack2.setOnClickListener{onBackPressed()}
        btnSaveStnt.setOnClickListener{SaveStnt()}

    }



    private fun SaveStnt(){
        val dataStnt = StringBuilder()
        number +=1
        dataStnt.append(txtAccNumber.text.toString().trim()).append("|")
        dataStnt.append(txtStntName.text.toString().trim()).append("|")
        dataStnt.append(txtStntMail.text.toString())
        StntValues.put(number, dataStnt.toString())
        val intent = Intent(this,RealizarMatricula::class.java)
        intent.putExtra("valores alumno", StntValues)
        startActivity(intent)
    }
}