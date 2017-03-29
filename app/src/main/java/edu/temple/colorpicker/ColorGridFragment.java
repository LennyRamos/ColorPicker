package edu.temple.colorpicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class ColorGridFragment extends Fragment {

    ColorSenderInterface activity;
    boolean flag = false;

    public ColorGridFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Resources colorRes = getResources();
        final String[] actualColors = colorRes.getStringArray(R.array.actualColors);
        final String[] spanishColors = colorRes.getStringArray(R.array.colors);


        View view = inflater.inflate(R.layout.fragment_color_grid, container, false);
        GridView gridBlock = (GridView) view.findViewById(R.id.grid);

        CustomerAdapter adapter = new CustomerAdapter(view.getContext(), android.R.layout.simple_list_item_1, spanishColors);
        gridBlock.setAdapter(adapter);

        gridBlock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(flag) {
                    //Pass the string that was pressed on, to the other fragment.
                    activity.passColor(actualColors[position]);
                }
                flag = true;
            }

        });


        // Inflate the layout for this fragment
        return view;
    }


    @Override
    public void onAttach(Activity c) {
        super.onAttach(c);
        activity = (ColorSenderInterface) c;

    }

    @Override
    public void onDetach(){
        activity = null;
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ColorSenderInterface {
        public void passColor(String color);
    }
}
