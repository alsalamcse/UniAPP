package com.example.owner.uniapp.new1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.owner.uniapp.AddExamActivity;
import com.example.owner.uniapp.R;
import com.example.owner.uniapp.SignInActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ListView EventList;
    private Adapter adapter;

    private Button AddExam1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventList=(ListView)findViewById(R.id.EventList) ;
        AddExam1=(Button)findViewById(R.id.AddExam1);


        adapter = new Adapter(getBaseContext(),R.layout.studentevent_item);

        EventList.setAdapter(adapter);
        getAllEvent();
        AddExam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddExamActivity.class);
                startActivity(intent);



            }
        });

    }
    private void getAllEvent(){
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        reference.child("MyEvents").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    StudentEvent event = dataSnapshot.getValue(StudentEvent.class);
                    dataSnapshot.getValue(StudentEvent.class);
                    adapter.add(event);
//                  StudentEvent studentEvent=d.getValue(StudentEvent.class);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "onCancelled", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
