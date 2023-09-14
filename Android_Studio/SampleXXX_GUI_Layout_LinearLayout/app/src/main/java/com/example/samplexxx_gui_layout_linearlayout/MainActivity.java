package com.example.samplexxx_gui_layout_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL_MainWindow;
    TextView    TV_Message;
    String message = "Touching Event ID %d: (X, Y) = (%f, %f)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LL_MainWindow = ((LinearLayout) this.findViewById(R.id.LL_MainWindow));
        TV_Message = ((TextView) this.findViewById(R.id.TV_Message));

        LL_MainWindow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Integer TouchingEventCount = motionEvent.getPointerCount();
                String tmp_msg = "";

                tmp_msg += TouchingEventCount.toString() + "\n";
                for (int i=0; i<TouchingEventCount; i++) {
                    tmp_msg += String.format(message, motionEvent.getPointerId(i),
                            motionEvent.getX(i),
                            motionEvent.getY(i));
                    tmp_msg += "\n";
                }

                TV_Message.setText(tmp_msg);

                return true;
            }
        });
    }
}