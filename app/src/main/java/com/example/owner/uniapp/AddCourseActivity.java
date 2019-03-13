package com.example.owner.uniapp;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.owner.uniapp.dashboard.DashboardTabActivity;

import java.util.Calendar;

public class AddCourseActivity extends AppCompatActivity {
    private TextView tvAddCourse;
    private ImageButton imgPen,imgDay,imgHour1,imgHour2;
    private EditText edCourseName;
    private RadioButton rdSunday,rdMonday,rdTuesday,rdWensday,rdThursday;
    private Button btnSaveCourse,btn1,btn2;
    private TimePickerDialog.OnTimeSetListener timeSetListener2,timeSetListener3;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        edCourseName=(EditText)findViewById(R.id .edCourseName) ;
        tvAddCourse=(TextView) findViewById(R.id .tvAddCourse) ;
       btnSaveCourse=(Button)findViewById(R.id .btnSaveCourse) ;
        imgPen=(ImageButton) findViewById(R.id.imgPen);
        imgDay=(ImageButton) findViewById(R.id.imgDay);
        imgHour1=(ImageButton) findViewById(R.id.imgHour1);
        imgHour2=(ImageButton) findViewById(R.id.imgHour2);
        rdSunday=(RadioButton) findViewById(R.id.rdSunday);
        rdMonday=(RadioButton) findViewById(R.id.rdMonday);
        rdTuesday=(RadioButton) findViewById(R.id.rdTuesday);
        rdWensday=(RadioButton) findViewById(R.id.rdWensday);
        rdThursday=(RadioButton) findViewById(R.id.rdThursday);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                TimePickerDialog dialog3=new TimePickerDialog(AddCourseActivity.this,timeSetListener2,hour,minute, true);

                //todo ClipDrawable
                // dialog.getWindow().setBackgroundDrawable(new ClipDrawable(Color.TRANSPARENT));
                dialog3.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute=c.get(Calendar.MINUTE);
                TimePickerDialog dialog4=new TimePickerDialog(AddCourseActivity.this,timeSetListener3,hour,minute, true);
                //todo ClipDrawable
                // dialog.getWindow().setBackgroundDrawable(new ClipDrawable(Color.TRANSPARENT));
                dialog4.show();
            }
        });
        btnSaveCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
                Intent intent = new Intent(AddCourseActivity.this,DashboardTabActivity.class);
                startActivity(intent);


            }

        });

        timeSetListener3=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        };
        timeSetListener2 =new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }

        };
    }

    private void dataHandler() {
        String name=edCourseName.getText().toString();

    }

}
