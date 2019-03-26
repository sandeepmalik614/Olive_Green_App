package olive.olive_green_app;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//public class Faculty_Detail_Activity extends Activity {
public class Faculty_Detail_Activity extends Fragment {

    //protected void onCreate(Bundle savedInstanceState) {
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {	
    	
    	ImageView IV_Faculty_Img;
    	TextView TV_Faculty_Desc;
    	LinearLayout LL_Call, LL_FB, LL_Email;
    	final int Faculty_Position;	
    	final String emailSubject = "This is Message from the Android App";
    	final String[]  Email_To;
    	
    	int[] Faculty_Images_Array = {R.drawable.faculty_image_1,R.drawable.faculty_image_2,
    			   R.drawable.faculty_image_3, R.drawable.faculty_image_4, R.drawable.faculty_image_5
    		      , R.drawable.faculty_image_6, R.drawable.faculty_image_7, R.drawable.faculty_image_8, R.drawable.faculty_image_9};
    	
    	View Faculty_Detail_View = inflater.inflate(R.layout.faculty_detail_layout, container, false);
		       
        IV_Faculty_Img = (ImageView) Faculty_Detail_View.findViewById(R.id.iv_faculty_image);
        TV_Faculty_Desc = (TextView) Faculty_Detail_View.findViewById(R.id.tv_faculty_desc);
        LL_Call = (LinearLayout) Faculty_Detail_View.findViewById(R.id.ll_faculty_call);
        LL_FB = (LinearLayout) Faculty_Detail_View.findViewById(R.id.ll_faculty_fb_link);
        LL_Email = (LinearLayout) Faculty_Detail_View.findViewById(R.id.ll_faculty_email);
        
        //savedInstanceState =  getIntent().getExtras();
        //Faculty_Position = savedInstanceState.getInt("Faculty_Position");
        
        savedInstanceState = getArguments();
        Faculty_Position =  savedInstanceState.getInt("Faculty_Position");
        
        //Toast.makeText(getActivity(), "Faculty Position "+Faculty_Position, Toast.LENGTH_SHORT).show();
        
        final String[] Faculty_Desc = getResources().getStringArray(R.array.faculty_describtion);
        final String[] Faculty_Emails = getResources().getStringArray(R.array.faculty_email_links);
        final String[] Faculty_FB_links = getResources().getStringArray(R.array.faculty_fb_links);
        final String[] Faculty_Phone_Number = getResources().getStringArray(R.array.faculty_phone_numbers);
        
        IV_Faculty_Img.setImageResource(Faculty_Images_Array[Faculty_Position]);
        TV_Faculty_Desc.setText(Faculty_Desc[Faculty_Position]);
        
        Email_To = new String[2];
		Email_To[0] = Faculty_Emails[Faculty_Position]; 
                
        LL_Email.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent I_Mail;
				I_Mail=new Intent(Intent.ACTION_SEND);
				I_Mail.setType("plain/text");
		          
				//I_Mail.putExtra(Intent.EXTRA_EMAIL,Faculty_Emails[Faculty_Position]);
				I_Mail.putExtra(Intent.EXTRA_EMAIL,Email_To);
				I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
				startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
				
			}
			
        });
        
        LL_Call.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent I_Dial;
				I_Dial=new Intent(Intent.ACTION_DIAL);  
				I_Dial.setData(Uri.parse("tel: "+Faculty_Phone_Number[Faculty_Position]));  
				startActivity(I_Dial);
				}
			
        });
        
        
        LL_FB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent I_View;
				I_View=new Intent(Intent.ACTION_VIEW);  
				I_View.setData(Uri.parse(Faculty_FB_links[Faculty_Position]));  
				startActivity(I_View);
				}
			
        });
        
        
        
        return Faculty_Detail_View;
				// TODO Auto-generated method stub
				//int tt = v.getId();
		
				
				/*Intent I_Mail = null;
				switch (Faculty_Position)
				{
				case 0:

					String[] email_0 = {"rs@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_0);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 1:					 
					String[] email_1 = {"ashokan@olivegreens.in"}; 
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_1);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 2:
				 				
					String[] email_2 = {"dj@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_2);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 3:
 					
					String[] email_3 = {"nanu@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_3);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
				
				case 4:
 					
					String[] email_4 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_4);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 5:
					
					String[] email_5 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_5);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;	
					
				case 6:
 					
					String[] email_6 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_6);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 7:
 					
					String[] email_7 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_7);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
				case 8:

					String[] email_8 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_8);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
					
				case 9:
 					
					String[] email_9 = {"info@olivegreens.in"};
					I_Mail=new Intent(Intent.ACTION_SEND);
					I_Mail.setType("plain/text");
			          
					I_Mail.putExtra(Intent.EXTRA_EMAIL,email_9);
					I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
					startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
					break;
			
				default:
					
					Toast.makeText(getApplicationContext(), "Default: "+Faculty_Position, Toast.LENGTH_LONG).show();
			
				}
			}
		});*/
        
        
      
			
			/*@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent I_Dial = null;
				//int TV_ID = v.getId();
				//Toast.makeText(activity, "Call: "+tt+"Pos "+position, Toast.LENGTH_LONG).show();
				
				switch (Faculty_Position)
				{
				case 0:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:09316529717"));  
					startActivity(I_Dial);  
					break;
				
				case 1:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:09316016788"));  
					startActivity(I_Dial); 
					break;
				case 2:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:09915898344"));  
					startActivity(I_Dial); 
					break;
				case 3:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:09357249717"));  
					startActivity(I_Dial); 
					break;
				case 4:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:0"));  
					startActivity(I_Dial); 
					break;
				case 5:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:0"));  
					startActivity(I_Dial); 
					break;
				case 6:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:0"));  
					startActivity(I_Dial); 
					break;
				case 7:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:0"));  
					startActivity(I_Dial); 
					break;
				case 8:
					I_Dial=new Intent(Intent.ACTION_DIAL);  
					I_Dial.setData(Uri.parse("tel:0"));  
					startActivity(I_Dial); 
					break;
					
				default:
					
					Toast.makeText(getApplicationContext(), "Default: "+Faculty_Position, Toast.LENGTH_LONG).show();
			
				}
			}
		}); */
    }
    
}

    