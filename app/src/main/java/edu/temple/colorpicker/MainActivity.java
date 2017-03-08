package edu.temple.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity {

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources colorRes = getResources();

        final GridView gridBlock = (GridView) findViewById(R.id.grid);
        final View mainLayout = findViewById(R.id.activity_main);


        final String[] actualColors = colorRes.getStringArray(R.array.actualColors);
        final String[] spanishColors = colorRes.getStringArray(R.array.colors);

        CustomerAdapter adapter = new CustomerAdapter(this, android.R.layout.simple_list_item_1, spanishColors);
        gridBlock.setAdapter(adapter);

        gridBlock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(flag) {
                    //mainLayout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));

                    //Stores the color which was selected as a string
                    //String color = parent.getSelectedItem().toString();

                    //Creates the intent from main activity to canvas activity
                    Intent launchActivity = new Intent(MainActivity.this, CanvasActivity.class);

                    //These line is what makes the new screen appear
                    launchActivity.putExtra(getString(R.string.colorIntent), actualColors[position]);
                    startActivity(launchActivity);

                }
                flag = true;
            }

        });


    }
}
