package com.example.alclicker.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.example.alclicker.IdImage;
import com.example.alclicker.MainActivity;
import com.example.alclicker.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

import com.example.alclicker.IdImage;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private int IdUser = 0;

    private String arme = "";

    public HomeFragment() {

    }

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

        SharedPreferences myPreferences= PreferenceManager.getDefaultSharedPreferences(this.getContext());
        int ScoreLocal = myPreferences.getInt("storedNumber", -1);


        ImageView imageCasserole = (ImageView) root.findViewById(R.id.Casserole);

        if(ScoreLocal < 7500){
            imageCasserole.setImageAlpha(90);
        }

        imageCasserole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 7500){
                    changeArmeCasserole();
                }


            }
        });

        ImageView imageChipolata = (ImageView) root.findViewById(R.id.Chipolata);

        if(ScoreLocal < 500){
            imageChipolata.setImageAlpha(90);
        }

        imageChipolata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 500){
                    changeArmeChipolata();
                }

            }
        });

        ImageView imageTong = (ImageView) root.findViewById(R.id.Tong);

        if(ScoreLocal < 5000){
            imageTong.setImageAlpha(90);
        }

        imageTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 5000){
                    changeArmeTong();
                }

            }
        });





        ImageView imageAltere = (ImageView) root.findViewById(R.id.Altere);

        if(ScoreLocal < 25000){
            imageAltere.setImageAlpha(90);
        }

        imageAltere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 25000){
                    changeArmeAltere();
                }

            }
        });

        ImageView imageBoxe = (ImageView) root.findViewById(R.id.Boxe);

        if(ScoreLocal < 15000){
            imageBoxe.setImageAlpha(90);
        }

        imageBoxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 15000){
                    changeArmeBoxe();
                }

            }
        });

        ImageView imagePoing = (ImageView) root.findViewById(R.id.Poing);
        imagePoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ScoreLocal > 0){
                    changeArmePoing();
                }

            }
        });

        MainActivity activity = (MainActivity) getActivity();
        IdUser = activity.getIdUser();





        //ajout de la grille pour l'ajout des images
        //GridView GrilleArmes = (GridView) root.findViewById(R.id.GrilleArme);



        //GrilleArmes.removeAllViewsInLayout();

        //GrilleArmes.setNumColumns(2);
        //GrilleArmes.setNumColumns(7);











/*
        for (int i = 0; i < 12; i++) {

            int IntIdArme = 0;

            try {
                final LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.LayoutArme);
                final ImageView ImageArme = new ImageView(new ContextThemeWrapper(getContext(), R.style.ArmeImageStyle), null, 0);


                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.height = GridLayout.LayoutParams.WRAP_CONTENT;
                param.width = GridLayout.LayoutParams.WRAP_CONTENT;
                param.rightMargin = 5;
                param.topMargin = 5;
                param.setGravity(Gravity.CENTER);


                ImageArme.setLayoutParams(param);
                //ImageArme.requestLayout();

                IdImage infoImage = new IdImage();

                IntIdArme = infoImage.getIdArmeTab(i);

                Log.e("idarmeLog", String.valueOf(IntIdArme));

                ImageArme.setImageResource(IntIdArme);

                linearLayout.addView(ImageArme);
            } catch (JSONException e) {
                Log.e("erreurIdArme", "erreur");
                e.printStackTrace();
            }


        }


        for(int i = 0; i < 12; i++){
            ImageView ImageArme = new ImageView(getContext());
            try {
                IntDegatArme = infoImage.getIdArmeTab(i);


            } catch (JSONException e) {
                e.printStackTrace();
            }


            GridLayout.LayoutParams param = new GridLayout.LayoutParams();
            param.height = GridLayout.LayoutParams.WRAP_CONTENT;
            param.width = GridLayout.LayoutParams.WRAP_CONTENT;
            param.rightMargin = 5;
            param.topMargin = 5;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(i % 2 + 1);

            int row = 0;
            if(i % 2 == 1){
                row = (i - 1)/2 +1;
            }else{
                row = i/2 +1;
            }

            */
            //ImageArme.setImageResource(IntDegatArme);

            //Log.e("=========Arme numéro : ", String.valueOf(i));



            //Log.e("idArmeTab", String.valueOf(IntDegatArme));


            //ImageArme.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            //param.rowSpec = GridLayout.spec(row);





            //GrilleArmes.addView(ImageArme);

            //LinearLayout LayoutArmes = (LinearLayout) root.findViewById(R.id.LayoutArme);



            //LayoutArmes.addView(ImageArme);

        //}








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





    public void changeArmeTong(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=claquette";

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
            editor.putString("arme", "claquette"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };




    public void changeArmeAltere(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=altere";

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
            editor.putString("arme", "altere"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };

    public void changeArmeBoxe(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=gants_de_boxe";

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
            editor.putString("arme", "gants_de_boxe"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };

    public void changeArmePoing(){

        try {
            RequestQueue queue = Volley.newRequestQueue(this.getContext());
            String url = "http://192.168.1.47/ProjetTransDev/vrai/projet-conception-groupe-4-main/api/UpdateArme.php?id_user=" + IdUser + "&arme=poing";

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
            editor.putString("arme", "poing"); // value to store
            editor.apply();

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch(Exception e){
            Log.e("error saveDate", "not page");
        }


    };
}