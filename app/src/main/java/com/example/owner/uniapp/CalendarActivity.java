package com.example.owner.uniapp;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.owner.uniapp.data.StudentEvent;
import com.example.owner.uniapp.new1.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import sun.bob.mcalendarview.MCalendarView;
import sun.bob.mcalendarview.vo.DateData;

public class CalendarActivity extends AppCompatActivity {
    private static final String Tag="CalendarActivity";
    private MCalendarView calendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        calendarView = ((MCalendarView) findViewById(R.id.calendar_exp));


        ArrayList<DateData> dates=new ArrayList<>();
        dates.add(new DateData(2019,06,26));
        dates.add(new DateData(2019,06,27));

        for(int i=0;i<dates.size();i++) {
            calendarView.markDate(dates.get(i).getYear(),dates.get(i).getMonth(),dates.get(i).getDay());//mark multiple dates with this code.
        }


        Log.d("marked dates:-",""+calendarView.getMarkedDates());//get all marked dates.
    }
    private void getAllEvent(){
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        reference.child("MyEvents").child(auth.getUid()).orderByChild("eventTime").addValueEventListener(new ValueEventListener() {

            @Override



            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    StudentEvent event = d.getValue(StudentEvent.class);
                    dataSnapshot.getValue(StudentEvent.class);
                   // adapter.add(event);
                    Date date=new Date(event.getEventTime());
                    calendarView.markDate(date.getYear(),date.getMonth(),date.getDay());//mark multiple dates with this code.

//                  StudentEvent studentEvent=d.getValue(StudentEvent.class);

                }
              //  adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CalendarActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
