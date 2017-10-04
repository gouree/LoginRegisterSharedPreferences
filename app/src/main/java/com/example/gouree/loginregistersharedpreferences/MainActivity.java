package com.example.gouree.loginregistersharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons for registering and displaying
        final EditText name_main =(EditText)findViewById(R.id.name_main);
        Button register_main =(Button)findViewById(R.id.register_main);

        Button display_main =(Button)findViewById(R.id.display_main);


        //on click of display button
        display_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_main_str = name_main.getText().toString();

                //shared preference and check whether user name exists , if not give error message
                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String user_details =preferences.getString(name_main_str +"data","user name is incorrect");

                // display details

                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("display",user_details);
                editor.commit();

                //start activity displayuser
                Intent intent = new Intent(MainActivity.this,DisplayUser.class);
                startActivity(intent);

            }
        });


        //on click of register start activity register user
        register_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);
            }
        });
    }
}
