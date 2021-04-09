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
    private int VoterAge;
    private String VoterState;
    private String VoterSSN;
    private boolean ifVoted;
    private boolean isRegistered;
    public static String VoterPassword = "2468";
    private boolean VoterlogIn = false;

    //Default constructor
    public Voter() {
    }

    //Constructor with the arguements.
    public Voter(String VoterFirstName, String VoterLastName, int VoterAge, 
    String VoterState, String VoterSSN, boolean ifVoted, boolean isRegistered) {
        this.VoterFirstName = VoterFirstName;
        this.VoterLastName = VoterLastName;
        this.VoterAge = VoterAge;
        this.VoterState = VoterState;
        this.ifVoted = ifVoted;
        this.isRegistered = isRegistered;
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
    public void setVoterAge(int newVoterAge) {
        this.VoterAge = newVoterAge;
    }
    public int getVoterAge() {
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


    //Checks to see if the person voted.
    public boolean getIfVoted() {
        return ifVoted;
    }

    //Checks to see if the person is registered.
    public boolean getisRegistered() {
        return isRegistered;
    }

    //
    public void logIn(String FirstName, String LastName, String Password) {
        if(this.VoterPassword.equals(Password)) {
            this.VoterlogIn = true;
        } else {
            System.out.println("The given input is incorrect, please try again.");
        }
    }

    public void logOut() {
        this.VoterlogIn = false;
    }


    /*
    Note #1: 
    This is a vague idea of how to possibly check if someone is registered. 
    I was unsure as how to do it, such as will the voters information will be saved in the database?

    Makeshift Formula: 
    "Registering" = VoterName + VoterAge =< 18 + VoterState + VoterSSN
    IsRegistered = "Registering"
    IfVoted = IsRegistered 
    HasVoted = IfVoted + IsRegistered

    public boolean CheckIsRegistered() {
        if("Some how get the saved voter information.") {
            ...
        } else {
            ...
        }
    }
    public boolean CheckIfVoted() {
        if(isRegistered) {
            ...
        } else {
            ...
        }
    }
    public boolean CheckHasVoted() {
        if(IfVoted && isRegistered) {
            ...
        } else {
            ...
        }
    }
    */
}