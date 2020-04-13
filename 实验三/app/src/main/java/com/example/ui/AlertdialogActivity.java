package com.example.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Lenovo on 2020-03-27.
 */

public class AlertdialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogmainlayout);
        Button btn_click = (Button) findViewById(R.id.click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog();
            }
        });
    }

    public void Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(this, R.layout.dialoglayout, null);
        dialog.setView(dialogView);
        dialog.show();
        final EditText usr = (EditText) dialogView.findViewById(R.id.usn);
        final EditText pwd = (EditText) dialogView.findViewById(R.id.pwd);
        final Button cl = (Button) dialogView.findViewById(R.id.cl);
        final Button si = (Button) dialogView.findViewById(R.id.si);
        cl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        si.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = usr.getText().toString();
                String Pwd = pwd.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(Pwd)) {
                    Toast.makeText(getApplicationContext(), "用户名或密码不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "用户名：" + name + "\n" + "用户密码：" + Pwd, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}
