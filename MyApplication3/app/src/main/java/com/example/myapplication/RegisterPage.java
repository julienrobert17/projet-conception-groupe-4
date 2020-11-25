package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegsiterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void runRegisterRequest(View view){

        TextView LoginView = (EditText)findViewById(R.id.textLoginInput);
        TextView MdpView = (EditText)findViewById(R.id.textMdpInput);
        TextView emailView = (EditText)findViewById(R.id.editMailInput);
        TextView errorBox = (TextView)findViewById(R.id.errorText);

        //Log.e("DEVE0304", "MainActivity.runRestRequest()");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.13/TRANSV/api/RegisterUser.php?login="+LoginView.getText().toString()+"&mdp="+MdpView.getText().toString()+"&email="+emailView.getText().toString();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        Log.e("DEVE0405", "Request answer : " + response);

                        switch (response){
                            case "already_exist":
                                Log.e("DEV405","existe deja");
                                errorBox.setText("Utilisateur déjà existant");
                                break;

                            case "user_created":
                                Log.e("DEV405","Utilisateur crée");
                                Intent intent = new Intent(view.getContext(), LoginPage.class);
                                view.getContext().startActivity(intent);
                                break;

                            case "no_param":
                                Log.e("DEV405","Veuillez saisir tout les champs");
                                errorBox.setText("Veuillez saisir tout les champs");

                                break;

                            default:
                                Log.e("DEV405","issou");
                                errorBox.setText("Les serveurs sont hors-ligne veuillez attendre");
                                break;
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