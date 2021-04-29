/*
Kaden Carter
This class is the constructor for the Administrator

*/

public class Administrator {

    /*
    Variables
    AdminName is the legal name of the admin.
    AdminID is the unique ID number to show the difference between various Admin accounts.
    */
    private String adminFirstName;
    private String adminLastName;
    private String AdminID;
    public static String adminPassword = "Admin";

    //default constructor
    public Administrator(){

    }

    //constructor with arguments
    public Administrator(String adminFirstName, String adminLastName, String AdminID){
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.AdminID = AdminID;
    }

    //get and set for adminFirstName Variable.
    public String getAdminFirstName(){
        return adminFirstName;
    }

    public void setAdminFirstName(String newAdminFirstName){
        adminFirstName = newAdminFirstName;
    }

    //get and set for adminLastName Variable.
    public String getAdminLastName(){
        return adminLastName;
    }

    public void setAdminLastName(String newAdminLastName){
        adminLastName = newAdminLastName;
    }

    //get and set for AdminID Variable.
    public String getAdminID(){
        return AdminID;
    }

    public void setAdminID(String newAdminID){
        AdminID = newAdminID;
    }

    public void registerVoter(String VoterSSN, String VoterFirstName, String VoterLastName, String VoterAge, String VoterState, boolean hasVoted) {
        Database.registerVoter(VoterSSN, VoterFirstName, VoterLastName, VoterAge, VoterState, hasVoted);
    }
    
}