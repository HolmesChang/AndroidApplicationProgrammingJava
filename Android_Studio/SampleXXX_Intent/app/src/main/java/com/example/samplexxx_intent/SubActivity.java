package com.example.samplexxx_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {
    TextView TV_Result;
    Button BTN_Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TV_Result = ((TextView) this.findViewById(R.id.TV_Result));
        BTN_Back = ((Button) this.findViewById(R.id.BTN_Back));

        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("Name");
        int age = bundle.getInt("Age");
        String id = bundle.getString("ID");

        String result = "";
        result += "Name: " + name + "\n" +
                "Age: " + String.format("%d", age) + "\n" +
                "ID: " + id + "\n";
        TV_Result.setText(result);


    }
}