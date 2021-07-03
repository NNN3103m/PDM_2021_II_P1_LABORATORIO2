package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*

class RealizarMatricula : AppCompatActivity() {
    var StntToFetch : HashMap<Int, String> = hashMapOf()
    var ClassToFetch : HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

//        FetchStudentData()
//        FetchClassData()

        //        Btn Handler
        btnOnBack3.setOnClickListener{onBackPressed()}
        btnSaveEnroll.setOnClickListener{}

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

    private fun FetchStudentData(){
        var EnrollStudent = ""
        var counter = 0
        var intent = intent
        StntToFetch = intent.getSerializableExtra("valores alumno") as HashMap<Int, String>

        for (valor1 in StntToFetch){
            val list1 = valor1.toString().split("|").toTypedArray()
            EnrollStudent = list1[1]
//            counter ++
        }
    }

    private fun FetchClassData(){
        var ClassToEnrollStudent = ""
        var counter = 0
        var intent2 = intent
        ClassToFetch = intent2.getSerializableExtra("valores clase") as HashMap<Int, String>

        for (valor2 in ClassToFetch){
            val list2 = valor2.toString().split("|").toTypedArray()
            ClassToEnrollStudent = list2[1]
//            counter ++
        }
    }
}