package hn.edu.ujcv.pdm_2021_ii_p1_laboratorio2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_send_enroll_mail.*
import kotlinx.android.synthetic.main.activity_send_notes_mail.*
import kotlinx.android.synthetic.main.activity_send_notes_mail.messageEt
import kotlinx.android.synthetic.main.activity_send_notes_mail.recipientEt
import kotlinx.android.synthetic.main.activity_send_notes_mail.sendEmailBtn
import kotlinx.android.synthetic.main.activity_send_notes_mail.spinnerStntNotesMail
import kotlinx.android.synthetic.main.activity_send_notes_mail.subjectEt

class SendNotesMail : AppCompatActivity() {
    var CListItems    : ArrayList<Int> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_notes_mail)

        StntClassFetchData()
        //button click to get input and call sendEmail method
        sendEmailBtn.setOnClickListener {
            //get input from EditTexts and save in variables
            val recipient = recipientEt.text.toString().trim()
            val subject = subjectEt.text.toString().trim()
            val message = messageEt.text.toString().trim()


            //method call for email intent with these inputs as parameters
            sendNotesEmail(recipient, subject, message)
        }
        FetchStntNotesMail.setOnClickListener{
            CFetch()
        }

    }

    fun StntClassFetchData() {
        for (Account in Students.Enrollments){
            CListItems.add (Account.key.AccNumber)
        }
        var adapterNotesData = ArrayAdapter(this, android.R.layout.simple_list_item_1, CListItems)
        spinnerStntNotesMail.adapter = adapterNotesData
    }

    private fun CFetch(){
        var msg = ""
        var NotesDetails = ""
        var ActualStnt = spinnerStntNotesMail.selectedItem.toString().toInt()
        for(Enrollment in Students.Enrollments){
            if (Enrollment.key.AccNumber == ActualStnt) {
                messageEt.setText(Enrollment.key.StntMail)
                for (Classes in Enrollment.value) {
                    NotesDetails = NotesDetails + Classes.SendNotes() + "\n" + "\n"
                }
                msg = Enrollment.key.toString()+ "\n" + "\nLas notas obtenidas del alumno son: \n"+ "\n" + NotesDetails + "\n"
                messageEt.setText(msg)
            }
        }
    }

    private fun sendNotesEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

}

