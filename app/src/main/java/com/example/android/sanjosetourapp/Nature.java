package com.example.android.sanjosetourapp;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public class Nature extends Location {
    public Nature(String locationName, String address, String description, int imageResourceId) {
        super(locationName, address, description, imageResourceId);
    }

    public Nature(String locationName, String address, String description) {
        super(locationName, address, description);
    }
}
