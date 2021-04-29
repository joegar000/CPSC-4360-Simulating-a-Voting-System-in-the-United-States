/*
Alejandro Figueroa, 4/2/2021

Comments, edits, questions, suggestions, or concerns are welcomed!

Todo list:

1. Pull the persons information to see if they are within the system.
If so, they vote and if not then they cannot.


*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

//import jdk.internal.net.http.common.Utils.ServerName;

public class Voter {
    /*Variables Example:
    First Name: Joe 
    Last Name: Buden
    Age: 59
    State: Texas
    SSN (In some places it only requires numbers, 
    while in other places it requires numbers and dashes.): 123 - 45 - 6789 or 123456789
    Voted: No
    */
    private String VoterFirstName;
    private String VoterLastName;
    private String VoterAge;
    private String VoterState;
    private String VoterSSN;
    private boolean hasVoted;
    public static String VoterPassword = "Voter";
    private boolean isRegistered = false;

    //Default constructor
    public Voter() {
    }

    //Constructor with the arguements.
    public Voter(String ssn, String firstName, String lastName, 
    String age, String state, boolean hasVoted) {
        this.VoterFirstName = firstName;
        this.VoterLastName = lastName;
        this.VoterAge = age;
        this.VoterState = state;
        this.hasVoted = hasVoted;
    }

    //User either gets or sets the persons first name.
    public void setVoterFirstName(String newVoterFirstName) {
        this.VoterLastName = newVoterFirstName;
    }
    public String getVoterFirstName() {
        return VoterFirstName;
    }

    //User either gets or sets the persons last name.
    public void setVoterLastName(String newVoterLastName) {
        this.VoterLastName = newVoterLastName;
    }
    public String getVoterLastName() {
        return VoterLastName;
    }

    //User either gets or sets the persons Age.
    public void setVoterAge(String newVoterAge) {
        this.VoterAge = newVoterAge;
    }
    public String getVoterAge() {
        return VoterAge;
    }

    //User either gets or sets the persons State.
    public void setVoterState(String newVoterState) {
        this.VoterState = newVoterState;
    }
    public String getVoterState() {
        return VoterState;
    }

    //User either gets or sets the persons SSN.
    public void setVoterSSN(String newVoterSSN) {
        this.VoterSSN = newVoterSSN;
    }
    public String getVoterSSN() {
        return VoterSSN;
    }

    //Checks to see if the person is registered.
    public boolean getisRegistered() {
    
        String[] info = Database.getVoterInformation(VoterSSN);
        isRegistered = true;
        for (int x = 0; x < info.length; x++) {
            if (info[x] != null) continue;
            else isRegistered = false;
        }
        return isRegistered;
    }

    public void displayCandidateList() {
            //Later pull the list from the database.
    }
}