package olive.olive_green_app;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
public class List_View_SSB_Item_SSB_Coast_Guard_Fragment extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		View SSB_LV_Item_View_SSB_Coast_Guard = inflater.inflate(R.layout.ssb_lv_item_ssb_coast_guard, container, false);		
		return SSB_LV_Item_View_SSB_Coast_Guard;
		
	}		 

}
