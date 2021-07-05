package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class RealizarMatricula : AppCompatActivity() {
    var StntToFetch : HashMap<Int, String> = hashMapOf()
    var ClassToFetch : HashMap<Int, String> = hashMapOf()
    var EnrollValues : HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        FetchStudentData()
        FetchClassData()

        //        Btn Handler
        btnOnBack3.setOnClickListener{onBackPressed()}
        btnSaveEnroll.setOnClickListener{
                    SaveEnroll()
        }
        btnRegresarAlumno.setOnClickListener{returnAlumno()}

//      Spinner for Student
        val spinnerStudentToEnroll = findViewById<Spinner>(R.id.spinnerEnrollStudent)
        val list1 = listOf("Elija un Estudiante", StntToFetch)

        val adaptador1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, list1)
        spinnerStudentToEnroll.adapter = adaptador1


//      Spinner for Class
        val spinnerClassToStudent = findViewById<Spinner>(R.id.spinnerEnrollClass)
        val list2 = listOf("Elija la clase", ClassToFetch)

        val adaptador2 = ArrayAdapter(this,android.R.layout.simple_spinner_item, list2)
        spinnerClassToStudent.adapter = adaptador2

    }

    fun FetchStudentData(){
        var EnrollStudent = ""
        var counter = 0
        var intentStntFetched = intent
        StntToFetch = intentStntFetched.getSerializableExtra("valores alumno") as HashMap<Int, String>

        for (valor1 in StntToFetch){
            val list1 = valor1.toString().split("|").toTypedArray()
            EnrollStudent = list1[0]
            counter ++
        }
    }

    fun FetchClassData(){
        var ClassToEnrollStudent = ""
        var counter2 = 0
        var intentClassFetched = intent
        ClassToFetch = intentClassFetched.getSerializableExtra("valores clase") as HashMap<Int, String>

        for (valor2 in ClassToFetch){
            val list2 = valor2.toString().split("|").toTypedArray()
            ClassToEnrollStudent = list2[0]
            counter2 ++
        }
    }

    fun SaveEnroll(){
        val intent3 = Intent(this,IngresarNotas::class.java)
        intent3.putExtra("valores matricula", EnrollValues)
        startActivity(intent3)
    }

    fun returnAlumno(){
        val intent4 = Intent(this,RegistrarAlumno::class.java)
        startActivity(intent4)
    }
}