package edu.temple.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Lenny Ramos on 3/8/2017.
 */

public class CustomerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] colors;

    static final String[] actualColors = {"RED", "BLUE", "PURPLE", "YELLOW","WHITE", "GREEN","GREY"};

    public CustomerAdapter(Context c, int resource, String[] colors){
        super(c, resource, colors);

        this.colors = colors;
    }

    @Override
    public int getCount(){

        return colors.length;
    }

//    @Override
//    public Object getItem(int position){
//
//        return colors[position];
//    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View grid = super.getView(position, convertView, parent);

        //View grid = new View(context);
        //grid.setText(colors[position]);
        grid.setBackgroundColor(Color.parseColor(actualColors[position]));
        return grid;
    }


}
