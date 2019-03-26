package olive.olive_green_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class BootReceiver extends BroadcastReceiver {
	  @Override
	  public void onReceive(Context context, Intent intent) {
		  	SharedPreferences prefs = context.getSharedPreferences("Mypref", context.MODE_PRIVATE); 
	        String restoredText = prefs.getString("ServiceStatus", null);
	        if(restoredText!=null && restoredText.equalsIgnoreCase("stopped"))
	        {
	        Intent serviceIntent = new Intent(NotificationBackgroundService.class.getName());
	        context.startService(serviceIntent); 
	        }
	  }
	}
