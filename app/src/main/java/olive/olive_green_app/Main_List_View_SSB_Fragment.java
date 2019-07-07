package olive.olive_green_app;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Main_List_View_SSB_Fragment extends Fragment  {
	
	ListView LV_SSB;
	ArrayAdapter<String> AD_SSB;
	ArrayList<String> AD_SSB_List;
	String[] SSB_Array;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		Main_Activity Act_Main=new Main_Activity();
		Act_Main.temp=false;
		
		View My_List_View_SSB = inflater.inflate(R.layout.main_activity_list_view_ssb, container, false);
		LV_SSB = (ListView)My_List_View_SSB.findViewById(R.id.lv_ssb);
		
		SSB_Array = getResources().getStringArray(R.array.ssb_title_list); 
				
	    //AD_SSB=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, SSB_Array );
		
		AD_SSB=new ArrayAdapter<String>(getActivity(), R.layout.sp_tv, SSB_Array );
	    LV_SSB.setAdapter(AD_SSB);
	    
	    LV_SSB.setOnItemClickListener(new OnItemClickListener() {
			
			 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String  SSB_Item = parent.getItemAtPosition(position).toString();
				if(SSB_Item.equalsIgnoreCase("Service Selection Board"))
					
				{

					Fragment SSB_Coaching = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_SSB_Coaching = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_SSB_Coaching.replace(R.id.fl_content_frame, SSB_Coaching);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/service-selection-board");
					SSB_Coaching.setArguments(bundle);
					FT_SSB_Coaching.commit();
				
				}
				else if(SSB_Item.equalsIgnoreCase("SSB Coaching at Olive Greens"))
					
				{

					Fragment SSB_Coaching = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_SSB_Coaching = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_SSB_Coaching.replace(R.id.fl_content_frame, SSB_Coaching);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/ssb-coaching");
					SSB_Coaching.setArguments(bundle);
					FT_SSB_Coaching.commit();

				}
				else if(SSB_Item.equalsIgnoreCase("SSB Coaching Fees"))
				{
					
					Fragment SSB_Coaching = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_SSB_Coaching = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();		 
					FT_SSB_Coaching.replace(R.id.fl_content_frame, SSB_Coaching);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/fee-structure");
					SSB_Coaching.setArguments(bundle);
					FT_SSB_Coaching.commit();						 
				
				}
				else if(SSB_Item.equalsIgnoreCase("SSB Success Stories"))
					
				{
					
					Fragment SSB_Success_Stories = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_Success_Stories = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();		 
					FT_Success_Stories.replace(R.id.fl_content_frame, SSB_Success_Stories);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/ssb-hall-of-fame");
					SSB_Success_Stories.setArguments(bundle);
					FT_Success_Stories.commit();
				
				}
				else if(SSB_Item.equalsIgnoreCase("GTO Training Ground"))
					
				{

					Fragment SSB_Success_Stories = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_Success_Stories = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_Success_Stories.replace(R.id.fl_content_frame, SSB_Success_Stories);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/outdoor-gto-and-physical-training");
					SSB_Success_Stories.setArguments(bundle);
					FT_Success_Stories.commit();
				
				}
				else if(SSB_Item.equalsIgnoreCase("Coast Guard PSB"))
				{

					Fragment SSB_Success_Stories = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_Success_Stories = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_Success_Stories.replace(R.id.fl_content_frame, SSB_Success_Stories);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/preparation-for-coast-guard-selection");
					SSB_Success_Stories.setArguments(bundle);
					FT_Success_Stories.commit();
				
				}
				else if(SSB_Item.equalsIgnoreCase("Pilot Aptitude Battery Test"))
				{

					Fragment SSB_Success_Stories = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_Success_Stories = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_Success_Stories.replace(R.id.fl_content_frame, SSB_Success_Stories);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/ssb-interview/pilot-aptitude-battery-test");
					SSB_Success_Stories.setArguments(bundle);
					FT_Success_Stories.commit();
				
				}
				else if(SSB_Item.equalsIgnoreCase("Joining Instructions"))
				{

					Fragment SSB_Success_Stories = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
					FragmentTransaction FT_Success_Stories = Main_List_View_SSB_Fragment.this.getFragmentManager().beginTransaction();
					FT_Success_Stories.replace(R.id.fl_content_frame, SSB_Success_Stories);
					Bundle bundle = new Bundle();
					bundle.putString("Url", "https://www.olivegreens.co.in/joining-instructions");
					SSB_Success_Stories.setArguments(bundle);
					FT_Success_Stories.commit();
				
				}
	
				else
					
					Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
					
			}
		});
		
		return My_List_View_SSB;
	}

	 
}
