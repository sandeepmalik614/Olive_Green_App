package olive.olive_green_app;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/*import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;*/

public class Main_Quick_Contact_Fragment extends Fragment {
	
	//TextView TV; 
	
	ImageView IV_Photo;
	Button BT_Submit;
	EditText ET_Name, ET_Mobile_No, ET_Query;
	String str_name, str_mobile_no, str_email_id, str_query,img_str;
	String str_course_interested_in = null, act_pref = null;
	String str_screen_ref;
	String[]  Email_To;
	ProgressDialog P_Dialog_QC;	
	
	// flag for Internet connection status
	 Boolean isInternetPresent = false;
		
	// Connection detector class
	ConnectionDetector CD;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		Main_Activity Act_Main=new Main_Activity();
		Act_Main.temp=false;
		
		View My_Contact_Us_View = inflater.inflate(R.layout.new_quick_contact, container, false);
		
		ET_Name = (EditText)My_Contact_Us_View.findViewById(R.id.et_name);
		ET_Mobile_No = (EditText)My_Contact_Us_View.findViewById(R.id.et_mobile_no);
		ET_Query = (EditText)My_Contact_Us_View.findViewById(R.id.et_query);
		BT_Submit = (Button)My_Contact_Us_View.findViewById(R.id.bt_submit);
		
		Email_To = new String[2];
		Email_To[0] = "info@olivegreens.in"; 
		
						
		BT_Submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				
				if(ET_Name.length() == 0 )
				    ET_Name.setError( "Name is required !" );
				else if(ET_Mobile_No.length() == 0 )
					ET_Mobile_No.setError( "Mobile No. is required !" );				
				else if(ET_Query.length() == 0 )
					ET_Query.setError( "Query is required !" );							 
				 	
				else {
					
					String Email_Name = ET_Name.getText().toString();
					String Mobile_Number = ET_Mobile_No.getText().toString();
					String Email_Query = ET_Query.getText().toString();
					
					Intent I_Mail;
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,Email_To);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,"This is an Email from the Contact Us Form.");		
					I_Mail.putExtra(Intent.EXTRA_TEXT," Name : "+Email_Name+" \n\n"+" Mobile : "+Mobile_Number+" \n\n"+" Message from User : "+ Email_Query);
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));
					
					ET_Mobile_No.setText(" ");
					ET_Name.setText(" ");
					ET_Query.setText(" ");
				
				}
				
			}
		});
		
		return My_Contact_Us_View;
	}
	
}