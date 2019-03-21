package com.example.owner.uniapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.owner.uniapp.dashboard.DashboardTabActivity2;
import com.example.owner.uniapp.dashboard.Exams;
import com.example.owner.uniapp.new1.MainActivity;
import com.example.owner.uniapp.new1.StudentEvent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddExamActivity extends AppCompatActivity {
    private static String[]Type=new String[]{"Exam","HomeWork","Assingment","Meet"};

    private static final String TAG = "AddExamActivity";
    private TextView tvAddEvent, tvDate2, tvSave;
    private EditText edEventName,ed1,edCourseTitle,lecturerName,edFreeText;

    private Button btnExamDate, btnTimePicker1, btnTimePicker2;
    //private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener1, onTimeSetListener1;
    private int mYear, mMonth, mDay;
    //private int mhour, mmunite;
    //private int HourOfTheDay, Minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam3);

        btnExamDate = (Button) findViewById(R.id.btnExamDate);
        //btnTimePicker1 = (Button) findViewById(R.id.btnTimePicker1);
       // btnTimePicker2 = (Button) findViewById(R.id.btnTimePicker2);
        tvAddEvent= (TextView) findViewById(R.id.tvAddEvent);
        tvSave = (TextView) findViewById(R.id.tvSave);
        //tvExamHour1 = (TextView) findViewById(R.id.tvExamHour1);
//        TvHour2 = (TextView) findViewById(R.id.TvHour2);
        //tvDate2 = (TextView) findViewById(R.id.tvDate2);
        edEventName = (EditText) findViewById(R.id.edEventName);
        ed1 = (EditText) findViewById(R.id.ed1);
        edCourseTitle= (EditText) findViewById(R.id.edCourseTitle);
       lecturerName= (EditText) findViewById(R.id.lecturerName);
        edFreeText= (EditText) findViewById(R.id.edFreeText);


        //ed2 = (EditText) findViewById(R.id.ed2);
       // ed3 = (EditText) findViewById(R.id.ed3);


        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();


            }
        });


        //timeSetListener1=new TimePickerDialog.OnTimeSetListener() {
        //  @Override
        // public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        // }

        //};
        //   onTimeSetListener1 =new TimePickerDialog.OnTimeSetListener() {
        //@Override
        //public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        //   }

        //};
    }

    private void dataHandler() {
        boolean isok = true;
        String Type = edEventName.getText().toString();
        String CourseTitle = edCourseTitle.getText().toString();
        String LecturerName=lecturerName.getText().toString();
        String FreeText=edFreeText.getText().toString();
        String Time=ed1.getText().toString();
        if (Type.length() == 0) {
            edEventName.setError("Name can not be empty");
            isok = false;
        }
        if (isok) {
            final StudentEvent studentEvent=new StudentEvent();
            studentEvent.setCourseTitle(CourseTitle);
            studentEvent.setFreeText(FreeText);
            studentEvent.setLecturerName(LecturerName);
            studentEvent.setType(Type);
            studentEvent.setEventTime(Time);
            //get user email to set is as the owner fo this exam
            FirebaseAuth auth = FirebaseAuth.getInstance();
            //to get the database root reference
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            //to get uid
            String key = reference.child("MyEvents").push().getKey();
            studentEvent.setKey(key);
            reference.child("MyEvents").child(key).setValue(studentEvent).addOnCompleteListener(new OnCompleteListener<Void>() {

                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(AddExamActivity.this, "Add Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AddExamActivity.this,MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddExamActivity.this, "Add Faild" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    public void onClick(View v) {

        if (v == btnExamDate) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            c.set(Calendar.YEAR, year);
                            c.set(Calendar.MONTH, monthOfYear);
                            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                            ed1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

       // if (v == btnTimePicker1) {

            // Get Current Date
            //final Calendar c = Calendar.getInstance();
            //mhour = c.get(Calendar.HOUR);
          //  mmunite = c.get(Calendar.MINUTE);
            //mDay = c.get(Calendar.DAY_OF_MONTH);


           // TimePickerDialog timePickerDialog = new TimePickerDialog(AddExamActivity.this, timeSetListener1, mhour, mmunite, true)
           // {
              //  public void onTimeSet (TimePicker View ,int mhour,
              //  int mmuntie)
              //  {
                //    c.set(Calendar.HOUR, mhour);
                 //   c.set(Calendar.MINUTE, mmunite);
                    //c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                  //  ed2.setText(mhour + "-" + mmuntie + "-");

              //  }
           // } ;
           // timePickerDialog.show();
        //}
        //if (v == btnTimePicker2) {

            // Get Current Date
           // final Calendar c = Calendar.getInstance();
           // HourOfTheDay = c.get(Calendar.HOUR);
           // Minute = c.get(Calendar.MINUTE);
            //mDay = c.get(Calendar.DAY_OF_MONTH);

           // TimePickerDialog timePickerDialog = new TimePickerDialog(AddExamActivity.this, onTimeSetListener1, HourOfTheDay, Minute, true)

            //{
              //  public void onTimeSet (TimePicker View ,int HourOfTheDay, int Minute)
              //  {
                  //  c.set(Calendar.HOUR, HourOfTheDay);
                  //  c.set(Calendar.MINUTE,Minute);
                    //c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                   // ed2.setText(HourOfTheDay + "-" + Minute + "-");

             //   }


          //  };
           // timePickerDialog.show();

       // }
    }

}







