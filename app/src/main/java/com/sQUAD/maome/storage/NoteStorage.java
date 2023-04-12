package com.sQUAD.maome.storage;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class NoteStorage {
    public ArrayList<Note> storage = new ArrayList<>();

    public void refresh(){
        //добавить в storage из бд
    }

    public void addNote(Note note){
        storage.add(note);
        //заплюнуть note в бд
    }
}
