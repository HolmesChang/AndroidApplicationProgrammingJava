package com.example.samplexxx_gui_layout_scrollview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button BTN_Add;
    ScrollView SV_NewTextView;
    LinearLayout LL_NewTextView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_Add = ((Button) this.findViewById(R.id.BTN_Add));
        SV_NewTextView = ((ScrollView) this.findViewById(R.id.SV_NewTextView));
        LL_NewTextView = ((LinearLayout) this.findViewById(R.id.LL_NewTextView));

        BTN_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tmp = new TextView(MainActivity.this);
                tmp.setText(String.format("%d", count));
                LL_NewTextView.addView(tmp);

                count++;

                SV_NewTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        SV_NewTextView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
}