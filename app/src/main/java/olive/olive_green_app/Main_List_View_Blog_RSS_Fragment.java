package olive.olive_green_app;


import olive.olivegreen.rssfeed.activity.RssFeedReaderActivity;
import olive.olivegreen.rssfeed.adapter.RssReaderListAdapter;
import olive.olivegreen.rssfeed.helper.RssFeedStructure;
import olive.olivegreen.rssfeed.helper.XmlHandler;

import java.util.List;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Main_List_View_Blog_RSS_Fragment extends Fragment  {
	
	ListView LV_Blog_RSS;	
	List<JSONObject> jobs ;
	List<RssFeedStructure> rssStr ,rssStr1,rssFinal;
	ImageView IB_Post_Backward,IB_Post_Farward;
	TextView TV_Blog_count;
	int i=1;
	
	private RssReaderListAdapter _adapter;
	RssFeedReaderActivity Current_Activity;
	ConnectionDetector CD;
	Boolean isInternetPresent;
	private ProgressDialog Dialog;
	
	String sorti = "";
	String mode = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		Main_Activity activity1=new Main_Activity();
		activity1.temp=false;
		View My_List_View_Blog_RSS = inflater.inflate(R.layout.rssfeedreaderactivity, container, false);
		
		LV_Blog_RSS = (ListView)My_List_View_Blog_RSS.findViewById(R.id.rssfeed_listview);
		IB_Post_Backward=(ImageView)My_List_View_Blog_RSS.findViewById(R.id.ib_backward);
		TV_Blog_count=(TextView)My_List_View_Blog_RSS.findViewById(R.id.tv_blog_count);
				
		
		IB_Post_Backward.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i++;
				RssFeedTask rssTask = new RssFeedTask();
			       rssTask.execute();
			       IB_Post_Farward.setVisibility(View.VISIBLE);
				
				
			}
		});
		
		
IB_Post_Farward=(ImageView)My_List_View_Blog_RSS.findViewById(R.id.ib_farward);
		
		IB_Post_Farward.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i--;
				if(i==1)
				{
					IB_Post_Farward.setVisibility(View.INVISIBLE);
				}
				IB_Post_Backward.setVisibility(View.VISIBLE);
				RssFeedTask rssTask = new RssFeedTask();
			       rssTask.execute();
				
				
			}
		});
		
		CD = new ConnectionDetector(getActivity());
		
		// get Internet status
		isInternetPresent = CD.isConnectingToInternet();
		
		 int SDK_INT = android.os.Build.VERSION.SDK_INT;
	       if (SDK_INT > 8) 
	       {
	           StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
	                   .permitAll().build();
	           StrictMode.setThreadPolicy(policy);
	       
	       if(isInternetPresent)
	       	{
	    	       RssFeedTask rssTask = new RssFeedTask();
			       rssTask.execute();
			       
	       	}
	       else
	       {
	    	   showAlertDialog(getActivity(), "No Internet Connection Detected",
						"Sorry, You don't have Internet Connection. Please Turn On the Internet to continue.", false);
	       }
	       }
	       
	       return My_List_View_Blog_RSS;   
	}
	 
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message, Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);
		
		alertDialog.setCancelable(false);
		
		// Setting alert dialog icon
		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				getActivity().getFragmentManager().popBackStack();
				
				Fragment M_Frag = new Main_Image_Fragment();
				FragmentTransaction FT_Main = getActivity().getFragmentManager().beginTransaction();		 
				FT_Main.replace(R.id.fl_content_frame, M_Frag);		
				FT_Main.commit();
				 
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}
	 private class RssFeedTask extends AsyncTask<String, Void, String> {
			// private String Content;
			private ProgressDialog Dialog;
			String response = "";

			@Override
			protected void onPreExecute() {
				Dialog = new ProgressDialog(getActivity());
				Dialog.setMessage("Loading Updates via RSS Feeds.....");
				Dialog.setCancelable(false);
				Dialog.show();
			
			}

			@Override
			protected String doInBackground(String... urls) {
				  try {	
					  String feed="";
					 if(i==1)
					 {
					   feed = "https://www.olivegreens.co.in/blog/latest?format=feed&type=rss";
					  
					 }
					 else
						 {
						  feed = "https://www.olivegreens.co.in/blog/latest/Page-"+i+"?format=feed&type=rss";
						 }
						 //String feed2 = "http://www.olivegreens.co.in/blog/latest/Page-3?format=feed&type=rss";
					  //String feed3 = "http://www.olivegreens.co.in/blog/latest/Page-4?format=feed&type=rss";
						 
				
					 
					  XmlHandler rh = new XmlHandler();
					  rssStr = rh.getLatestArticles(feed); 
					  //rssStr1 = rh.getLatestArticles(feed1); 
					 //rssFinal.addAll(rssStr);
					//for(int i=0;i<=5;i++)
					{
					  Log.e("zzzz", String.valueOf(rssStr.size()));
					}
					
				        } catch (Exception e) {
				        } 
				return response;

			}

			@Override
			protected void onPostExecute(String result) {
			
				  if(rssStr != null && rssStr.size()==5){
				    _adapter = new RssReaderListAdapter(getActivity(),rssStr);
				    LV_Blog_RSS.setAdapter(_adapter);     
				    if(i==1)
				    {
				    TV_Blog_count.setText(""+i);
				    }
				    else
				    {
				    	 TV_Blog_count.setText(""+i);
				    }
				    // rssStr.clear();
				  //  _adapter = new RssReaderListAdapter(getActivity(),rssStr1);
				   // LV_Blog_RSS.setAdapter(_adapter);   
					//Dialog.dismiss();
				    
				    LV_Blog_RSS.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent, View view,
								int position, long id) {
							
							// TODO Auto-generated method stub
							if(rssStr.size()==5)
							{
							Intent I_Next = new Intent(Intent.ACTION_VIEW, Uri.parse(rssStr.get(position).getUrl()));	
							startActivity(I_Next);
							}
							
							
						
						}
					});
				  }
				  else
				  {
					LV_Blog_RSS.setAdapter(null); 
					 rssStr.clear(); 
					  IB_Post_Backward.setVisibility(View.INVISIBLE);
					  Toast.makeText(getActivity(), "No further updates", Toast.LENGTH_SHORT).show();
				  }
				 Dialog.dismiss();
				  
			}
			
	 }
	 
}