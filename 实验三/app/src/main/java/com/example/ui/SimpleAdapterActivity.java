package com.example.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2020-03-26.
 */

public class SimpleAdapterActivity extends Activity {
    private String[] animals = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageIds = new int[]{R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapterlayout);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < animals.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("imags", imageIds[i]);
            listItem.put("animaltype", animals[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simpleitems,
                new String[]{"animaltype", "imags"},
                new int[]{R.id.animaltypes,R.id.imags});
        ListView list=(ListView)findViewById(R.id.simpleListView);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),animals[position], Toast.LENGTH_LONG).show();
            }});
    }


}
