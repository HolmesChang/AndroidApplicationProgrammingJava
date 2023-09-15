package com.example.samplexxx_fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
    String Name;
    String Age;
    String ID;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Name = this.getArguments().getString("Name");
        Age = this.getArguments().getString("Age");
        ID = this.getArguments().getString("ID");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("MainFragment", "onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView TV_Name = ((TextView) view.findViewById(R.id.TV_FragmentName));
        TextView TV_Age = ((TextView) view.findViewById(R.id.TV_FragmentAge));
        TextView TV_ID = ((TextView) view.findViewById(R.id.TV_FragmentID));

        TV_Name.setText(this.Name);
        TV_Age.setText(this.Age);
        TV_ID.setText(this.ID);

        return view;
    }
}