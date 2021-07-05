package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var StntToEnroll: HashMap<Int, Students>? = hashMapOf()
    var ClassValues2 : HashMap<Int, Classes>? = hashMapOf()
    var EnrollmentsRegistered: HashMap<Students, ArrayList<Classes>> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GeneralDataCollect()
//      Menu Handler
        btnRegStnt.setOnClickListener{RegStnt()}
        btnRegClass.setOnClickListener{RegClass()}
        btnMkEnroll.setOnClickListener{MkEnroll()}
        btnEnterNotes.setOnClickListener{EnterNotes()}
        btnSendMailEnroll.setOnClickListener{SendMailEnroll()}
        btnSendMailNotes.setOnClickListener{SendMailNotes()}
    }

    fun GeneralDataCollect(){
        StntToEnroll = Students.Students
        ClassValues2 = Classes.Classes
        EnrollmentsRegistered = Students.Enrollments
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
        intent.putExtra("StntToEnroll", StntToEnroll)
        intent.putExtra("ClassValues2" , ClassValues2)
        startActivity(intent)
    }

    fun EnterNotes(){
        val intent = Intent(this,IngresarNotas::class.java)
        intent.putExtra("EnrollmentsRegistered",EnrollmentsRegistered)
        startActivity(intent)
    }

    fun SendMailEnroll() {
        val intent = Intent(this,SendEnrollMail::class.java)
        startActivity(intent)
    }

    fun SendMailNotes() {
        val intent = Intent(this,SendEnrollMail::class.java)
        startActivity(intent)
    }
}