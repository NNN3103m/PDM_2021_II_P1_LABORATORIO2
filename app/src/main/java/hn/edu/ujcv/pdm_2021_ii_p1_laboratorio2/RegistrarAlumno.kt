package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder
import java.util.HashMap

class RegistrarAlumno : AppCompatActivity() {
    var StntValues : HashMap<Int, Students> = hashMapOf()
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_alumno)

//        Btn Handler
        btnOnBack2.setOnClickListener{onBackPressed()}
        btnSaveStnt.setOnClickListener{
            SaveStnt()
            PassStntData()
        }

    }


    fun SaveStnt(){
//        val dataStnt = StringBuilder()
//        number +=1
//        dataStnt.append(txtAccNumber.text.toString().trim()).append("|")
//        dataStnt.append(txtStntName.text.toString().trim()).append("|")
//        dataStnt.append(txtStntMail.text.toString())
//        StntValues.put(number, dataStnt.toString())
//        val intent = Intent(this,RegistrarClase::class.java)
//        intent.putExtra("valores alumno", StntValues)
//        startActivity(intent)

        when{
            txtAccNumber.text.isEmpty()  	-> Toast.makeText(this,"Debe ingresar su numero de cuenta", Toast.LENGTH_SHORT).show()
            txtStntName.text.isEmpty()  	-> Toast.makeText(this,"Debe ingresar su nombre completo", Toast.LENGTH_SHORT).show()
            txtStntMail.text.isEmpty()      -> Toast.makeText(this,"Debe ingresar su email", Toast.LENGTH_SHORT).show()
            else -> {
            val stntdata : Students = Students()
            stntdata.AccNumber  = txtAccNumber.text.toString().toInt()
            stntdata.StntName        = txtStntName.text.toString()
            stntdata.StntMail        = txtStntMail.text.toString()

            Students.Students.put(stntdata.AccNumber, stntdata)
            Toast.makeText(applicationContext, "Registro completado", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun PassStntData(){
        val intentStnt = Intent(this,MainActivity::class.java)
        startActivity(intentStnt)
    }

}