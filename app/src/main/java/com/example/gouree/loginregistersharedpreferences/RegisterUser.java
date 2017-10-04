package com.example.gouree.loginregistersharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by omsai on 04/10/2017.
 */

public class RegisterUser extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        //buttons
       final EditText name =(EditText)findViewById(R.id.name);
        final EditText age =(EditText)findViewById(R.id.age);
        final EditText pno =(EditText)findViewById(R.id.phone);
        final EditText city =(EditText)findViewById(R.id.city);
        final Button register_register =(Button)findViewById(R.id.register_register);

        //on click of button
         register_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //use shared preferences to store saved values
                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String name_str= name.getText().toString();
                String age_str= age.getText().toString();
                String pno_str= pno.getText().toString();
                String city_str= city.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();
               // editor.putString(name_str + "data" , name_str +"\n" +age_str +"\n" +pno_str +"\n"+city_str);
                 editor.putString(name_str + "data" , "\n\t\tNAME -->"+name_str +"\n\t\tAGE-->" +age_str +"\n\t\tPHONE -->" +pno_str +"\n\t\tCITY-->"+city_str);

                editor.commit();
                //make a toast
                Toast.makeText(RegisterUser.this, "Succesfully registered ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterUser.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}