package com.example.swamphack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MatchAcitivity extends AppCompatActivity {

    private ListView listView;
    private ClassListAdapter adapter;
    private ArrayList<ClassName> classNameArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        classNameArrayList = new ArrayList<>();





    }

    public void onClickAdd(View view){

        listView = (ListView) findViewById(R.id.listView);
        String className = null;
        EditText intsertedClass = findViewById(R.id.insertClass);

        className = intsertedClass.getText().toString();
        ClassName className1 = new ClassName(className);
        classNameArrayList.add(className1);

        adapter = new ClassListAdapter(this, R.layout.adapter_class, classNameArrayList);
        listView.setAdapter(adapter);

        intsertedClass.setText(" ");




    }

    public void onClickCourse(View view){
        Intent intent = new Intent(MatchAcitivity.this, ClassDescriptionActivity.class);
        startActivity(intent);
    }
}

