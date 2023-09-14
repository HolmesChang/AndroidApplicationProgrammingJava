package com.example.sample000_template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView stringMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("MainActivity1", "OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String MessageFrom = intent.getStringExtra("MessageFromMainActivity1");
        stringMessage = ((TextView) findViewById(R.id.MessageString));
        stringMessage.setText(MessageFrom);
    }
}