package edu.temple.colorpicker;

import android.app.Activity;
import android.os.Bundle;


import java.util.logging.Logger;

public class MainActivity extends Activity implements ColorGridFragment.ColorSenderInterface {

    BackgroundChangerFragment receiver;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag = (findViewById(R.id.frag2) != null);


        //Need to add the fragments,by fragment managers
        ColorGridFragment sender = new ColorGridFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.frag1, sender)
                .commit();

        receiver = new BackgroundChangerFragment();
        if(flag) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.frag2, receiver)
                    .commit();
        }

    }

    private void doTransaction(){

        getFragmentManager()
                .beginTransaction()
                .add(R.id.frag1, receiver)
                .addToBackStack(null)
                .commit();

        //blocks call
        getFragmentManager().executePendingTransactions();
    }

    //Override interface
    @Override
public void passColor(String color){
        if(!flag){
            doTransaction();
        }
        receiver.changeBackgroundColor(color);

}

}
