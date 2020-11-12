package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.button2);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("DEVE0304", "Button clicked");
                Intent intent = new Intent(view.getContext(), Activity2.class);
                view.getContext().startActivity(intent);
            }
        });

        Log.e("DEVE0304", "MainActivity:onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("DEVE0304", "MainActivity:onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("DEVE0304", "MainActivity:onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("DEVE0304", "MainActivity:onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("DEVE0304", "MainActivity:onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("DEVE0304", "MainActivity:onDestroy()");
    }

    public void goToActivity2(View view){

        Log.e("DEVE0304", "Button clicked");

        Intent intent = new Intent(view.getContext(), Activity2.class);
        view.getContext().startActivity(intent);
    };

    public void goToLoginPage(View view){

        Log.e("DEVE0304", "Button clicked");

        Intent intent = new Intent(view.getContext(), LoginPage.class);
        view.getContext().startActivity(intent);
    };


    public void runRestRequest(View view){

        Log.e("DEVE0304", "MainActivity.runRestRequest()");

        // !!!! Add dependencie in build.gradle : https://developer.android.com/training/volley/index.html

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://www.google.com";
        url = "http://192.168.1.13/TRANSV/api/getUser.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the response string.
                        Log.e("DEVE0304", "Request answer : " + response);

                        TextView myTextView = (TextView)findViewById(R.id.textRequest);
                        myTextView.setText(response);
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