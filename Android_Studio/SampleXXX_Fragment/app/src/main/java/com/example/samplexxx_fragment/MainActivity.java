package com.example.samplexxx_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager FM;
    Button BTN_StartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FM = this.getSupportFragmentManager();
        BTN_StartFragment = ((Button) this.findViewById(R.id.BTN_StartFragment));
        BTN_StartFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment TempFragment = FM.findFragmentById(R.id.LL_ContainerOfFragment);
                if (TempFragment == null) {
                    MainFragment MyFragment = new MainFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("Name", "HolmesChang");
                    bundle.putString("Age", "38");
                    bundle.putString("ID", "D121952530");
                    MyFragment.setArguments(bundle);

                    FragmentTransaction transaction = FM.beginTransaction();
                    transaction.add(R.id.LL_ContainerOfFragment, MyFragment, "MyFragment");
                    transaction.commit();
                }
                else {
                    Toast.makeText(MainActivity.this, "Fragment Exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}