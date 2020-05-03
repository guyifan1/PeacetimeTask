package cn.edu.fjnu.cl.intentmain;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //按钮获取
        btn = (Button) findViewById(R.id.btn);
        //按钮单击相应事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //为intent设置动作
                intent.setAction(Intent.ACTION_VIEW);
                //获取文本框
                edt = (EditText) findViewById(R.id.edt);
                Uri uri=Uri.parse(edt.getText().toString());
                //为intent设置uri
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}
