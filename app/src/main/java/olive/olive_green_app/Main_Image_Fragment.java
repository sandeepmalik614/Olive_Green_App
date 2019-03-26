package olive.olive_green_app;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Main_Image_Fragment extends Fragment {

	ImageView IV_SSB_Material, IV_Written_Material, IV_Gallery, IV_Faculty, IV_Blog_RSS, IV_Quick_Query;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	

		View My_Frag_View = inflater.inflate(R.layout.main_activity_image_button_layout, container, false);

		IV_SSB_Material = (ImageView) My_Frag_View.findViewById(R.id.iv_ssb);
		IV_Written_Material = (ImageView) My_Frag_View.findViewById(R.id.iv_written_material);
		IV_Gallery = (ImageView) My_Frag_View.findViewById(R.id.iv_gallery);
		IV_Faculty = (ImageView) My_Frag_View.findViewById(R.id.iv_faculty);
		IV_Blog_RSS = (ImageView) My_Frag_View.findViewById(R.id.iv_blog_rss);
		IV_Quick_Query = (ImageView) My_Frag_View.findViewById(R.id.iv_query);
		
		IV_SSB_Material.setOnClickListener(IV_OnClickListener);
		IV_Written_Material.setOnClickListener(IV_OnClickListener);
		IV_Gallery.setOnClickListener(IV_OnClickListener);
		IV_Faculty.setOnClickListener(IV_OnClickListener);
		IV_Blog_RSS.setOnClickListener(IV_OnClickListener);
		IV_Quick_Query.setOnClickListener(IV_OnClickListener);
		
		return My_Frag_View;
	}
	
	OnClickListener IV_OnClickListener = new OnClickListener(){

		@Override
		public void onClick(View V) {
		
			switch(V.getId())
			{
			case R.id.iv_ssb:
				
				Fragment M_SSB_Frag = new Main_List_View_SSB_Fragment();
				FragmentTransaction FT_SSB = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_SSB.replace(R.id.fl_content_frame, M_SSB_Frag);		
				FT_SSB.commit();							 
				break;
			
			case R.id.iv_written_material:
				
				Fragment M_Writing_Frag = new Main_List_View_Written_Exams_Fragment();
				FragmentTransaction FT_Writing = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_Writing.replace(R.id.fl_content_frame, M_Writing_Frag);		
				FT_Writing.commit();							 
				break;
				
			case R.id.iv_gallery:
				
				Fragment M_Fetch_Gallery_Frag = new Main_Fetch_Gallery_Fragment();
				FragmentTransaction FT_Fetch_Gallery = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_Fetch_Gallery.replace(R.id.fl_content_frame, M_Fetch_Gallery_Frag);		
				FT_Fetch_Gallery.commit();							 
				break;
				
			case R.id.iv_faculty:
				
				Fragment M_Faculty_Frag = new Main_Faculty_List_View_Fragment();
				FragmentTransaction FT_Faculty = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_Faculty.replace(R.id.fl_content_frame, M_Faculty_Frag);		
				FT_Faculty.commit();							 
				break;
				
			case R.id.iv_blog_rss:
				
			 	Fragment M_Blog_RSS_Frag = new Main_List_View_Blog_RSS_Fragment();
				FragmentTransaction FT_Blog_RSS = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_Blog_RSS.replace(R.id.fl_content_frame, M_Blog_RSS_Frag);		
				FT_Blog_RSS.commit();							 
				break;
				
			case R.id.iv_query:
				
			 	Fragment M_Quick_Query_Frag = new Main_Quick_Contact_Fragment();
				FragmentTransaction FT_Quick_Query = Main_Image_Fragment.this.getFragmentManager().beginTransaction();		 
				FT_Quick_Query.replace(R.id.fl_content_frame, M_Quick_Query_Frag);		
				FT_Quick_Query.commit();							 
				break;
				
			default:
				
				Toast.makeText(getActivity(), "Hello World", Toast.LENGTH_SHORT).show();
			} 
			
		}};
	
	
}
