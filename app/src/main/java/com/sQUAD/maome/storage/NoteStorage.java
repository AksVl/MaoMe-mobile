package com.sQUAD.maome.storage;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class NoteStorage {
    public ArrayList<Note> storage = new ArrayList<>();
    public static int count = 0;


    public void refresh(){
        //TODO добавить в storage заметки из бд
    }

    public void addNote(Note note){
        storage.add(note);
        count++;
        //TODO запихать note в бд
    }
}
