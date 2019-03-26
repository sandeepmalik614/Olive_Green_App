package olive.olive_green_app;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

@SuppressLint("NewApi")
public class Main_Faculty_List_View_Fragment extends Fragment { 
	
	ListView LV_Faculty_Details;
    CustomAdapter adapter;
    public  CustomListViewAndroidExample CustomListView = null;
    public  ArrayList<List_Model> CustomListViewValuesArr = new ArrayList<List_Model>();
    String[] Faculty_Names;
    String[] Faculty_Desc;
    //int[] Faculty_Images;
    String[] Faculty_Email_Links;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		
		Main_Activity Act_Main=new Main_Activity();
		Act_Main.temp=false;

		View My_Faculty_List_View = inflater.inflate(R.layout.faculty_custom_list_view_layout, container, false);
	    LV_Faculty_Details = (ListView)My_Faculty_List_View.findViewById(R.id.lv_faculty_details);
	    
	 //   CustomListView = (CustomListViewAndroidExample) this.getActivity();
         
         /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
         setListData();
          
         Resources res =getResources();
         LV_Faculty_Details = ( ListView )My_Faculty_List_View.findViewById( R.id.lv_faculty_details );  // List defined in XML ( See Below )
          

         /**************** Create Custom Adapter *********/
         adapter=new CustomAdapter( getActivity(), CustomListViewValuesArr,res );
         LV_Faculty_Details.setAdapter( adapter );

		
         LV_Faculty_Details.setOnItemClickListener(new OnItemClickListener() { 

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				//Toast.makeText(getActivity(), "Hello "+position, Toast.LENGTH_SHORT).show();
			
			}
 		});
		return My_Faculty_List_View;
	}
	
	 /****** Function to set data in ArrayList *************/
    public void setListData()
    {
         
    	Faculty_Names = getResources().getStringArray(R.array.faculty_names);
    	Faculty_Desc = getResources().getStringArray(R.array.faculty_small_desc);
    	//Faculty_Images = getResources().getIntArray(R.array.faculty_images);
    	Faculty_Email_Links = getResources().getStringArray(R.array.faculty_email_links);
    	
    	
        for (int i = 0; i <=8; i++) {
             
            final List_Model sched = new List_Model();
                  
              /******* Firstly take data in model object ******/
               sched.setFacultyName(Faculty_Names[i]);
               sched.setFacultyDescription(Faculty_Desc[i]);
              // sched.setFacultyImage(Faculty_Images[i]);
               sched.setFacultyFBUrl(Faculty_Email_Links[i]);
                
            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( sched );
        }
        
    }
    
  	/*	@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			 /*List_Model tempValues = ( List_Model ) CustomListViewValuesArr.get(position);
		
			 
				Intent intent = new Intent(getActivity(), CustomListViewAndroidExample.class);
				 
				startActivity(intent);
  			
  			
		}*/
    };
    
