package olive.olive_green_app;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter extends BaseAdapter implements OnClickListener {
    
   /*********** Declare Used Variables *********/
   private Activity activity;
   private ArrayList data;
   private Context context;
   private static LayoutInflater inflater=null;
   public Resources res;
   List_Model tempValues=null;  
   
  // String emailSubject = "This is Message from the Android App";
   
   int[] Faculty_Images_Array = {R.drawable.faculty_image_1,R.drawable.faculty_image_2,
		   R.drawable.faculty_image_3, R.drawable.faculty_image_4, R.drawable.faculty_image_5
	      , R.drawable.faculty_image_6, R.drawable.faculty_image_7, R.drawable.faculty_image_8, R.drawable.faculty_image_9};
   int i=0;
    
   /*************  CustomAdapter Constructor *****************/
   public CustomAdapter(Activity a, ArrayList d,Resources resLocal) {
        
          /********** Take passed values **********/
           activity = a;
	   	   data=d;
           res = resLocal;
        
           /***********  Layout inflator to call external xml layout () ***********/
            inflater = ( LayoutInflater )activity.
                                       getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
   }

   /******** What is the size of Passed Arraylist Size ************/
   public int getCount() {
        
       if(data.size()<=0)
           return 1;
       return data.size();
   }

   public Object getItem(int position) {
       return position;
   }

   public long getItemId(int position) {
       return position;
   }
    
   /********* Create a holder Class to contain inflated xml file elements *********/
   public static class ViewHolder{
        
       public TextView TV_Faculty_Name;
       public TextView TV_Faculty_Desc;
       public TextView TV_Faculty_Call_Details;
       public TextView TV_Faculty_FB_Details;
       public ImageView IV_Faculty_Image;

   }

   /****** Depends upon data size called for each row , Create each ListView row *****/
   public View getView(final int position, View convertView, ViewGroup parent) {
        
	   
       View vi = convertView;
       ViewHolder holder;    
       
        
       if(convertView==null){
            
           /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
           vi = inflater.inflate(R.layout.faculty_list_row, null);
            
           /****** View Holder Object to contain tabitem.xml file elements ******/

           holder = new ViewHolder();
           holder.TV_Faculty_Name = (TextView) vi.findViewById(R.id.tv_about_faculty_name);
           holder.TV_Faculty_Desc = (TextView) vi.findViewById(R.id.tv_about_faculty_desc);
           holder.IV_Faculty_Image=(ImageView)vi.findViewById(R.id.iv_faculty_image);
           
           //holder.TV_Faculty_FB_Details=(TextView)vi.findViewById(R.id.tv_fb_details);
           //holder.TV_Faculty_Call_Details=(TextView)vi.findViewById(R.id.tv_call_details);
           
            
          /************  Set holder with LayoutInflater ************/
           vi.setTag( holder );
       }
       else 
           holder=(ViewHolder)vi.getTag();
        
       if(data.size()<=0)
       {
           holder.TV_Faculty_Name.setText("No Data");
            
       }
       else
       {
           /***** Get each Model object from Arraylist ********/
           tempValues=null;
           tempValues = ( List_Model ) data.get( position );
            
           /************  Set Model values in Holder elements ***********/

            holder.TV_Faculty_Name.setText( tempValues.getFacultyName() );
            holder.TV_Faculty_Desc.setText( tempValues.getFacultyDescription() );
            //holder.TV_Faculty_FB_Details.setText( tempValues.getFacultyFBUrl() );
            /*holder.image.setImageDrawable(   
                         "com.androidexample.customlistview:drawable/"+tempValues.getFacultyImage()); */
                         //,null,null);
             holder.IV_Faculty_Image.setImageResource(Faculty_Images_Array[position]);
            /******** Set Item Click Listner for LayoutInflater for each row *******/
             
       }

            vi.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//Toast.makeText(activity, "Position "+position, Toast.LENGTH_LONG).show();
					
					Bundle args = new Bundle();
				    args.putInt("Faculty_Position", position);
				    
					Fragment M_Faculty_Detail_Frag = new Faculty_Detail_Activity();
					M_Faculty_Detail_Frag.setArguments(args);
					FragmentTransaction FT_Faculty_Detail_Frag = activity.getFragmentManager().beginTransaction();		 
					FT_Faculty_Detail_Frag.replace(R.id.fl_content_frame, M_Faculty_Detail_Frag);
					FT_Faculty_Detail_Frag.commit();
					
					
					/*Intent I_Detail = new Intent(activity, Faculty_Detail_Activity.class);
					I_Detail.putExtra("Faculty_Position", position);
					activity.startActivity(I_Detail);*/
				}
			});
             
            
          /*  holder.TV_Faculty_FB_Details.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//int tt = v.getId();
					
					Intent I_Mail = null;
					switch (position)
					{
					case 0:

						String[] email_0 = {"rs@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_0);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 1:					 
						String[] email_1 = {"ashokan@olivegreens.in"}; 
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_1);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 2:
					 				
						String[] email_2 = {"dj@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_2);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 3:
	 					
						String[] email_3 = {"nanu@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_3);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
					
					case 4:
	 					
						String[] email_4 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_4);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 5:
						
						String[] email_5 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_5);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;	
						
					case 6:
	 					
						String[] email_6 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_6);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 7:
	 					
						String[] email_7 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_7);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
					case 8:
	
						String[] email_8 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_8);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
						
					case 9:
	 					
						String[] email_9 = {"info@olivegreens.in"};
						I_Mail=new Intent(Intent.ACTION_SEND);
						I_Mail.setType("plain/text");
				          
						I_Mail.putExtra(Intent.EXTRA_EMAIL,email_9);
						I_Mail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);						  
						activity.startActivity(Intent.createChooser(I_Mail, "Choose One to end"));  
						break;
				
					default:
						
						Toast.makeText(activity, "Default: "+position, Toast.LENGTH_LONG).show();
				
					}
				}
			});
            
            holder.TV_Faculty_Call_Details.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent I_Dial = null;
					//int TV_ID = v.getId();
					//Toast.makeText(activity, "Call: "+tt+"Pos "+position, Toast.LENGTH_LONG).show();
					
					switch (position)
					{
					case 0:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:09316529717"));  
						activity.startActivity(I_Dial);  
						break;
					
					case 1:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:09316016788"));  
						activity.startActivity(I_Dial); 
						break;
					case 2:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:09915898344"));  
						activity.startActivity(I_Dial); 
						break;
					case 3:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:09357249717"));  
						activity.startActivity(I_Dial); 
						break;
					case 4:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:0"));  
						activity.startActivity(I_Dial); 
						break;
					case 5:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:0"));  
						activity.startActivity(I_Dial); 
						break;
					case 6:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:0"));  
						activity.startActivity(I_Dial); 
						break;
					case 7:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:0"));  
						activity.startActivity(I_Dial); 
						break;
					case 8:
						I_Dial=new Intent(Intent.ACTION_DIAL);  
						I_Dial.setData(Uri.parse("tel:0"));  
						activity.startActivity(I_Dial); 
						break;
						
					default:
						
						Toast.makeText(activity, "Default: "+position, Toast.LENGTH_LONG).show();
				
					}
				}
			}); */
       //}
       return vi;
   }
    
  /* public void ShareLink (Context context){
	    this.context = context;
	}*/
   
   @Override
   public void onClick(View v) {
           Log.v("CustomAdapter", "=====Row button clicked=====");
   }
    
   /********* Called when Item click in ListView ************/
   private class OnItemClickListener  implements OnClickListener{           
       private int mPosition;
        
       OnItemClickListener(int position){
            mPosition = position;           
            
       }
        
       @Override
       public void onClick(View arg0) {

  
        //CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;
    	//   CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;
    	 	   
    	 //  Toast.makeText(activity, "Hello " + mPosition, Toast.LENGTH_SHORT).show();
        /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

          //sct.onItemClick(mPosition);
       }               
   }  
   
   
}