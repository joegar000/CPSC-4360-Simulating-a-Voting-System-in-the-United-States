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
    Name: Joe Buden
    Age: 59
    State: Texas
    SSN (In some places it only requires numbers, 
    while in other places it requires numbers and dashes.): 123 - 45 - 6789 or 123456789
    Voted: No
    */
    private String VoterName;
    private int VoterAge;
    private String VoterState;
    private String VoterSSN;
    private boolean ifVoted; 
    private boolean hasVoted;
    private boolean isRegistered;

    //Default constructor
    public Voter() {
    }

    //Constructor with the arguements.
    public Voter(String VoterName, int VoterAge, 
    String VoterState, String VoterSSN, boolean ifVoted, 
    boolean hasVoted, boolean isRegistered) {
        this.VoterName = VoterName;
        this.VoterAge = VoterAge;
        this.VoterState = VoterState;
        this.ifVoted = ifVoted;
        this.hasVoted = hasVoted;
        this.isRegistered = isRegistered;
    }

    //User either gets or sets the persons name.
    public void setVoterName(String newVoterName) {
        this.VoterName = newVoterName;
    }
    public String getVoterName() {
        return VoterName;
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