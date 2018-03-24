package com.iti.tripplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Hossa on 3/24/2018.
 */

public class Home extends Activity {

    Intent incomingIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_user);

        incomingIntent = getIntent();

    }
}