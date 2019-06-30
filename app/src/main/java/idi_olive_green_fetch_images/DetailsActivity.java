package idi_olive_green_fetch_images;

import olive.olive_green_app.R;

import java.io.InputStream;

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
        String url = getIntent().getStringExtra("image_url");
        //Bitmap bitmap = getIntent().getParcelableExtra("image_url");

        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(title);

        
        //Toast.makeText(getApplicationContext(), " DetailsActivity URL "+url, Toast.LENGTH_SHORT).show();
        
        ImageView imageView = (ImageView) findViewById(R.id.image);
		Glide.with(this).load(url).into(imageView);

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
