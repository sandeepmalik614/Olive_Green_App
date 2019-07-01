package idi_olive_green_fetch_images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import olive.olive_green_app.Main_Activity;
import olive.olive_green_app.R;

import java.util.List;

/*

read more: http://developer.android.com/training/improving-layouts/smooth-scrolling.html
 */
public class ProductListAdapterWithCache extends ArrayAdapter<Product> {
    private static Context mContext;
    List<Product> mylist;

    public ProductListAdapterWithCache(Context _context, List<Product> _mylist) {
        super(_context, R.layout.list_item, _mylist);

        mContext = _context;
        this.mylist = _mylist;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);

        ProductViewHolder holder;

        if (convertView == null) {
            convertView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            //convertView = vi.inflate(R.layout.list_item, parent, false);
            convertView = vi.inflate(R.layout.grid_item, parent, false);

            //
            holder = new ProductViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.image);
            holder.title = (TextView)convertView.findViewById(R.id.title);

            //
            convertView.setTag(holder);
        }
        else{
            holder = (ProductViewHolder) convertView.getTag();
        }


        //
        //holder.populate(product, ((MyActivity)mContext).isLvBusy());
        holder.populate(product, ((Main_Activity)mContext).isLvBusy());

        //
        return convertView;
    }


    static class ProductViewHolder {
        public ImageView img;
        public TextView title;

        void populate(Product p) {
            title.setText(p.title);

            //
//            ImageDownloader imageDownloader = new ImageDownloader();
//            imageDownloader.download(p.img_url, img);


        }

        void populate(Product p, boolean isBusy) {
            title.setText(p.title);

            if (!isBusy){
                // download from internet
//                ImageDownloader imageDownloader = new ImageDownloader();
//                imageDownloader.download(p.img_url, img);
                if(p.title.equals("Image 1")){
                   img.setBackgroundResource(R.drawable.gallery_1);
                }else if(p.title.equals("Image 2")) {
                    img.setBackgroundResource(R.drawable.gallery_2);
                }else if(p.title.equals("Image 3")){
                    img.setBackgroundResource(R.drawable.gallery_3);
                }else if(p.title.equals("Image 4")){
                    img.setBackgroundResource(R.drawable.gallery_4);
                }else if(p.title.equals("Image 5")){
                    img.setBackgroundResource(R.drawable.gallery_5);
                }else if(p.title.equals("Image 6")){
                    img.setBackgroundResource(R.drawable.gallery_6);
                }else if(p.title.equals("Image 7")){
                    img.setBackgroundResource(R.drawable.gallery_7);
                }else if(p.title.equals("Image 8")){
                    img.setBackgroundResource(R.drawable.gallery_8);
                }else if(p.title.equals("Image 9")){
                    img.setBackgroundResource(R.drawable.gallery_9);
                }else if(p.title.equals("Image 10")){
                    img.setBackgroundResource(R.drawable.gallery_10);
                }else if(p.title.equals("Image 11")){
                    img.setBackgroundResource(R.drawable.gallery_11);
                }else if(p.title.equals("Image 12")){
                    img.setBackgroundResource(R.drawable.gallery_12);
                }else if(p.title.equals("Image 13")){
                    img.setBackgroundResource(R.drawable.gallery_13);
                }else if(p.title.equals("Image 14")){
                    img.setBackgroundResource(R.drawable.gallery_14);
                }else if(p.title.equals("Image 15")){
                    img.setBackgroundResource(R.drawable.gallery_15);
                }else if(p.title.equals("Image 16")){
                    img.setBackgroundResource(R.drawable.gallery_16);
                }else if(p.title.equals("Image 17")){
                    img.setBackgroundResource(R.drawable.gallery_17);
                }else if(p.title.equals("Image 18")){
                    img.setBackgroundResource(R.drawable.gallery_18);
                }
            }
            else{
                // set default image
              //  img.setImageResource(R.drawable.spinner);
            }
        }
    }

}
