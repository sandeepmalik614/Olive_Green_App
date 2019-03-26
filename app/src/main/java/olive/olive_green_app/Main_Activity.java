package olive.olive_green_app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Main_Activity extends Activity implements OnClickListener {

	LinearLayout LL_Contact_Us, LL_About_Us, LL_FB, LL_Home, LL_Youtube, LL_Blank;
	String Value_from_Service  = "";
	String Value_from_Splash_Screen= "" ;
	public static boolean temp=true;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen_1);
		
			LL_Contact_Us = (LinearLayout)findViewById(R.id.ll_contact_us);
			LL_About_Us = (LinearLayout)findViewById(R.id.ll_about_us);
			LL_Home = (LinearLayout)findViewById(R.id.ll_home);
			LL_Youtube = (LinearLayout)findViewById(R.id.ll_youtube);
			LL_FB = (LinearLayout)findViewById(R.id.ll_facebook);
			LL_Blank = (LinearLayout)findViewById(R.id.ll_blank);
			
			LL_About_Us.setOnClickListener(this);
			LL_Contact_Us.setOnClickListener(this);
			LL_Home.setOnClickListener(this);
			LL_Youtube.setOnClickListener(this);
			LL_FB.setOnClickListener(this); 
			LL_Blank.setOnClickListener(this); 
			
			Value_from_Service =  getIntent().getStringExtra("Service_Key");
			//Toast.makeText(this, "Value from Service " +Value_from_Service, Toast.LENGTH_SHORT).show();
			
			Value_from_Splash_Screen =  getIntent().getStringExtra("Splash_key");
			//Toast.makeText(this, "Splash Value " +Value_from_Splash_Screen, Toast.LENGTH_SHORT).show();
			
			//LL_Home.performClick();
						
			if(Value_from_Splash_Screen != null && Value_from_Splash_Screen.equalsIgnoreCase("Data_from_Splash_Screen"))
		
			{ 
				//Toast.makeText(this, "Inside SP Toast "+Value_from_Splash_Screen, Toast.LENGTH_SHORT).show();
				runOnUiThread(new Runnable() {
		       	     @Override
		       	     public void run() {

		       	    	 //stuff that updates ui
		       	    	LL_Home.performClick();

		       	    }
		       	});
			}
			
			else if (Value_from_Service !=  null && Value_from_Service.equalsIgnoreCase("Data_From_Service"))
			{
				//Toast.makeText(this, "Inside Service Toast "+Value_from_Service, Toast.LENGTH_SHORT).show();
				runOnUiThread(new Runnable() {
		       	     @Override
		       	     public void run() {

		       	    	 //stuff that updates ui
		       	    	LL_Blank.performClick();

		       	    }
		       	});
			}
		 
	}
	
	public void showAlertDialog() {

		String TXT_About_Us = getApplicationContext().getResources().getString(R.string.about_us_details);
        
		final Dialog AD_About_Us = new Dialog(Main_Activity.this);
		AD_About_Us.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AD_About_Us.setContentView(R.layout.alert_dialog);
        
        
        final TextView TV_Content = (TextView) AD_About_Us.findViewById(R.id.ad_tv_content);
        TV_Content.setText(TXT_About_Us);
        
        final Button BT_Ok = (Button) AD_About_Us.findViewById(R.id.ad_bt_ok);
        BT_Ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AD_About_Us.dismiss();
			}
		});

        AD_About_Us.show();
    }       
	
	public void showExit_AlertDialog() {

		String TXT_About_Us = getApplicationContext().getResources().getString(R.string.about_us_details);
        final Dialog AD_Exit = new Dialog(Main_Activity.this);
       
        AD_Exit.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AD_Exit.setContentView(R.layout.alert_dialog_exit);
        // Thank you Button Listener.
        
        final Button BT_No = (Button) AD_Exit.findViewById(R.id.ad_bt_no);
        BT_No.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AD_Exit.dismiss();
			}
		});

        
        final Button BT_Yes = (Button) AD_Exit.findViewById(R.id.ad_bt_yes);
        BT_Yes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

        AD_Exit.show();
    }     
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		switch(v.getId())
		{
			case R.id.ll_contact_us:				
				
				Fragment M_Contact_Us_Frag = new Main_Contact_Us_Fragment();
				FragmentTransaction FT_Contact_Us = Main_Activity.this.getFragmentManager().beginTransaction();		 
				FT_Contact_Us.replace(R.id.fl_content_frame, M_Contact_Us_Frag);		
				FT_Contact_Us.commit();
				break;
				
			case R.id.ll_about_us:
				
				showAlertDialog();
				
				/*AlertDialog.Builder alertDialogBuilder_H = new AlertDialog.Builder(Main_Activity.this);
				//final AlertDialog alertDialog = alertDialogBuilder_OG.create();
				
				/*String TXT_About_Us = getApplicationContext().getResources().getString(R.string.about_us_details);
				
				final Dialog alertDialogBuilder_OG = new Dialog(getApplicationContext());
				
				alertDialogBuilder_OG.requestWindowFeature(Window.FEATURE_NO_TITLE);
				alertDialogBuilder_OG.setContentView(R.layout.alert_dialog);
				alertDialogBuilder_OG.setCancelable(false);
								
	    		alertDialogBuilder_H.setTitle("About Olive Greens");	    		
	    		alertDialogBuilder_H.setIcon(R.drawable.mainlogo);	    		
	    	    		
	    		String TXT_About_Us = getApplicationContext().getResources().getString(R.string.about_us_details);
	  
	    		alertDialogBuilder_H
	    			.setMessage(TXT_About_Us)
	    			.setCancelable(false)
	    			.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
	    				public void onClick(DialogInterface dialog,int id) {
	    					dialog.cancel();
	    				}
	    			  });
	    			
	    			AlertDialog alertDialog = alertDialogBuilder_H.create();

	    			alertDialog.show();
				
				
				/* final TextView TV_Content = (TextView) alertDialogBuilder_OG.findViewById(R.id.ad_tv_content);
				 TV_Content.setText(TXT_About_Us);
				 
			     final Button BT_Ok = (Button) alertDialogBuilder_OG.findViewById(R.id.ad_bt_ok);
			     BT_Ok.setOnTouchListener(new OnTouchListener() {

			            @Override
			            public boolean onTouch(View arg0, MotionEvent event) {
			                // TODO Auto-generated method stub
			            	alertDialogBuilder_OG.cancel();

			                return true;
			            }

			        });

			     	alertDialogBuilder_OG.show();*/
				
				
	    			break;
	    			     
			case R.id.ll_home:
				
				temp=true;
				Fragment M_Frag = new Main_Image_Fragment();
				FragmentTransaction FT_Main = Main_Activity.this.getFragmentManager().beginTransaction();		 
				FT_Main.replace(R.id.fl_content_frame, M_Frag);		
				FT_Main.commit();
				break;
				
			case R.id.ll_facebook:
				
				Intent I_FaceBook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/olivegreensacademy"));
	            startActivity(I_FaceBook);
	            break;
			
			case R.id.ll_youtube:
				// old url :- https://www.youtube.com/user/ashokog change on 26/03/2019
				Intent I_Youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCquIEZdipkOv4ehGz4eKWqA"));
	            startActivity(I_Youtube);
	            break;
	            
			case R.id.ll_blank:
				
				Fragment M_Blog_Main_RSS_Frag = new Main_List_View_Blog_RSS_Fragment();
				FragmentTransaction FT_Main_Blog_RSS = Main_Activity.this.getFragmentManager().beginTransaction();		 
				FT_Main_Blog_RSS.replace(R.id.fl_content_frame, M_Blog_Main_RSS_Frag);		
				FT_Main_Blog_RSS.commit();
	            break;
			 
		}
		
	}

	public boolean isLvBusy() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void onBackPressed() {
		 //Toast.makeText(this, "temp "+temp, Toast.LENGTH_SHORT).show();
       
		 if(temp)
       {
		/*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		// set title
		alertDialogBuilder.setTitle("Attention..........");
		alertDialogBuilder.setIcon(R.drawable.app_logo);		 
		
		// set dialog message
		alertDialogBuilder
			.setMessage("Do you really want to Exit ?")
			.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					finish();
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();*/
			showExit_AlertDialog();
       }
       else if(!temp)
       {
       	temp=true;
       	runOnUiThread(new Runnable() {
	       	     @Override
	       	     public void run() {

	       	    	 //stuff that updates ui
	       	    	 
	       	    	LL_Home.performClick();

	       	    }
	       	});
       }
       else
       {
       	
       }	
       
	}
}