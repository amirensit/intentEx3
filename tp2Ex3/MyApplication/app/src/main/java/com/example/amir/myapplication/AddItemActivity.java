package com.example.amir.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
         editText=(EditText)findViewById(R.id.editText);
    }

    public void addItem(View v)
    {
        Intent intent=new Intent();
        String message=editText.getText().toString();
        intent.putExtra("item", message);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void cancel(View view)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
