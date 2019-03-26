package olive.olive_green_app;


import idi_olive_green_fetch_images.DetailsActivity;
import idi_olive_green_fetch_images.Product;
import idi_olive_green_fetch_images.ProductListAdapterWithCache;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

@SuppressLint("NewApi")
public class Main_Fetch_Gallery_Fragment extends Fragment {
	
	 	List products;
	    GridView gvProducts = null;
	    ProductListAdapterWithCache adapterProducts;  
	    private boolean lvBusy = false;	
		ConnectionDetector CD;
		Boolean isInternetPresent;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		Main_Activity Act_Main=new Main_Activity();
		Act_Main.temp=false;

		View My_Fetch_Gallery_View = inflater.inflate(R.layout.main_grid, container, false);
		
		CD = new ConnectionDetector(getActivity());
		
		// get Internet status
		isInternetPresent = CD.isConnectingToInternet();
		
		//GV_Gallery = (GridView) My_Gallery_View.findViewById(R.id.gridView);
		
	    if(isInternetPresent)
       	{
		// populate data
	        products = new ArrayList();
	        products.add(new Product("Image 1","http://www.olivegreens.co.in/cache/widgetkit/gallery/19/collage%201-9bb9b4efa7.jpg"));
	        products.add(new Product("Image 2","http://www.olivegreens.co.in/images/outdoors/2.jpg"));
	        products.add(new Product("Image 3","http://www.olivegreens.co.in/images/outdoors/3.jpg"));
	        products.add(new Product("Image 4","http://www.olivegreens.co.in/images/outdoors/4.jpg"));
	        products.add(new Product("Image 5","http://www.olivegreens.co.in/images/outdoors/66.jpg"));
	        products.add(new Product("Image 6","http://www.olivegreens.co.in/images/psyc/ssb-slider6.jpg"));
	        products.add(new Product("Image 7","http://www.olivegreens.co.in/images/psyc/ssb-slider7.jpg"));     
	        products.add(new Product("Image 8","http://www.olivegreens.co.in/images/psyc/ssb-slider10.jpg"));
	        products.add(new Product("Image 9","http://www.olivegreens.co.in/images/psyc/ssb-slider11.jpg"));
	        products.add(new Product("Image 10","http://www.olivegreens.co.in/images/psyc/ssb-slider9.jpg"));
	        products.add(new Product("Image 11","http://www.olivegreens.co.in/images/outdoors/10.jpg"));
	        products.add(new Product("Image 12","http://www.olivegreens.co.in/cache/widgetkit/gallery/19/gto_ground_at_olive_greens-0c04df71de.jpg"));
      
        //
        gvProducts = (GridView) My_Fetch_Gallery_View.findViewById( R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(getActivity(), products);
        gvProducts.setAdapter(adapterProducts);
        
        gvProducts.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Product item = (Product) parent.getItemAtPosition(position);
				//Create intent
				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				intent.putExtra("title", item.getTitle());
				intent.putExtra("image_url", item.getImageUrl());		
				//Start details activity
				startActivity(intent);
			}
		});
       	}		
		
		
		/*GD_Adaptor = new GridViewAdapter(getActivity(), R.layout.gallery_item_layout, getData());
		GV_Gallery.setAdapter(GD_Adaptor);
		
		GV_Gallery.setOnItemClickListener(GV_OnClickListener);*/
	    else
	       {
	    	   showAlertDialog(getActivity(), "No Internet Connection Detected",
						"Sorry, You don't have Internet Connection. Please Turn On the Internet to continue.", false);
	       }
	    
		return My_Fetch_Gallery_View;
	}
	
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message, Boolean status) {
		// TODO Auto-generated method stub
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


	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                lvBusy = false;
                adapterProducts.notifyDataSetChanged();
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                lvBusy = true;
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                lvBusy = true;
                break;
        }
    }


    public boolean isLvBusy(){
        return lvBusy;
    }

	/*public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Product item = (Product) parent.getItemAtPosition(position);
		//Create intent
		Intent intent = new Intent(getActivity(), DetailsActivity.class);
		intent.putExtra("title", item.getTitle());
		intent.putExtra("image_url", item.getImageUrl());		
		//Start details activity
		startActivity(intent);
		
	}*/
	
	
}
