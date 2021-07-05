package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import kotlinx.android.synthetic.main.activity_registrar_clase.*
import java.io.Serializable
import java.lang.StringBuilder
import java.util.HashMap

class RegistrarClase : AppCompatActivity() {
    var ClassValues : HashMap<Int, String> = hashMapOf()
    var numberC = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_clase)


        //        Btn Handler
        btnOnBack.setOnClickListener{onBackPressed()}
        btnSaveClass.setOnClickListener{
            SaveClass()
            PassClassData()}

    }


    fun SaveClass(){
//        val dataClass = StringBuilder()
//        numberC +=1
//        dataClass.append(txtClassCode.text.toString().trim()).append("|")
//        dataClass.append(txtClassName.text.toString().trim()).append("|")
//        dataClass.append(txtClassSection.text.toString().trim()).append("|")
//        dataClass.append(txtClassTime.text.toString().trim()).append("|")
//        dataClass.append(txtLocation.text.toString())
//        ClassValues.put(numberC, dataClass.toString())
        when{
            txtClassCode.text.isEmpty()  	-> Toast.makeText(this,"Debe ingresar el código de la clase", 	Toast.LENGTH_SHORT).show()
            txtClassName.text.isEmpty()  	-> Toast.makeText(this,"Debe ingresar su nombre de la clase", 	Toast.LENGTH_SHORT).show()
            txtClassSection.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar la sección de la clase", 	Toast.LENGTH_SHORT).show()
            txtClassTime.text.isEmpty()     -> Toast.makeText(this,"Debe ingresar la hora de la clase", 	Toast.LENGTH_SHORT).show()
            txtLocation.text.isEmpty()      -> Toast.makeText(this,"Debe ingresar el Edificio-Piso-Aula", 	Toast.LENGTH_SHORT).show()
            else -> {
                val classdata : Classes = Classes()
                classdata.CCode   = txtClassCode.text.toString().toInt()
                classdata.CName   = txtClassName.text.toString()
                classdata.CSection  = txtClassSection.text.toString()
                classdata.CTime     = txtClassTime.text.toString()
                classdata.CLocation = txtLocation.text.toString()

                Classes.Classes.put(classdata.CCode, classdata)
                Toast.makeText(applicationContext, "Registro Completado", Toast.LENGTH_LONG).show()

        }

    }

    }
    fun PassClassData(){
        val intentClass = Intent(this,MainActivity::class.java)
        startActivity(intentClass)
    }
}


