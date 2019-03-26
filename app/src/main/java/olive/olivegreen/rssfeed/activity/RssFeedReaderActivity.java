package olive.olivegreen.rssfeed.activity;

import olive.olive_green_app.R;
import olive.olivegreen.rssfeed.adapter.RssReaderListAdapter;
import olive.olivegreen.rssfeed.helper.RssFeedStructure;
import olive.olivegreen.rssfeed.helper.XmlHandler;

import java.util.List;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class RssFeedReaderActivity extends Activity {
    /** Called when the activity is first created. */
	
	ListView _rssFeedListView;
	List<JSONObject> jobs ;
	List<RssFeedStructure> rssStr ;
	private RssReaderListAdapter _adapter;
	RssFeedReaderActivity Current_Activity;
	
	String sorti = "";
	String mode = "";
	//Button sort_Btn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rssfeedreaderactivity);
       _rssFeedListView = (ListView)findViewById(R.id.rssfeed_listview);
       
       
       int SDK_INT = android.os.Build.VERSION.SDK_INT;
       if (SDK_INT > 8) 
       {
           StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                   .permitAll().build();
           StrictMode.setThreadPolicy(policy);
       
       //sort_Btn = (Button)findViewById(R.id.sort);
       /*sort_Btn.setText("Change Sorting Mode");
       sort_Btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(sorti.equalsIgnoreCase("")){
				 sorti = "sort";
			}
			if(sorti.equalsIgnoreCase("sort")){
		     sorti = "sort";
		     sort_Btn.setText("Change Reverse Mode");
			 RssFeedTask rssTask = new RssFeedTask();
		     rssTask.execute();
			}
			else if(sorti.equalsIgnoreCase("reverse")){
				 sorti = "reverse";
				 sort_Btn.setText("Change Normal Mode");
				 RssFeedTask rssTask = new RssFeedTask();
			     rssTask.execute();
			}
			else if(sorti.equalsIgnoreCase("normal")){
				sort_Btn.setText("Change Sorting Mode");
				 RssFeedTask rssTask = new RssFeedTask();
			     rssTask.execute();
			}
		}
       
	});*/
       RssFeedTask rssTask = new RssFeedTask();
       rssTask.execute();
       
       }
    }
    private class RssFeedTask extends AsyncTask<String, Void, String> {
		// private String Content;
		private ProgressDialog Dialog;
		String response = "";

		@Override
		protected void onPreExecute() {
			Dialog = new ProgressDialog(RssFeedReaderActivity.this);
			Dialog.setMessage("RSS Feeds Loading...");
			Dialog.show();
		
		}

		@Override
		protected String doInBackground(String... urls) {
			  try {		
				  
				  String feed = "http://www.olivegreens.co.in/blog/latest?format=feed&type=rss";
				  XmlHandler rh = new XmlHandler();
				  rssStr = rh.getLatestArticles(feed);  
			        } catch (Exception e) {
			        }
			return response;

		}

		@Override
		protected void onPostExecute(String result) {
			/*  if(sorti.equalsIgnoreCase("sort")){
				  sorti = "reverse";
			     Collections.sort(rssStr, new SortingOrder());
			     
			  }else if(sorti.equalsIgnoreCase("reverse")){
				  sorti = "normal";
				  Comparator comp = Collections.reverseOrder();
				  Collections.sort(rssStr, new ReverseOrder());
			  }else{
				  sorti = "";
			  }*/
			  if(rssStr != null){
			    _adapter = new RssReaderListAdapter(RssFeedReaderActivity.this,rssStr);
		        _rssFeedListView.setAdapter(_adapter);		        
		       
		        _rssFeedListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
						// TODO Auto-generated method stub
						Intent I_Next = new Intent(Intent.ACTION_VIEW, Uri.parse(rssStr.get(position).getUrl()));	
						//I_Next.setData(Uri.parse(rssStr.get(position).getUrl()));					
						startActivity(I_Next);
						
					}
				});
			  }
			  
			  
		        Dialog.dismiss();
		}
	}
  
}