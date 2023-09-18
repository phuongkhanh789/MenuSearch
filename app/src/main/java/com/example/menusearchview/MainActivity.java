package com.example.menusearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv_monhoc;
    ArrayAdapter<String> adapter;
    ArrayList<String> dsmonhoc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        lv_monhoc = findViewById(R.id.lv_monhoc);
        dsmonhoc.addAll(Arrays.asList(getResources().getStringArray(R.array.arrmonhoc)));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsmonhoc);
        lv_monhoc.setAdapter(adapter);
        registerForContextMenu(lv_monhoc);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_monhoc, menu);
        //Lấy menu
        MenuItem menuItem = menu.findItem(R.id.menusearch);
        //Lấy search view ra
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            //Tìm kiếm tới đâu xử lý tới đó
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
            return super.onCreateOptionsMenu(menu);
    }
}