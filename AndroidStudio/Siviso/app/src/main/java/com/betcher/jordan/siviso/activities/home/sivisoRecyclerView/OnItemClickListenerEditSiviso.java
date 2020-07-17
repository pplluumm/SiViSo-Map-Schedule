package com.betcher.jordan.siviso.activities.home.sivisoRecyclerView;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.betcher.jordan.siviso.Defaults;
import com.betcher.jordan.siviso.Preferences_Siviso;
import com.betcher.jordan.siviso.database.SivisoData;
import com.betcher.jordan.siviso.database.SivisoModel;
import com.betcher.jordan.siviso.siviso.Siviso;
import com.google.android.gms.maps.model.LatLng;

class OnItemClickListenerEditSiviso
		implements AdapterView.OnItemSelectedListener
{
	private static final String TAG = "OnItemClickListenerEdit";
	SivisoData currentSivisoData;
	private Context context;
	private SivisoModel sivisoModel;
	private Spinner spinnerSiviso;
	
	
	public OnItemClickListenerEditSiviso(Context context, SivisoModel sivisoModel,
	                                     Spinner spinnerSiviso)
	{
		this.context = context;
		this.sivisoModel = sivisoModel;
		this.spinnerSiviso = spinnerSiviso;
	}
	
	public void setSivisoData(SivisoData currentSivisoData)
	{
		this.currentSivisoData = currentSivisoData;
	}
	
	private void editSivisoData()
	{
		
		
		String name = currentSivisoData.name();
		String sivisoName = spinnerSiviso.getSelectedItem().toString();
		Siviso siviso = Siviso.siviso(sivisoName);
		
		if(name == Defaults.DEFAULT_SIVISO_NAME)
		{
			Preferences_Siviso.saveDefaultSiviso(context, siviso);
		}
		else
		{
			LatLng latLng = currentSivisoData.latLng();
			
			SivisoData sivisoData = new SivisoData(name, siviso.name(), latLng.latitude, latLng.longitude);
			sivisoData.setId(currentSivisoData.id());
			
			sivisoModel.update(sivisoData);
		}
	}
	
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{
		editSivisoData();
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{
	
	}
}
