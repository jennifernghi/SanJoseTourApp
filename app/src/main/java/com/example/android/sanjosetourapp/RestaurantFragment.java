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
public class RestaurantFragment extends Fragment {



    public RestaurantFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container,false);
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Restaurant(getString(R.string.kali_restaurant_name), getString(R.string.kali_restaurant_address), getString(R.string.kali_restaurant_description), R.drawable.kali_restaurant));
        locations.add(new Restaurant(getString(R.string.cubamex_restaurant_name), getString(R.string.cubamex_restaurant_address), getString(R.string.cubamex_restaurant_description), R.drawable.cubamex));
        locations.add(new Restaurant(getString(R.string.the_city_fish_restaurant_name), getString(R.string.the_city_fish_restaurant_address), getString(R.string.the_city_fish_restaurant_description), R.drawable.the_city_fish));
        locations.add(new Restaurant(getString(R.string.danbi_korean_restaurant_name), getString(R.string.danbi_korean_restaurant_address), getString(R.string.danbi_korean_restaurant_description), R.drawable.danbi_korean_restaurant));
        locations.add(new Restaurant(getString(R.string.hawaiian_poke_bowl_restaurant_name), getString(R.string.hawaiian_poke_bowl_restaurant_address), getString(R.string.hawaiian_poke_bowl_restaurant_description), R.drawable.hawaiian_poke_bowl));


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
