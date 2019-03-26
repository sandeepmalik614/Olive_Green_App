package olive.olive_green_app;

public class List_Model {
    
           private  String Faculy_Description="";
           private  String Faculy_Name="";
           //private  String Faculy_Image="";
           private  int Faculy_Image;
           private  String Faculy_FB_Url="";
           private  String Faculy_Contact_Details="";
            
           /*********** Set Methods ******************/
           
           public void setFacultyName(String Faculy_Name)
           {
               this.Faculy_Name = Faculy_Name;
           }
            
           public void setFacultyDescription(String Faculy_Description)
           {
               this.Faculy_Description = Faculy_Description;
           }
            
           //public void setFacultyImage(String Faculy_Image)
           public void setFacultyImage(int Faculy_Image)
           {
               this.Faculy_Image = Faculy_Image;
           }
            
           public void setFacultyFBUrl(String Faculy_FB_Url)
           {
               this.Faculy_FB_Url = Faculy_FB_Url;
           }
            
           public void setFacultyContacts(String Faculy_Contact_Details)
           {
               this.Faculy_Contact_Details = Faculy_Contact_Details;
           }
       
           /*********** Get Methods ****************/
           public String getFacultyName()
           {
               return this.Faculy_Name;
           }
            
           public String getFacultyDescription()
           {
               return this.Faculy_Description;
           }
            
          // public String getFacultyImage()
           public int getFacultyImage()
           {
               return this.Faculy_Image;
           }
        
           public String getFacultyFBUrl()
           {
               return this.Faculy_FB_Url;
           }    
           
           public String getFacultyContacts()
           {
               return this.Faculy_Contact_Details;
           }    
     }