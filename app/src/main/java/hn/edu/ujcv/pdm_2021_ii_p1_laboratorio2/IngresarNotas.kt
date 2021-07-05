package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ingresar_notas.*

class IngresarNotas : AppCompatActivity() {

    var EnrollmentsRealized = HashMap<Students, ArrayList<Classes>>()
    var Accounts = ArrayList<Int>()
    var ClassesNames = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_notas)

        EnrollmentDataCollect()


//        Btn Handler
        btnSaveStntNotes.setOnClickListener{
            SaveStntNotes()
        }
    }

    fun EnrollmentDataCollect(){
        val intentValues = getIntent().extras

        if (intentValues?.get("EnrollmentsRegistered") != null){
            EnrollmentsRealized = intentValues["EnrollmentsRegistered"] as HashMap<Students, ArrayList<Classes>>
        }

        for (Enrollment in EnrollmentsRealized){
            Accounts.add(Enrollment.key.AccNumber)
        }

        var adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, Accounts)
        spinnerStntToEvaluate.adapter = adapter1
    }


    fun SaveStntNotes(){
        when{
            txtStntNoteIInsert.text.isEmpty()  	-> Toast.makeText(this,"Debe ingresar la nota del primer parcial", 	Toast.LENGTH_SHORT).show()
            txtStntNoteIIInsert.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar la nota del segundo parcial", Toast.LENGTH_SHORT).show()
            txtStntNoteIIInsert.text.isEmpty()  -> Toast.makeText(this,"Debe ingresar la nota del tercer parcial", 	Toast.LENGTH_SHORT).show()
            else -> {
        var itemClass = spinnerStntClassToEvaluate.selectedItem
        var StntToEvaluate = spinnerStntToEvaluate.selectedItem.toString().toInt()

        for (Enrollment in Students.Enrollment){
            if ( StntToEvaluate == Enrollment.key.AccNumber ){
                for (EnrollmentNote in Enrollment.value){
                    if (EnrollmentNote.CName.equals(itemClass)){
                        EnrollmentNote.gradesI = txtStntNoteIInsert.text.toString().toDouble()
                        EnrollmentNote.gradesII = txtStntNoteIIInsert.text.toString().toDouble()
                        EnrollmentNote.gradesIII = txtStntNoteIIInsert.text.toString().toDouble()
                    }
                }
            }
        }
            }
        }
    }
}