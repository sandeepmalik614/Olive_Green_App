
package olive.olive_green_app;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Main_Contact_Us_Fragment extends Fragment {
	
	TextView TV_Mobile_Number_1, TV_Mobile_Number_2, TV_Mobile_Number_3, TV_Mobile_Number_4;
	WebView WV_Map;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		Main_Activity Act_Main=new Main_Activity();
		Act_Main.temp=false;
		
		View My_Contact_Us_View = inflater.inflate(R.layout.main_activity_contact_us, container, false);
		
		TV_Mobile_Number_1 = (TextView)My_Contact_Us_View.findViewById(R.id.tv_number_1);
		TV_Mobile_Number_2 = (TextView)My_Contact_Us_View.findViewById(R.id.tv_number_2);
		TV_Mobile_Number_3 = (TextView)My_Contact_Us_View.findViewById(R.id.tv_number_3);
		TV_Mobile_Number_4 = (TextView)My_Contact_Us_View.findViewById(R.id.tv_number_4);
		
		// Create a Uri from an intent string. Use the result to create an Intent.
		Uri gmmIntentUri = Uri.parse("google.streetview:cbll=30.708671,76.834495");

		 
		WV_Map = (WebView)My_Contact_Us_View.findViewById(R.id.wv_map);		
		WV_Map.setWebViewClient(new WebViewClient());
		WV_Map.getSettings().setJavaScriptEnabled(true);
		
		WV_Map.loadUrl("https://www.google.co.in/maps/place/Olive+Greens+Institute/@30.7102941,76.8318479,17z/data=!3m1!4b1!4m2!3m1!1s0x390f933162de64a1:0x8225089d474fa263?hl=en");
		
		WV_Map.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            	WV_Map.loadUrl("file:///android_asset/olive_err_load_image.html");

            }
        });
		
		TV_Mobile_Number_1.setOnClickListener(TV_OnClickListener);
		TV_Mobile_Number_2.setOnClickListener(TV_OnClickListener);
		TV_Mobile_Number_3.setOnClickListener(TV_OnClickListener);
		TV_Mobile_Number_4.setOnClickListener(TV_OnClickListener);
		
		return My_Contact_Us_View;
	}
	

	OnClickListener TV_OnClickListener = new OnClickListener(){

		@Override
		public void onClick(View V) {
		
			 Intent I_Dial_Number = null;
			switch(V.getId())
			{
			case R.id.tv_number_1:
				
				  I_Dial_Number =new Intent(Intent.ACTION_CALL, Uri.parse("tel:09316016788"));
		          startActivity(I_Dial_Number);
		          break;
			case R.id.tv_number_2:
				
				  I_Dial_Number =new Intent(Intent.ACTION_CALL, Uri.parse("tel:09915898344"));
		          startActivity(I_Dial_Number);
		          break;    
			case R.id.tv_number_3:
				
				  I_Dial_Number =new Intent(Intent.ACTION_CALL, Uri.parse("tel:09357249717"));
		          startActivity(I_Dial_Number);
		          break;    
			case R.id.tv_number_4:
				
				  I_Dial_Number =new Intent(Intent.ACTION_CALL, Uri.parse("tel:09465176427"));
		          startActivity(I_Dial_Number);
		          break;    
			} 
			
		}
	};
	
	
}
