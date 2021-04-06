/*
Kaden Carter

Please express any comments or concerns

TODO
    Add methods for vote validation, 
    display voter database, 
    and display candidate database

*/

public class Administrator {

    /*
    Variables
    AdminName is the legal name of the admin.
    AdminID is the unique ID number to show the difference between various Admin accounts.
    */
    private String AdminName;
    private String AdminID;

    //default constructor
    public Administrator(){

    }

    //constructor with arguments
    public Administrator(String AdminName, String AdminID){
        this.AdminName = AdminName;
        this.AdminID = AdminID;
    }

    //get and set for AdminName Variable.
    public String getAdminName(){
        return AdminName;
    }

    public void setAdminName(String newAdminName){
        AdminName = newAdminName;
    }

    //get and set for AdminID Variable.
    public String getAdminID(){
        return AdminID;
    }

    public void setAdminID(String newAdminID){
        AdminID = newAdminID;
    }


    
}