package com.example.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenovo on 2020-03-27.
 */

public class XmlActivity extends AppCompatActivity {
    private TextView menuetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlmenulayout);
        menuetext = (TextView) findViewById(R.id.menutext);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case R.id.font_10:
                menuetext.setTextSize(10 * 2);
                break;
            case R.id.font_16:
                menuetext.setTextSize(16 * 2);
                break;
            case R.id.font_20:
                menuetext.setTextSize(20 * 2);
                break;
            case R.id.color_red:
                menuetext.setTextColor(Color.RED);
                break;
            case R.id.color_black:
                menuetext.setTextColor(Color.BLACK);
                break;
            case R.id.menu:
                Toast toast=Toast.makeText(XmlActivity.this, "点击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;

    }
}
