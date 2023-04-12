package com.sQUAD.maome.storage;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class Note {
    private final long id;
    private final String title;
    private final String text;
    private final String userName;
    private final Uri imageUri;
    private final LatLng latLng;

    public LatLng getLatLng() {
        return latLng;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public Note(long id, String title, String text, String userName, Uri imageUri, LatLng latLng) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.userName = userName;
        this.imageUri = imageUri;
        this.latLng = latLng;
    }
}
