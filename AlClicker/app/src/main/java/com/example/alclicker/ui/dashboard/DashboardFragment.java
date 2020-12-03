package com.example.alclicker.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alclicker.MainActivity;
import com.example.alclicker.R;
import com.example.alclicker.login;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    private int score = 0;

    private int IdUser = 0;

    private String arme = "";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        MainActivity activity = (MainActivity) getActivity();

        score = activity.getScore();

        IdUser = activity.getIdUser();

        arme = activity.getArme();


        final TextView textView = view.findViewById(R.id.scoreView);

        textView.setText(String.valueOf(score));
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

                score +=1;

                TextView scoreView = (TextView) getView().findViewById(R.id.scoreView);

                scoreView.setText(String.valueOf(score));

            }




        });


        Log.e("DEVE0304", "Button clicked : runThread");

        boolean threadIsRunning = false;

        threadIsRunning = true;

        boolean finalThreadIsRunning = threadIsRunning;
        new Thread(new Runnable() {
            public void run() {

                while (finalThreadIsRunning)
                {
                    // a potentially time consuming task
                    Log.e("DEVE0304", "Thread 1 : click");


                    saveData();


                    SystemClock.sleep(10000);
                }
            }
        }).start();




        return view;

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("DEVE0304", "MainActivity:onStop()");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.e("DEVE0304", "MainActivity:onPause()");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("DEVE0304", "MainActivity:onDestroy()");
    }




    public void saveData(){
        TextView scoreView = (TextView) getView().findViewById(R.id.scoreView);

        RequestQueue queue = Volley.newRequestQueue(this.getContext());
        String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateScore.php?id_user=" + IdUser + "&score=" + scoreView.getText().toString();

        Log.e("url", url);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the response string.
                Log.e("ResponseLog", "Data has been saved");
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorResponseLog", String.valueOf(error));
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    };
}