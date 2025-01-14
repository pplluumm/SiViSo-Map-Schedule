package com.jordan.betcher.sivisoLite.activities.home.setup;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;

import com.jordan.betcher.sivisoLite.Defaults;
import com.jordan.betcher.sivisoLite.activities.Home;

public class SetupPermissions
{
	public static void run(Home home)
	{
		permissionFineLocation(home);
		permissionNotificationPolicy(home);
	}
	
	private static void permissionFineLocation(Home home)
	{
		if
		(
			ActivityCompat.checkSelfPermission(home, Manifest.permission.ACCESS_FINE_LOCATION)
			!= PackageManager.PERMISSION_GRANTED
		    && ActivityCompat.checkSelfPermission(home, Manifest.permission.ACCESS_COARSE_LOCATION)
	        != PackageManager.PERMISSION_GRANTED
		)
		{
			ActivityCompat
			.requestPermissions
			(
				home,
				new String[]
				{
					Manifest.permission.ACCESS_FINE_LOCATION
				},
				Defaults.REQUEST_LOCATION_PERMISSION
			);
		}
	}
	
	private static void permissionNotificationPolicy(Home home)
	{
		NotificationManager notificationManager =
		(NotificationManager) home.getSystemService(
		Context.NOTIFICATION_SERVICE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
		    && !notificationManager.isNotificationPolicyAccessGranted())
		{
			
			Intent intent = new Intent(
			android.provider.Settings
			.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
			
			home.startActivity(intent);
		}
	}
}
