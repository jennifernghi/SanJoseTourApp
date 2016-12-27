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
public class RestaurantFragment extends Fragment {

    public RestaurantFragment() {

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
        locations.add(new Restaurant(getString(R.string.kali_restaurant_name), getString(R.string.kali_restaurant_address), getString(R.string.kali_restaurant_description), R.drawable.kali_restaurant));
        locations.add(new Restaurant(getString(R.string.cubamex_restaurant_name), getString(R.string.cubamex_restaurant_address), getString(R.string.cubamex_restaurant_description), R.drawable.cubamex));
        locations.add(new Restaurant(getString(R.string.the_city_fish_restaurant_name), getString(R.string.the_city_fish_restaurant_address), getString(R.string.the_city_fish_restaurant_description), R.drawable.the_city_fish));
        locations.add(new Restaurant(getString(R.string.danbi_korean_restaurant_name), getString(R.string.danbi_korean_restaurant_address), getString(R.string.danbi_korean_restaurant_description), R.drawable.danbi_korean_restaurant));
        locations.add(new Restaurant(getString(R.string.hawaiian_poke_bowl_restaurant_name), getString(R.string.hawaiian_poke_bowl_restaurant_address), getString(R.string.hawaiian_poke_bowl_restaurant_description), R.drawable.hawaiian_poke_bowl));
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
