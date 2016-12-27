package com.example.android.sanjosetourapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container,false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Shopping(getString(R.string.santana_row_name), getString(R.string.santana_row_address), getString(R.string.santana_row_description), R.drawable.santana_row));
        locations.add(new Shopping(getString(R.string.eastridge_name), getString(R.string.eastridge_address), getString(R.string.eastridge_description), R.drawable.eastridge));
        locations.add(new Shopping(getString(R.string.west_field_valley_fair_name), getString(R.string.west_field_valley_fair_address), getString(R.string.west_field_valley_fair_description), R.drawable.westfield));
        locations.add(new Shopping(getString(R.string.west_field_oakridge_name), getString(R.string.west_field_oakridge_address), getString(R.string.west_field_oakridge_description)));
        locations.add(new Shopping(getString(R.string.downtown_willow_glen_name), getString(R.string.downtown_willow_glen_address), getString(R.string.downtown_willow_glen_description)));


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
    }

}
