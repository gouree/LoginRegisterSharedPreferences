package com.example.gouree.loginregistersharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by omsai on 04/10/2017.
 */

public class DisplayUser extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_user);
        //display the values in text box
        SharedPreferences preferences =getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display = preferences.getString("display","");
        TextView name_display = (TextView)findViewById(R.id.name_display);
        name_display.setText(display);

    }
}
