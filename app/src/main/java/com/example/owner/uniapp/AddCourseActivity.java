package com.example.owner.uniapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddCourseActivity extends AppCompatActivity {
    private TextView tvAddCourse;
    private ImageButton imgPen,imgDay,imgHour1,imgHour2;
    private EditText edCourseName,edEndHour,edStartHour;
    private RadioButton rdSunday,rdMonday,rdTuesday,rdWensday,rdThursday;
    private Button btnSaveCourse;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        edCourseName=(EditText)findViewById(R.id .edCourseName) ;
        edEndHour=(EditText)findViewById(R.id .edEndHour) ;
        edStartHour=(EditText)findViewById(R.id .edStartHour) ;
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
        btnSaveCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }

        });
    }

    private void dataHandler() {
        String name=edCourseName.getText().toString();
        String startHour=edStartHour.getText().toString();
        String endHour=edEndHour.getText().toString();

    }

}
