package sai1.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)


        }


    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedyear, selectedmonth, dayOfMonth ->


            val selectedDate = "$dayOfMonth/${selectedmonth+1}/$selectedyear"
            tvSelecteddate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            val seclecteddateinminutes = theDate!!.time/60000
            val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentdateinminutes = currentdate!!.time/60000
            val diffinminutes = currentdateinminutes - seclecteddateinminutes
            tvSelecteddateInMinutes.setText(diffinminutes.toString())
            Toast.makeText(this,"You are $diffinminutes minutes old", Toast.LENGTH_LONG).show()

        }

        ,year,month,day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }





    }
