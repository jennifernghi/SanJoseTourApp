package com.example.android.sanjosetourapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by jennifernghinguyen on 12/25/16.
 * populate location information on list_item_view
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(Context context, List<Location> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view, parent, false);
        }

        Location currentLocation = getItem(position);

        //show image if it exists
        ImageView imageLocation = (ImageView) convertView.findViewById(R.id.image);

        if (currentLocation.hasImage()) {
            imageLocation.setVisibility(View.VISIBLE);
            imageLocation.setImageResource(currentLocation.getImageResourceId());
        } else {
            imageLocation.setVisibility(View.GONE);
        }
        //location name
        TextView locationName = (TextView) convertView.findViewById(R.id.location_name_text_view);
        locationName.setText(currentLocation.getLocationName());
        //location address
        TextView address = (TextView) convertView.findViewById(R.id.address_text_view);
        address.setText(currentLocation.getAddress());
        //location description
        TextView description = (TextView) convertView.findViewById(R.id.description_text_view);
        description.setText(currentLocation.getDescription());
        return convertView;
    }
}
