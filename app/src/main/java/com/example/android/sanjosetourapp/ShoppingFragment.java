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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
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
     * @return ArrayList<Location>
     */
    private ArrayList<Location> initializeData() {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Shopping(getString(R.string.santana_row_name), getString(R.string.santana_row_address), getString(R.string.santana_row_description), R.drawable.santana_row));
        locations.add(new Shopping(getString(R.string.eastridge_name), getString(R.string.eastridge_address), getString(R.string.eastridge_description), R.drawable.eastridge));
        locations.add(new Shopping(getString(R.string.west_field_valley_fair_name), getString(R.string.west_field_valley_fair_address), getString(R.string.west_field_valley_fair_description), R.drawable.westfield));
        locations.add(new Shopping(getString(R.string.west_field_oakridge_name), getString(R.string.west_field_oakridge_address), getString(R.string.west_field_oakridge_description)));
        locations.add(new Shopping(getString(R.string.downtown_willow_glen_name), getString(R.string.downtown_willow_glen_address), getString(R.string.downtown_willow_glen_description)));
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
