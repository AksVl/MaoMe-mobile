package com.sQUAD.maome.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sQUAD.maome.R;
import com.sQUAD.maome.storage.Note;
import com.sQUAD.maome.storage.NoteStorage;
import com.sQUAD.maome.databinding.FragmentMapBinding;

import java.util.Objects;

public class MapFragment extends Fragment{
    private FragmentMapBinding binding;
    private GoogleMap myMap;
    protected static NoteStorage storage;
    protected static LatLng currentLatLng;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //storage.refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.add.setOnClickListener(v -> {
            DialogAddFragment dialog = new DialogAddFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            dialog.show(fragmentManager.beginTransaction().addToBackStack("dialog"), "dialog");
        });
        ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.google_map)).getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        googleMap.clear();
                        googleMap.addMarker(new MarkerOptions().position(latLng));
                        currentLatLng = latLng;
                    }
                });
                for (Note note : storage.storage) {
                    googleMap.addMarker(new MarkerOptions().position(note.getLatLng()));
                }
            }
        });
    }
}