package com.sQUAD.maome.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.maps.model.LatLng;
import com.sQUAD.maome.R;
import com.sQUAD.maome.databinding.FragmentDialogAddBinding;
import com.sQUAD.maome.storage.Note;
import com.sQUAD.maome.storage.NoteStorage;

public class DialogAddFragment extends DialogFragment {

    private String address;
    private String title;
    private String text;
    private String userName;
    private Uri imageUri;
    private LatLng latLng;
    private FragmentDialogAddBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogAddBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addPhoto.setOnClickListener(v -> {
            ImagePicker.with(this)
                    .crop()	    			//Crop image(Optional), Check Customization for more option
                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                    .start();
        });
        binding.create.setOnClickListener(v -> {
            title = binding.title.getText().toString();
            text = binding.text.getText().toString();
            latLng = MapFragment.currentLatLng;
            userName = "hehehe";
            if(imageUri != null && !title.equals("") && !text.equals("") && latLng != null && userName != null) {
                Note note = new Note(1,title, text, userName, imageUri, latLng);
                //MapFragment.storage.addNote(note);
                onDestroyView();
            } else{
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageUri = data.getData();
        binding.photo.setImageURI(imageUri);
    }
}