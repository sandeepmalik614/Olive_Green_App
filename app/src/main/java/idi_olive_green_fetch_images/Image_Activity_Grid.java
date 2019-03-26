package idi_olive_green_fetch_images;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.GridView;
import olive.olive_green_app.R;

import java.util.ArrayList;
import java.util.List;
 

public class Image_Activity_Grid extends Activity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener {
    List products;
    GridView gvProducts = null;
    ProductListAdapterWithCache adapterProducts;


    private boolean lvBusy = false;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_grid);

        // populate data
        products = new ArrayList();
        products.add(new Product("Outdoor GTO Training Image 1","http://www.olivegreens.co.in/images/outdoors/10.jpg"));
        products.add(new Product("Outdoor GTO Training Image 2","http://www.olivegreens.co.in/images/outdoors/2.jpg"));
        products.add(new Product("Outdoor GTO Training Image 3","http://www.olivegreens.co.in/images/outdoors/3.jpg"));
        products.add(new Product("Outdoor GTO Training Image 4","http://www.olivegreens.co.in/images/outdoors/4.jpg"));
        products.add(new Product("Outdoor GTO Training Image 5","http://www.olivegreens.co.in/images/outdoors/66.jpg"));
        products.add(new Product("Outdoor GTO Training Image 6","http://www.olivegreens.co.in/images/psyc/ssb-slider6.jpg"));
        products.add(new Product("Outdoor GTO Training Image 7","http://www.olivegreens.co.in/images/psyc/ssb-slider7.jpg"));
        products.add(new Product("Outdoor GTO Training Image 8","http://www.olivegreens.co.in/images/psyc/ssb-slider2.jpg"));
        products.add(new Product("Outdoor GTO Training Image 9","http://www.olivegreens.co.in/images/psyc/ssb-slider3.jpg"));
        products.add(new Product("Outdoor GTO Training Image 10","http://www.olivegreens.co.in/images/psyc/ssb-slider4.jpg"));
        products.add(new Product("Outdoor GTO Training Image 11","http://www.olivegreens.co.in/images/psyc/ssb-slider1.jpg"));
        products.add(new Product("Outdoor GTO Training Image 12","http://www.olivegreens.co.in/images/psyc/ssb-slider10.jpg"));
        products.add(new Product("Outdoor GTO Training Image 13","http://www.olivegreens.co.in/images/psyc/ssb-slider11.jpg"));
        products.add(new Product("Outdoor GTO Training Image 14","http://www.olivegreens.co.in/images/psyc/ssb-slider9.jpg"));
        products.add(new Product("Outdoor GTO Training Image 15","http://www.olivegreens.co.in/images/psyc/ssb-slider9.jpg"));
        
        gvProducts = (GridView) findViewById( R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);
        
        gvProducts.setOnItemClickListener(this);

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

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "This", Toast.LENGTH_SHORT).show();
		Product item = (Product) parent.getItemAtPosition(position);
		//Create intent
		Intent intent = new Intent(this, DetailsActivity.class);
		intent.putExtra("title", item.getTitle());
		intent.putExtra("image_url", item.getImageUrl());		
		//Start details activity
		startActivity(intent);
		
	}

}
