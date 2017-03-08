package edu.temple.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by Lenny Ramos on 3/8/2017.
 */

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        LinearLayout view = (LinearLayout) findViewById(R.id.activity_canvas);

        Intent received = getIntent();
        String dataReceived = received.getStringExtra(getString(R.string.colorIntent));

        view.setBackgroundColor(Color.parseColor(dataReceived));

    }
}
