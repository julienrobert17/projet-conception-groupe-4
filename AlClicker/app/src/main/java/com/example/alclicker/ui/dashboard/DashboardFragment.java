package com.example.alclicker.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alclicker.IdImage;
import com.example.alclicker.MainActivity;
import com.example.alclicker.R;
import com.example.alclicker.login;

import org.json.JSONException;

import java.io.File;


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

        SharedPreferences myPreferences= PreferenceManager.getDefaultSharedPreferences(this.getContext());
        int ScoreLocal = myPreferences.getInt("storedNumber", -1);


        if(ScoreLocal > score){
            score = ScoreLocal;
        }

        IdUser = activity.getIdUser();


        String ArmeLocal = myPreferences.getString("arme", "");
        if(ArmeLocal != ""){
            arme = ArmeLocal;
        }else{
            arme = activity.getArme();
        }


        ImageView armeView = (ImageView) view.findViewById(R.id.imageArme);


        int IntIdArme = 0;

        try {

            IdImage infoImage = new IdImage();

            IntIdArme = infoImage.getIdArme(arme);

            Log.e("idarmeLog", arme);

            Log.e("IdPoing", String.valueOf(R.id.Poing));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("idarmeLog", String.valueOf(IntIdArme));


        int IntDegatArme = 0;
        try {

            IdImage infoImage = new IdImage();

            IntDegatArme = infoImage.getIdArmeTab(1);

            Log.e("DegatArmeTab", String.valueOf(IntDegatArme));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("idarmeLog", String.valueOf(IntDegatArme));

        try {
            armeView.setImageResource(IntIdArme);
        } catch (Exception e){
            armeView.setImageResource(R.drawable.poing);
        }




        final TextView textView = view.findViewById(R.id.scoreView);

        textView.setText(String.valueOf(score));
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ImageView imageAlexis = (ImageView) view.findViewById(R.id.imageAlexis);
        imageAlexis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IdImage infoImage = null;
                try {
                    infoImage = new IdImage();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int IntDegatArme = 0;

                try {
                    IntDegatArme = infoImage.getDegatArmeDico(arme + "ATC");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                score += (1 * IntDegatArme);

                TextView scoreView = (TextView) getView().findViewById(R.id.scoreView);

                scoreView.setText(String.valueOf(score));

                SharedPreferences myPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = myPreferences.edit();
                editor.putInt("storedNumber", score); // value to store
                editor.apply();

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




    public void saveData(){

        try {

            TextView scoreView = (TextView) getView().findViewById(R.id.scoreView);

            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateScore.php?id_user=" + IdUser + "&score=" + scoreView.getText().toString();

            //Log.e("url", url);

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
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };
}