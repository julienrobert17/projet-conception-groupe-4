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
    }

    public void runLoginRequest(View view){

        TextView LoginView = (EditText)findViewById(R.id.textLoginInput);
        TextView MdpView = (EditText)findViewById(R.id.textMdpInput);
        TextView errorBox = (TextView)findViewById(R.id.errorText);

        //Log.e("DEVE0304", "MainActivity.runRestRequest()");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.1.13/TRANSV/api/RequestLogin.php?login="+LoginView.getText().toString()+"&mdp="+MdpView.getText().toString();

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
                            intent.putExtra("id_user",json.getInt("id_user"));
                            intent.putExtra("pseudo",json.getString("pseudo"));
                            intent.putExtra("monnaie",json.getInt("monnaie"));
                            intent.putExtra("best_score",json.getInt("best_score"));
                            intent.putExtra("skin_hat",json.getString("skin_hat"));
                            intent.putExtra("skin_access",json.getString("skin_access"));
                            intent.putExtra("skin_hat",json.getString("skin_hat"));
                            intent.putExtra("skin_cible",json.getString("skin_cible"));
                            view.getContext().startActivity(intent);


                        } catch (JSONException e) {

                            e.printStackTrace();
                            errorBox.setVisibility(View.VISIBLE);

                            switch (response){
                                case "wrong_pw":
                                    Log.e("DEV405","Mauvais mdp");
                                    errorBox.setText("Mauvais mot de passe");
                                    break;

                                case "wrong_user":
                                    Log.e("DEV405","Utilisateur innexistant");
                                    errorBox.setText("Utilisateur innexistant");
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

    public void goToRegisterPage(View view){

        Log.e("DEVE0304", "Button clicked");

        Intent intent = new Intent(view.getContext(), RegisterPage.class);
        view.getContext().startActivity(intent);
    };
}