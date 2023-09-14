package com.example.samplexxx_gui_component;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView TV_MyTextView;
    Button BTN_MyButton;
    CheckBox CB_MyCheckBox;
    RadioGroup RG_MyRadioGroup;
    Switch SW_MySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_MyTextView = ((TextView) this.findViewById(R.id.TV_MyTextView));
        BTN_MyButton = ((Button) this.findViewById(R.id.BTN_MyButton));
        CB_MyCheckBox = ((CheckBox) this.findViewById(R.id.CB_MyCheckBox));
        RG_MyRadioGroup = ((RadioGroup) this.findViewById(R.id.RG_MyRadioGroup));
        SW_MySwitch = ((Switch) this.findViewById(R.id.SW_MySwitch));

        this.registerForContextMenu(TV_MyTextView);
        TV_MyTextView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                Toast.makeText(MainActivity.this, "Creation Of Context Menu Of TV_MyTextView", Toast.LENGTH_SHORT).show();
            }
        });
        TV_MyTextView.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View view) {
                Toast.makeText(MainActivity.this, "This is a toast message", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        ColorStateList trackTintList = new ColorStateList(
                new int[][]{
                        {android.R.attr.state_checked},
                        {-android.R.attr.state_checked}
                },
                new int[]{
                        Color.BLUE,
                        Color.GRAY
                }
        );
        SW_MySwitch.setTrackTintList(trackTintList);
        BTN_MyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";

                result += "Result Of CheckBox: " + String.valueOf(CB_MyCheckBox.isChecked()) + "\n";

                result += "Result Of RadioGroup: " + ((RadioButton) RG_MyRadioGroup.findViewById(RG_MyRadioGroup.getCheckedRadioButtonId())).getText().toString() + "\n";

                result += "Result Of Switch: " + String.valueOf(SW_MySwitch.isChecked()) + "\n";

                TV_MyTextView.setText(result);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        Toast.makeText(MainActivity.this, "Context Menu", Toast.LENGTH_SHORT);
    }
}