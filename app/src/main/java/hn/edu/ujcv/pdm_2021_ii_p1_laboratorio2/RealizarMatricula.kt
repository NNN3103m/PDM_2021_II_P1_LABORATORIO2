package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_realizar_matricula.*
import kotlinx.android.synthetic.main.activity_registrar_alumno.*
import java.lang.StringBuilder

class RealizarMatricula : AppCompatActivity() {
//    val StntValues=intent.getStringExtra("valores alumno")
//    var StntToFetch : HashMap<Int, String> = hashMapOf()
//    var ClassToFetch : HashMap<Int, String> = hashMapOf()
//    var EnrollValues : HashMap<Int, String> = hashMapOf()
//    var number = 0
        var ListDisplay          : ArrayAdapter<String>? = null
        var StntValues    : HashMap<Int, Students> = hashMapOf()
        var Accounts    : ArrayList<Int> = ArrayList()
        var ClassValues3    : HashMap<Int, Classes> = hashMapOf()
        var ClassesNames     : ArrayList<String> = ArrayList()
        var listItems         : ArrayList<String> = ArrayList()
        var EnrollmentValues: HashMap<Students, ArrayList<Classes>> = hashMapOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_matricula)

        StntDataCollect()
        ClassDataCollect()
//        FetchStudentData()
//        FetchClassData()

        //        Btn Handler
        btnOnBack3.setOnClickListener{onBackPressed()}
        btnSaveSpinnerData.setOnClickListener(){
//                    SaveSpinnerData()
            SaveEnrollData()
        }

        btnAddClass.setOnClickListener{
            insertData()
        }
//        btnRegresarAlumno.setOnClickListener{returnAlumno()}

//      Spinner for Student
//        val spinnerStudentToEnroll = findViewById<Spinner>(R.id.spinnerEnrollStudent)
//        val list1 = listOf("Elija un Estudiante", StntToFetch)
//
//        val adaptador1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, list1)
//        spinnerStudentToEnroll.adapter = adaptador1


//      Spinner for Class
//        val classList = resources.getStringArray(R.array.class_list)
//        val spinnerClass = findViewById<Spinner>(R.id.spinnerEnrollClass)
//        if (spinnerClass != null) {
//            val adapter2 = ArrayAdapter(this,
//                android.R.layout.simple_spinner_item, classList)
//            spinnerClass.adapter = adapter2


//        val spinnerClassToStudent = findViewById<Spinner>(R.id.spinnerEnrollClass)
//        val list2 = listOf("Elija la clase", ClassToFetch)
//
//        val adaptador2 = ArrayAdapter(this,android.R.layout.simple_spinner_item, list2)
//        spinnerClassToStudent.adapter = adaptador2

    }


    fun SaveEnrollData(){
          if (listItems.size == 0){
              Toast.makeText(applicationContext, "Registre una clase", Toast.LENGTH_SHORT).show()
          }
          else {
              val ClassList = ArrayList<Classes>()
              for (Class in ClassValues3){
                  for (item in listItems){
                      if (Class.value.CName.equals(item)){
                          ClassList.add(Class.value)
                      }
                  }
              }

              val StntToEnroll = StntValues[spinnerEnrollStudent.selectedItem.toString().toInt()]!!

              Students.Enrollments.put(StntToEnroll, ClassList)

              Toast.makeText(applicationContext, "Alumno Matriculado", Toast.LENGTH_SHORT).show()
          }
    }

    fun StntDataCollect(){
          val intentValues = getIntent().extras

          if (intentValues?.get("StntToEnroll") != null){
              StntValues = intentValues["StntToEnroll"] as HashMap<Int, Students>
          }

          for (AccNumber in StntValues){
              Accounts.add(AccNumber.value.AccNumber)
          }

          var adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, Accounts)
          spinnerEnrollStudent.adapter = adapter1
    }


    fun  ClassDataCollect(){
          val intentValues = getIntent().extras

          if (intentValues?.get("ClassValues2") !=null){
              ClassValues3 = intentValues["ClassValues2"] as HashMap<Int, Classes>
          }

          for (cName in ClassValues3){
              ClassesNames.add(cName.value.CName)
          }

          var adapter2 = ArrayAdapter(this,android.R.layout.simple_spinner_item, ClassesNames)
          spinnerEnrollClass.adapter = adapter2
    }

    fun insertData(){

        var itemClass = ""
        itemClass = spinnerEnrollClass.selectedItem.toString()
        listItems.add(itemClass)
        ListDisplay?.notifyDataSetChanged()
        ListDisplay = ArrayAdapter(this,android.R.layout.simple_list_item_1, listItems)
        ClassList.adapter = ListDisplay
        Snackbar.make(Enroll, "Clase añadida", Snackbar.LENGTH_LONG).show()
    }
//    fun FetchStudentData(){
//        var EnrollStudent = ""
//        var counter = 0
//        var intentStntFetched = intent
//        StntToFetch = intentStntFetched.getSerializableExtra("valores alumno") as HashMap<Int, String>
//
//        for (valor1 in StntToFetch){
//            val list1 = valor1.toString().split("|").toTypedArray()
//            EnrollStudent = list1[0]
//            counter ++
//        }
//    }

//    fun FetchClassData(){
//        var ClassToEnrollStudent = ""
//        var counter2 = 0
//        var intentClassFetched = intent
//        ClassToFetch = intentClassFetched.getSerializableExtra("valores clase") as HashMap<Int, String>
//
//        for (valor2 in ClassToFetch){
//            val list2 = valor2.toString().split("|").toTypedArray()
//            ClassToEnrollStudent = list2[0]
//            counter2 ++
//        }
//    }




//    fun returnAlumno(){
//        val intent4 = Intent(this,RegistrarAlumno::class.java)
//        startActivity(intent4)
//    }


//    fun SaveSpinnerData(){
//        val EnrollDataClass = StringBuilder()
//        numberE +=1
//        val dataEnrollStnt: String = spinnerEnrollStudent.getSelectedItem().toString()
//        val dataEnrollClass: String = spinnerEnrollClass.getSelectedItem().toString()
//        EnrollValuesData.put(numberE, EnrollDataClass.toString())
//    }
//
//    fun SendEnroll(){
//        val intent3 = Intent(this,SendMail::class.java)
//        intent3.putExtra("valores matricula", EnrollValues)
//        startActivity(intent3)
//    }


//    private fun FetchStudentData() {
//        var EnrollStudent = ""
//        var counter = 0
//        var intentStntFetched = intent
//        StntToFetch = intentStntFetched.getSerializableExtra("valores alumno") as HashMap<Int, String>
//
//        for (valor1 in StntToFetch){
//            val list1 = valor1.toString().split("|").toTypedArray()
//            EnrollStudent = list1[0]
//            counter ++
//        }
//    }
}

