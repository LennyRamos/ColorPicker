package edu.temple.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends Activity implements ColorGridFragment.ColorSenderInterface {

    BackgroundChangerFragment receiver;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Need to add the fragments,by fragment managers
        ColorGridFragment sender = new ColorGridFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frag1, sender)
                .commit();

        receiver = new BackgroundChangerFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frag2, receiver)
                .commit();

    }

    //Override interface
    @Override
public void passColor(String color){
        receiver.changeBackgroundColor(color);

}
}
