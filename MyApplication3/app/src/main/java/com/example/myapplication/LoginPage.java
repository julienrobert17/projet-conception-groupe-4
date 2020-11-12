package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Log.e("DEVE0304", "LoginPage:onCreate()");
    }

    public void runLoginRequest(View view){

        TextView LoginView = (EditText)findViewById(R.id.textLoginInput);
        TextView MdpView = (EditText)findViewById(R.id.textMdpInput);

        //Log.e("DEVE0304", "MainActivity.runRestRequest()");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.13/TRANSV/api/RequestLogin.php?login="+LoginView.getText().toString()+"&mdp="+MdpView.getText().toString();
        //Log.e("DEV405",url);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        Log.e("DEVE0405", "Request answer : " + response);


                        try {
                            JSONObject json = new JSONObject(response);

                            Intent intent = new Intent(view.getContext(), Accueil.class);
                            view.getContext().startActivity(intent);


                        } catch (JSONException e) {

                            e.printStackTrace();

                            switch (response){
                                case "wrong_pw":
                                    Log.e("DEV405","Mauvais mdp");
                                    break;

                                case "wrong_user":
                                    Log.e("DEV405","Utilisateur innexistant");
                                    LoginView.setBackgroundColor(655764);
                                    break;

                                case "no_param":
                                    Log.e("DEV405","veuillez completer tout les champs");
                                    break;

                                default:
                                    Log.e("DEV405","issou");
                                    break;
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("DEVE0304", String.valueOf(error));
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    };
}