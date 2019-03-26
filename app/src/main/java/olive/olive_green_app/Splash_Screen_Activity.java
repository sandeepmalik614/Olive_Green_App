package olive.olive_green_app;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash_Screen_Activity extends Activity {
	
	Thread Splash_Thread; 
	PendingIntent PI;
	ProgressBar P_Bar;	
	Boolean Service_Status;
	AlarmManager AM ;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
              
        P_Bar = (ProgressBar)findViewById(R.id.pb);
        P_Bar.setVisibility(1);
      
        Calendar calendar =  Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 8, 00, 00);
        long When = calendar.getTimeInMillis();
        
        //Service_Status = isMyServiceRunning(AM_Service.class);
        Intent MI = new Intent(getApplicationContext(), NotificationBackgroundService.class);
        PI = PendingIntent.getBroadcast(getApplicationContext(), 0, MI,PendingIntent.FLAG_UPDATE_CURRENT);
       
        SharedPreferences prefs = getSharedPreferences("Mypref", MODE_PRIVATE); 
        String restoredText = prefs.getString("Status", "First_Launch");
     
        if (restoredText.equalsIgnoreCase("First_Launch")) {
                  
         
        	/*SharedPreferences.Editor editor = getSharedPreferences("Mypref", MODE_PRIVATE).edit();
        	editor.putString("Status", "Already_Launched");        	
        	editor.commit();
        	               
	        AM = (AlarmManager)getSystemService(ALARM_SERVICE);
	        AM.setRepeating(AlarmManager.RTC_WAKEUP, When, 60*1000*60*6, PI);*/
        	
        	//startService(new Intent(NotificationBackgroundService.class.getName()));
        	
        	Intent serviceIntent = new Intent(getApplicationContext(),NotificationBackgroundService.class);
        	startService(serviceIntent).getClassName();
	        
        }
        else
        {
        	 //Toast.makeText(this, "Service Status "+restoredText, Toast.LENGTH_SHORT).show();	
        }
        
        Splash_Thread = new Thread() {  	
        	
           @Override
           public void run() {
              try {
            	  
                 sleep(2000);
                 
              } catch (InterruptedException e) {

              } 
              
              finally {
            	  
            	 finish();
                 Intent I_Move_to_Next_Screen = new Intent(Splash_Screen_Activity.this, Main_Activity.class);
                 I_Move_to_Next_Screen.putExtra("Splash_key", "Data_from_Splash_Screen");
                 startActivity(I_Move_to_Next_Screen);
                 
              }
           }
        };
        Splash_Thread.start();
    }
    
   /* private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }*/
    
 }




