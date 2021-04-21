/*
Kaden Carter

Please express any comments or concerns

TODO
    Add methods for vote validation, 
    display voter database, 
    and display candidate database

*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Administrator {

    /*
    Variables
    AdminName is the legal name of the admin.
    AdminID is the unique ID number to show the difference between various Admin accounts.
    */
    private String adminFirstName;
    private String adminLastName;
    private String AdminID;
    public static String adminPassword = "ABCD";
    private boolean adminLoggedIn = false;

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

    //log in and log out methods
    public void logIn(String adminFirstName, String adminLastName, String adminPassword) {
        if (this.adminPassword.equals(adminPassword)) {
            this.adminLoggedIn = true;
        }
        else {
            System.out.println("The input name and/or password is incorrect.");
        }
    }

    public void logOut() {
        this.adminLoggedIn = false;
    }

    public void registerVoter(String VoterSSN, String VoterFirstName, String VoterLastName, String VoterAge, String VoterState, boolean hasVoted) {
        Database.registerVoter(VoterSSN, VoterFirstName, VoterLastName, VoterAge, VoterState, hasVoted);
    }

    /*
    These will be the methods for validating votes, displaying voter database, and displaying candidate database.
    public ... ValidateVotes(){
        ...
    }

    public ... DisplayVoterDB(){
        ...
    }

    public ... DisplayCandidateDB(){
        ...
    }
    */
    
    //prints success
    public void printSuccess() {
        System.out.println("it worked");
    }
    
}