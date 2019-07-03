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
public class Main_List_View_Written_Exams_Fragment extends Fragment {

    ListView LV_Written_Exams;
    ArrayAdapter<String> AD_Written_Exams;
    ArrayList<String> AL_Written_Exams;
    String[] Written_Exams_Array;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Main_Activity Act_Main = new Main_Activity();
        Act_Main.temp = false;

        View My_List_View_Written_Exams = inflater.inflate(R.layout.main_activity_list_view_writing, container, false);

        LV_Written_Exams = (ListView) My_List_View_Written_Exams.findViewById(R.id.lv_written_exams);

        Written_Exams_Array = getResources().getStringArray(R.array.written_exams_title_list);

        //AD_Written_Exams=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Written_Exams_Array );

        AD_Written_Exams = new ArrayAdapter<String>(getActivity(), R.layout.sp_tv, Written_Exams_Array);

        LV_Written_Exams.setAdapter(AD_Written_Exams);


        LV_Written_Exams.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment NDA_Coaching = new List_View_SSB_Item_SSB_Coaching_Fee_Fragment();
                FragmentTransaction FT_NDA = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
                FT_NDA.replace(R.id.fl_content_frame, NDA_Coaching);
                FT_NDA.commit();
            }
        });

//		LV_Written_Exams.setOnItemClickListener(new OnItemClickListener() {
//
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// TODO Auto-generated method stub
//				String  SSB_Item = parent.getItemAtPosition(position).toString();
//				if(SSB_Item.equalsIgnoreCase("NDA Written Exam Coaching"))
//
//				{
//
//					Fragment NDA_Coaching = new List_View_Written_Exam_Item_1_Fragment();
//					FragmentTransaction FT_NDA = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_NDA.replace(R.id.fl_content_frame, NDA_Coaching);
//					FT_NDA.commit();
//
//				}
//
//				else if(SSB_Item.equalsIgnoreCase("CDS/OTA Written Coaching"))
//
//				{
//
//					Fragment CDS_Coaching = new List_View_Written_Exam_Item_2_Fragment();
//					FragmentTransaction FT_CDS = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_CDS.replace(R.id.fl_content_frame, CDS_Coaching);
//					FT_CDS.commit();
//
//				}
//				else if(SSB_Item.equalsIgnoreCase("AFCAT Written Exam Coaching"))
//
//				{
//
//					Fragment AFCAT_Coaching = new List_View_Written_Exam_Item_3_Fragment();
//					FragmentTransaction FT_AFCAT = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_AFCAT.replace(R.id.fl_content_frame, AFCAT_Coaching);
//					FT_AFCAT.commit();
//
//				}
//				else if(SSB_Item.equalsIgnoreCase("ACC Written Exam Coaching"))
//
//				{
//
//					Fragment ACC_Coaching = new List_View_Written_Exam_Item_4_Fragment();
//					FragmentTransaction FT_ACC = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_ACC.replace(R.id.fl_content_frame, ACC_Coaching);
//					FT_ACC.commit();
//
//				}
//				else if(SSB_Item.equalsIgnoreCase("Written Exam Coaching Fee"))
//
//				{
//
//					Fragment Coaching_Fee = new List_View_Written_Exam_Item_5_Fragment();
//					FragmentTransaction FT_Fee = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_Fee.replace(R.id.fl_content_frame, Coaching_Fee);
//					FT_Fee.commit();
//
//				}
//				else if(SSB_Item.equalsIgnoreCase("CPF Exam Coaching"))
//
//				{
//
//					Fragment CPF_Coaching = new List_View_Written_Exam_Item_6_Fragment();
//					FragmentTransaction FT_CPF = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_CPF.replace(R.id.fl_content_frame, CPF_Coaching);
//					FT_CPF.commit();
//
//				}
//				else if(SSB_Item.equalsIgnoreCase("Women Special Entry Scheme (WSES)"))
//
//				{
//
//					Fragment WSES_Coaching = new List_View_Written_Exam_Item_7_Fragment();
//					FragmentTransaction FT_WSES = Main_List_View_Written_Exams_Fragment.this.getFragmentManager().beginTransaction();
//					FT_WSES.replace(R.id.fl_content_frame, WSES_Coaching);
//					FT_WSES.commit();
//
//				}
//				else
//					Toast.makeText(getActivity(), "Please select a valid exam.", Toast.LENGTH_SHORT).show();
//			}
//		});


        return My_List_View_Written_Exams;
    }

}
