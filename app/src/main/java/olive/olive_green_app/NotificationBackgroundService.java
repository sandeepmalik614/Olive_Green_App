package olive.olive_green_app;


import olive.olivegreen.rssfeed.helper.XmlHandler;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.StrictMode;
import android.util.Log;

public class NotificationBackgroundService extends Service {

    private static final String TAG = NotificationBackgroundService.class.getSimpleName();
    private Timer timer;
    private ConnectionDetector CD;
    private boolean isInternetPresent;
    private NotificationManager NM;

    private TimerTask updateTask = new TimerTask() {
        @Override
        public void run() {
            Log.i(TAG, "Timer task doing work");
            CD = new ConnectionDetector(getApplicationContext());

            // get Internet status
            isInternetPresent = CD.isConnectingToInternet();

            int SDK_INT = android.os.Build.VERSION.SDK_INT;
            if (SDK_INT > 8) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);

                if (isInternetPresent) {
                    RssFeedTask rssTask = new RssFeedTask();
                    rssTask.execute();
                } else {
                    //Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();
                }

            }

        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service creating");
        SharedPreferences.Editor editor = getSharedPreferences("Mypref", MODE_PRIVATE).edit();
        editor.putString("ServiceStatus", "running");
        editor.commit();
        timer = new Timer("NotificationTimer");
        timer.schedule(updateTask, 60 * 1000 * 60 * 2, 60 * 1000 * 60 * 12);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroying");
        timer.cancel();
        timer = null;
        SharedPreferences.Editor editor = getSharedPreferences("Mypref", MODE_PRIVATE).edit();
        editor.putString("ServiceStatus", "stopped");
        editor.commit();
    }

    private class RssFeedTask extends AsyncTask<String, Void, String> {

        public String response = "";
        public String[] Grab_Title;


        @Override
        protected void onPreExecute() {


        }

        @SuppressWarnings("deprecation")
        @Override
        protected String doInBackground(String... urls) {
            try {

                String feed = "http://www.olivegreens.co.in/blog/latest?format=feed&type=rss";
                XmlHandler rh = new XmlHandler();
                //rssStr = rh.getLatestArticles(feed);
                Grab_Title = rh.get_Title(feed);

                for (int i = 0; i < Grab_Title.length; i++) {

                    Log.i("Grab_Title ", Grab_Title[i]);
                }

                response = Grab_Title[1];


            } catch (Exception e) {
            }
            return response;

        }

        @Override
        protected void onPostExecute(String result) {

            NM = (NotificationManager) getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
            Intent I_S = new Intent(getApplicationContext(), Main_Activity.class);
            I_S.putExtra("Service_Key", "Data_From_Service");
            I_S.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            @SuppressWarnings("deprecation")
            Notification notification = new Notification(R.drawable.new_app_logo, "Notification from Olive Greens", System.currentTimeMillis());
            notification.largeIcon = (((BitmapDrawable) getApplicationContext().getResources().getDrawable(R.drawable.app_logo)).getBitmap());

            PendingIntent pendingNotificationIntent = PendingIntent.getActivity(getApplicationContext(), 0, I_S, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notification.defaults |= Notification.DEFAULT_SOUND;
            notification.defaults |= Notification.DEFAULT_VIBRATE;
            notification.defaults |= Notification.DEFAULT_LIGHTS;

            Notification.Builder builder = new Notification.Builder(getApplicationContext());

            builder.setContentTitle("Olive Greens RSS Feeds");
            builder.setContentText(Grab_Title[1]);
            builder.setContentIntent(pendingNotificationIntent);
            builder.setOngoing(true);

//			       notification.setLatestEventInfo(getApplicationContext(), "Olive Greens RSS Feeds" , Grab_Title[1], pendingNotificationIntent);

            notification = builder.build();
            NM.notify(0, notification);
            stopService(new Intent(getApplicationContext(), getClass()));

            // Toast.makeText(getApplicationContext(), "Service Status "+"Service has been Destroyed", Toast.LENGTH_SHORT).show();
        }
    }


}
