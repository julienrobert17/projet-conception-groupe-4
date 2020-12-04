package com.example.alclicker.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private int IdUser = 0;

    private String arme = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        ImageView imageCasserole = (ImageView) root.findViewById(R.id.Casserole);
        imageCasserole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeArmeCasserole();

            }
        });

        ImageView imageChipolata = (ImageView) root.findViewById(R.id.Chipolata);
        imageChipolata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeArmeChipolata();

            }
        });

        MainActivity activity = (MainActivity) getActivity();
        IdUser = activity.getIdUser();


        return root;
    }



    public void changeArmeCasserole(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=casserole";

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

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            SharedPreferences.Editor editor = myPreferences.edit();
            editor.putString("arme", "casserole"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };

    public void changeArmeChipolata(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=chipolata";

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

            SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            SharedPreferences.Editor editor = myPreferences.edit();
            editor.putString("arme", "chipolata"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };
}