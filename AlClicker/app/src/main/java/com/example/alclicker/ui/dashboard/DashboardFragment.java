package com.example.alclicker.ui.dashboard;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;



import com.example.alclicker.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    private int score = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final TextView textView = view.findViewById(R.id.scoreView);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ImageView button = (ImageView) view.findViewById(R.id.imageAlexis);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score +=10;

                TextView scoreView = (TextView) getView().findViewById(R.id.scoreView);

                scoreView.setText(String.valueOf(score));

            }
        });


        return view;
    }

}
