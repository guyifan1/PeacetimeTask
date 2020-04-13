package com.example.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_simpleadapter = (Button)findViewById(R.id.sabtn);
        Button btn_dialog=(Button)findViewById(R.id.dgbtn);
        Button btn_xml=(Button)findViewById(R.id.xmlbtn);
        Button btn_Am=(Button)findViewById(R.id.ambtn);

        btn_simpleadapter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleAdapterActivity.class);
                startActivity(intent);
            }
        });
        btn_dialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlertdialogActivity.class);
                startActivity(intent);
            }
        });
        btn_xml.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,XmlActivity.class);
                startActivity(intent);
            }
        });
        btn_Am.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ActionModeActivity.class);
                startActivity(intent);
            }
        });
    }
}
