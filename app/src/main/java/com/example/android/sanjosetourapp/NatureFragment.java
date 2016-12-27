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
public class NatureFragment extends Fragment {


    public NatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container,false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Nature(getString(R.string.sierra_vista_open_space_preserve_name), getString(R.string.sierra_vista_open_space_preserve_address), getString(R.string.sierra_vista_open_space_preserve_description), R.drawable.sierra_vista_open_space_preserve));
        locations.add(new Nature(getString(R.string.sierra_road_name), getString(R.string.sierra_road_address), getString(R.string.sierra_road_description)));
        locations.add(new Nature(getString(R.string.mission_peak_regional_park_name), getString(R.string.mission_peak_regional_park_address), getString(R.string.mission_peak_regional_park_description)));
        locations.add(new Nature(getString(R.string.san_jose_municipal_rose_garden_name), getString(R.string.san_jose_municipal_rose_garden_address), getString(R.string.san_jose_municipal_rose_garden_description), R.drawable.san_jose_municipal_rose_garden));
        locations.add(new Nature(getString(R.string.japanese_friendship_garden_name), getString(R.string.japanese_friendship_garden_address), getString(R.string.japanese_friendship_garden_description), R.drawable.japanese_friendship_garden));


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
