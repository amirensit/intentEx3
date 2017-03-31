package com.example.amir.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView l;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.listView);
        ArrayList<String> list = new ArrayList<String>();
        list.add("android");
        list.add("OS");
         adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        l.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.ajouter)
        {
            onAddItemAction(item);
        }
        return super.onOptionsItemSelected(item);
    }

    final int ADD_ITEM_ACTIVITY=48;

    public void onAddItemAction(MenuItem menuItem)
    {
        Intent intent=new Intent(this,AddItemActivity.class);
        startActivityForResult(intent,ADD_ITEM_ACTIVITY);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==ADD_ITEM_ACTIVITY)
        {
            String item=data.getStringExtra("item");
            adapter.add(item);

        }
        if(resultCode==RESULT_OK) Toast.makeText(this,"ajout reussi !",Toast.LENGTH_SHORT).show();
        else if(requestCode==RESULT_CANCELED) Toast.makeText(this,"ajout annulé !",Toast.LENGTH_SHORT).show();

        //super.onActivityResult(requestCode, resultCode, data);
    }
}
