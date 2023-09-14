package com.example.samplexxx_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button BTN_SUBMIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_SUBMIT = ((Button) this.findViewById(R.id.BTN_SUBMIT));
        BTN_SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText TV_Name = ((EditText) MainActivity.this.findViewById(R.id.ET_Name));
                EditText TV_Age = ((EditText) MainActivity.this.findViewById(R.id.ET_Age));
                EditText TV_ID = ((EditText) MainActivity.this.findViewById(R.id.ET_ID));

                String name = TV_Name.getText().toString();
                int age = Integer.parseInt(TV_Age.getText().toString());
                String id = TV_ID.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Age", age);
                bundle.putString("ID", id);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtras(bundle);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}