package com.example.android.sanjosetourapp;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public class Restaurant extends Location {
    public Restaurant(String locationName, String address, String description) {
        super(locationName, address, description);
    }

    public Restaurant(String locationName, String address, String description, int imageResourceId) {
        super(locationName, address, description, imageResourceId);
    }
}
