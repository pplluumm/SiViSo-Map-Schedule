package com.betcher.jordan.examplegooglemapinmultipleactivitiesusingfragments;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

	private GoogleMap mMap;
	private FragmentMap fragmentMap;

	//How to use fragments
	//https://youtu.be/i22INe14JUc
	//https://codinginflow.com/tutorials/android/fragment-to-fragment-communication-with-interfaces
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);
		
		Intent intent = new Intent(this, ActivityMap1.class);
		startActivity(intent);
		
		/*
		MapView mapView = findViewById(R.id.mapView);
		mapView.onCreate(null);
		mapView.getMapAsync(this);
		
		/*
		fragmentMap = new FragmentMap();
		
		getSupportFragmentManager().beginTransaction()
		                           .replace(R.id.frameLayout, fragmentMap)
		                           .commit();
		
		/*
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
		//*/
	}


	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		mMap = googleMap;

		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(-34, 151);
		mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
		mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
	}
}
