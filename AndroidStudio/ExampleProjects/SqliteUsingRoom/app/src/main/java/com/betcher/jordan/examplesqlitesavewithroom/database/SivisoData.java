package com.betcher.jordan.examplesqlitesavewithroom.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Siviso")
public class SivisoData
{
	
	@PrimaryKey(autoGenerate = true)
	private int id;
	private String name;
	private String siviso;
	private double latitude;
	private double longitude;
	
	public SivisoData(String name, String siviso, double latitude, double longitude)
	{
		this.name = name;
		this.siviso = siviso;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public String getSiviso()
	{
		return siviso;
	}
}
