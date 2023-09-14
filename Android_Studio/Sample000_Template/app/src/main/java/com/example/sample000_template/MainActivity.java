package com.example.sample000_template;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button MyButton;
    Button SendButton;
    EditText MessageTo;

    int countListButton = 0;
    List <Button> listButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        Log.v("MainActivity1", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyButton = ((Button) findViewById(R.id.MyButton));
        if (MyButton != null) {
            MyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    Button tmp = ((Button) v);

                    if (tmp.getText().equals(getString(R.string.ButtonText1))) {
                        Button btn = new Button(MainActivity.this);
                        //btn.setId("");
                        btn.setText(String.format("Button%03d", ++countListButton));
                        LinearLayout ttmp = ((LinearLayout) findViewById(R.id.activity1_layout));
                        ttmp.addView(btn);
                        tmp.setText("Don't Click Me");
                    }
                    else if (tmp.getText().equals("Don't Click Me")) {
                        tmp.setText("Click Me");
                    }
                    else {
                        tmp.setText("Hello");
                    }
                }
            });
        }

        MessageTo = ((EditText) findViewById(R.id.myMessage));
        SendButton = ((Button) findViewById(R.id.SendMessage));
        if (SendButton != null) {
            SendButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("MessageFromMainActivity1", MessageTo.getText().toString());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onStart () {
        Log.v("MainActivity1", "OnStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.v("MainActivity1", "OnReStart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.v("MainActivity1", "OnResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v("MainActivity1", "OnPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.v("MainActivity1", "OnSop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("MainActivity1", "OnDestroy");
        super.onDestroy();
    }
}