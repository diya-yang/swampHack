package com.example.swamphack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ClassmateDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classmate_description);

        ListView listView = findViewById(R.id.listView_classmate);

        String studentName = null;
        String studentEmail = null;
        ArrayList<Classmate> classmateArrayList = new ArrayList<>();

        Classmate classmate = new Classmate(studentName,studentEmail);
        classmateArrayList.add(classmate);

        ClassmateListAdapter adapter = new ClassmateListAdapter(this, R.layout.adapter_classmate,classmateArrayList);
        listView.setAdapter(adapter);
    }
}