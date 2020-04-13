package com.example.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Lenovo on 2020-03-27.
 */

public class ActionModeActivity extends AppCompatActivity {
    private ListView listView;
    private List<Items> list;
    private Adapter adapter;
    private String[] texts = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.am_layout);
        listView = (ListView) findViewById(R.id.Amview);
        list = new ArrayList<Items>();
        for (int i = 0; i < texts.length; i++) {
            list.add(new Items(texts[i], false));
        }
        adapter = new Adapter(list, ActionModeActivity.this);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            public void refresh(){
                for(int i = 0; i < texts.length; i++){
                    list.get(i).setChoose(false);
                }
            }
            public void selectall(){
                for(int i = 0; i < texts.length; i++){
                    list.get(i).setChoose(true);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode_menu, menu);
                num = 0;
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                adapter.notifyDataSetChanged();
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.all:
                        num = texts.length;
                        selectall();
                        adapter.notifyDataSetChanged();
                        return true;
                    case R.id.rubbish:
                        adapter.notifyDataSetChanged();
                        num = 0;
                        refresh();
                        mode.finish();
                        return true;
                    default:
                        refresh();
                        adapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                refresh();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                if (checked == true) {
                    list.get(position).setChoose(true);
                    adapter.notifyDataSetChanged();
                    num++;
                } else {
                    list.get(position).setChoose(false);
                    adapter.notifyDataSetChanged();
                    num--;
                }
                mode.setTitle("  " + num + " Selected");
            }

            int num = 0;
        });
    }
}
