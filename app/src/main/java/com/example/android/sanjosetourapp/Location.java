package com.example.android.sanjosetourapp;

/**
 * Created by jennifernghinguyen on 12/24/16.
 */
public abstract class Location {
    public  final static int NO_IMAGE =-1;
    private String mLocationName;
    private String mAddress;
    private String mDescription;
    private int mImageResourceId= NO_IMAGE;

    public Location(String locationName, String address, String description, int imageResourceId){
        this.mLocationName= locationName;
        this.mAddress=address;
        this.mDescription=description;
        this.mImageResourceId=imageResourceId;
    }
    public Location(String locationName, String address, String description){
        this.mLocationName= locationName;
        this.mAddress=address;
        this.mDescription=description;

    }
    public String getLocationName(){
        return this.mLocationName;
    }
    public String getAddress(){
        return this.mAddress;
    }
    public String getDescription(){
        return this.mDescription;
    }
    public int getImageResourceId(){
        return this.mImageResourceId;
    }
    public boolean hasImage(){
        if(this.mImageResourceId==NO_IMAGE){
            return false;
        }else {
            return true;
        }
    }
}
