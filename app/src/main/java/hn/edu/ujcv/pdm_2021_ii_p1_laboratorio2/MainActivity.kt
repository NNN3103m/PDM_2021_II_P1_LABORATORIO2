package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Menu Handler
        btnRegStnt.setOnClickListener{RegStnt()}
        btnRegClass.setOnClickListener{RegClass()}
        btnMkEnroll.setOnClickListener{MkEnroll()}
        btnEnterNotes.setOnClickListener{EnterNotes()}
    }

    fun RegStnt(){
        val intent = Intent(this,RegistrarAlumno::class.java)
        startActivity(intent)
    }

    fun RegClass(){
        val intent = Intent(this,RegistrarClase::class.java)
        startActivity(intent)
    }

    fun MkEnroll(){
        val intent = Intent(this,RealizarMatricula::class.java)
        startActivity(intent)
    }

    fun EnterNotes(){
        val intent = Intent(this,IngresarNotas::class.java)
        startActivity(intent)
    }
}