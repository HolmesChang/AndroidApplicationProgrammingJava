package com.example.samplexxx_gui_layout_horizontalscrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button BTN_Add;
    HorizontalScrollView HSV_Container;
    LinearLayout LL_Container;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BTN_Add = ((Button) this.findViewById(R.id.BTN_Add));
        HSV_Container = ((HorizontalScrollView) this.findViewById(R.id.HSV_Container));
        LL_Container = ((LinearLayout) this.findViewById(R.id.LL_Container));

        BTN_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tmp = new TextView(MainActivity.this);
                tmp.setWidth(100);
                tmp.setText(String.format("%d", count));
                LL_Container.addView(tmp);
                count++;

                HSV_Container.post(new Runnable() {
                    @Override
                    public void run() {
                        HSV_Container.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });
    }
}