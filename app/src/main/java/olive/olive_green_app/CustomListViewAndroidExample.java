package olive.olive_green_app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListViewAndroidExample extends Activity {
    
    ListView list;
    CustomAdapter adapter;
    public  CustomListViewAndroidExample CustomListView = null;
    public  ArrayList<List_Model> CustomListViewValuesArr = new ArrayList<List_Model>();
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty_custom_list_view_layout);
         
        CustomListView = this;
         
        /******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
        setListData();
         
        Resources res =getResources();
        list= ( ListView )findViewById( R.id.lv_faculty_details );  // List defined in XML ( See Below )
         
        /**************** Create Custom Adapter *********/
        adapter=new CustomAdapter( CustomListView, CustomListViewValuesArr,res );
        list.setAdapter( adapter );
         
    }
 
    /****** Function to set data in ArrayList *************/
    public void setListData()
    {
         
        for (int i = 0; i < 11; i++) {
             
            final List_Model sched = new List_Model();
                 
              /******* Firstly take data in model object ******/
               sched.setFacultyDescription("Company "+i);
               //sched.setFacultyImage("image"+i);
               sched.setFacultyImage(i);
               sched.setFacultyFBUrl("http:\\www."+i+".com");
                
            /******** Take Model Object in ArrayList **********/
            CustomListViewValuesArr.add( sched );
        }
         
    }
    

   /*****************  This function used by adapter ****************/
    public void onItemClick(int mPosition)
    {
        List_Model tempValues = ( List_Model ) CustomListViewValuesArr.get(mPosition);


       // SHOW ALERT                  

        Toast.makeText(CustomListView,
                ""+tempValues.getFacultyDescription()
                  +"Image:"+tempValues.getFacultyImage()
                  +"Url:"+tempValues.getFacultyFBUrl(),
                Toast.LENGTH_LONG)
        .show();
    }
}