package com.example.android.sanjosetourapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NightLifeFragment extends Fragment {

    public NightLifeFragment() {
        // Required empty public constructor
    }

    /**
     * using intent to search a selected location on google map
     *
     * @param address - location's address
     */
    public void searchOnGooleMap(String address) {
        String map = "http://maps.google.co.in/maps?q=" + address;
        Uri gmmIntentUri = Uri.parse(map);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
    /**
     * initialize data
     *
     * @return ArrayList<Location>
     */
    private ArrayList<Location> initializeData() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new NightLife(getString(R.string.edgie_billiards_name), getString(R.string.edgie_billiards_address), getString(R.string.edgie_billiards_description), R.drawable.edgie_billiards));
        locations.add(new NightLife(getString(R.string.comedysportz_name), getString(R.string.comedysportz_address), getString(R.string.comedysportz_description), R.drawable.comedysportz));
        locations.add(new NightLife(getString(R.string.south_bay_apa_name), getString(R.string.south_bay_apa_address), getString(R.string.south_bay_apa_description)));
        locations.add(new NightLife(getString(R.string.stage_4_improv_name), getString(R.string.stage_4_improv_address), getString(R.string.stage_4_improv_description), R.drawable.stage_4_improv));
        return locations;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflate rootView using list_view
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //initialize data
        final ArrayList<Location> locations = initializeData();

        //populate data on listview using Location adapter
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //for each item on listview, open search google map with that location's address
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //get current location
                Location currentLocation = locations.get(i);
                searchOnGooleMap(currentLocation.getAddress());
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
