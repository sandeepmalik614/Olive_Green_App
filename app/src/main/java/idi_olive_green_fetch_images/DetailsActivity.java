package idi_olive_green_fetch_images;

import olive.olive_green_app.R;
import olive.olive_green_app.R;

import java.io.InputStream;

import android.app.Activity;
import android.app.ProgressDialog;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_details_activity);

        String title = getIntent().getStringExtra("title");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        
        //Toast.makeText(getApplicationContext(), " DetailsActivity URL "+url, Toast.LENGTH_SHORT).show();
        
        ImageView imageView = (ImageView) findViewById(R.id.image);

		if(title.equals("Image 1")){
			imageView.setBackgroundResource(R.drawable.gallery_1);
		}else if(title.equals("Image 2")) {
			imageView.setBackgroundResource(R.drawable.gallery_2);
		}else if(title.equals("Image 3")){
			imageView.setBackgroundResource(R.drawable.gallery_3);
		}else if(title.equals("Image 4")){
			imageView.setBackgroundResource(R.drawable.gallery_4);
		}else if(title.equals("Image 5")){
			imageView.setBackgroundResource(R.drawable.gallery_5);
		}else if(title.equals("Image 6")){
			imageView.setBackgroundResource(R.drawable.gallery_6);
		}else if(title.equals("Image 7")){
			imageView.setBackgroundResource(R.drawable.gallery_7);
		}else if(title.equals("Image 8")){
			imageView.setBackgroundResource(R.drawable.gallery_8);
		}else if(title.equals("Image 9")){
			imageView.setBackgroundResource(R.drawable.gallery_9);
		}else if(title.equals("Image 10")){
			imageView.setBackgroundResource(R.drawable.gallery_10);
		}else if(title.equals("Image 11")){
			imageView.setBackgroundResource(R.drawable.gallery_11);
		}else if(title.equals("Image 12")){
			imageView.setBackgroundResource(R.drawable.gallery_12);
		}else if(title.equals("Image 13")){
			imageView.setBackgroundResource(R.drawable.gallery_13);
		}else if(title.equals("Image 14")){
			imageView.setBackgroundResource(R.drawable.gallery_14);
		}else if(title.equals("Image 15")){
			imageView.setBackgroundResource(R.drawable.gallery_15);
		}else if(title.equals("Image 16")){
			imageView.setBackgroundResource(R.drawable.gallery_16);
		}else if(title.equals("Image 17")){
			imageView.setBackgroundResource(R.drawable.gallery_17);
		}else if(title.equals("Image 18")){
			imageView.setBackgroundResource(R.drawable.gallery_18);
		}

        //imageView.setImageBitmap(bitmap);
        //ImageDownloader imageDownloader = new ImageDownloader();
        //imageDownloader.download(url, imageView);
        
//        DownloadImageTask image_asyn=new DownloadImageTask(this, imageView,url);
//        image_asyn.execute();

    }
 
}


class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

	  ImageView bmImage;
	  ProgressDialog pd;
	  Context mContext;
	  String url;

	  public DownloadImageTask(Context context,ImageView bmImage,String url_1) {
	      this.bmImage = bmImage;
	      mContext = context;
	      this.url=url_1;
	      
	  }

	  @SuppressWarnings("static-access")
	public void onPreExecute() {
		  
		 // pd=new ProgressDialog(mContext);
	     // pd.show(this.mContext, "dialog title","dialog message", true);
	      pd = ProgressDialog.show(mContext, "","Loading Image.....", true);
	  } 

	  public void onPostExecute(Bitmap result) {
	      pd.dismiss();
	      if(result!=null)
	      {
	          bmImage.setImageBitmap(result);
	      }
	  }

	  protected Bitmap doInBackground(String... urls) {
	      
	      Bitmap mIcon11 = null;
	      try {
	        InputStream in = new java.net.URL(this.url).openStream();
	        mIcon11 = BitmapFactory.decodeStream(in);
	      } catch (Exception e) {
	          Log.e("Error", e.getMessage());
	          e.printStackTrace();
	      }
	      return mIcon11;
	  }
	}
