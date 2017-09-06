package com.example.lenovo.sporteventexample.data;

import java.util.List;

/**
 * Created by root on 11/6/17.
 */

public class Event {

    public static final String TITLE = "title";
    public static final String CITY = "city";
    public static final String DESCRIPTION = "description";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String COVER_IMAGE = "coverImage";
    public static final String IMAGES = "images";
    public static final String VENUE = "venue";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String IS_ENABLED = "isEnabled";
    public static final String IS_VERIFIED = "isVerified";
    public static final String PROFILE_PICTURE = "profilePicture";

    private String id;
    private String city;
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    private String coverImage;
    private List<String> images;
    private String venue;
    private String latitude;
    private String longitude;
    private String userId;
    private String userName;
    private boolean isEnabled;
    private boolean isVerified;
    private String profilePicture;
    private static Event event;

    public Event(){

    }

    public static Event getInstance(){
        if(event == null){
            return new Event();
        }
        return event;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
