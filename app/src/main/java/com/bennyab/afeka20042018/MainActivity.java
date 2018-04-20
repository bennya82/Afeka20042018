package com.bennyab.afeka20042018;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String PREFS_NAME = "APPLICATIONDATA";
    private final String DATA1 = "DATA1";
    private final String DATA2 = "DATA2";

    EditText et1;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        getData();
    }

    private void bindView(){
        Button btn = findViewById(R.id.btn_act_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        et1 = findViewById(R.id.et_first);
        et2 = findViewById(R.id.et_second);
    }



    private void getData(){
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String txt1 = prefs.getString(DATA1,"");
        String txt2 =  prefs.getString(DATA2,"");
        et1.setText(txt1);
        et2.setText(txt2);
    }


    private void saveData(){
        String txt1 = et1.getText().toString();
        String txt2 = et2.getText().toString();

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(DATA1,txt1);
        editor.putString(DATA2,txt2);
        editor.commit();
    }
}
