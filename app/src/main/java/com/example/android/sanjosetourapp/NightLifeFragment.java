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
public class NightLifeFragment extends Fragment {


    public NightLifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container,false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new NightLife(getString(R.string.edgie_billiards_name), getString(R.string.edgie_billiards_address), getString(R.string.edgie_billiards_description), R.drawable.edgie_billiards));
        locations.add(new NightLife(getString(R.string.comedysportz_name), getString(R.string.comedysportz_address), getString(R.string.comedysportz_description), R.drawable.comedysportz));
        locations.add(new NightLife(getString(R.string.south_bay_apa_name), getString(R.string.south_bay_apa_address), getString(R.string.south_bay_apa_description)));
        locations.add(new NightLife(getString(R.string.stage_4_improv_name), getString(R.string.stage_4_improv_address), getString(R.string.stage_4_improv_description), R.drawable.stage_4_improv));


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
