/*
David Garcia
*/

// For JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class PollWorker {
    
    // username and password is the same for all pollworkers
    private String firstName;
    private String lastName;
    public static String password = "1234";
    private boolean loggedIn = false;

    public PollWorker(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* If the username and password are incorrect, then try to log them in as a voter */
    public void logIn(String firstName, String lastName, String password) {
        if (this.password.equals(password)) {
            this.loggedIn = true;
        }
        else {
            System.out.println("The input name and/or password is incorrect.");
        }
    }

    public void logOut() {
        this.loggedIn = false;
    }

    public void displayVoterInfo() {
        if (loggedIn == true) {
            /* Pull data from database to display it */
        }
    }

    public void registerVoter(String VoterFirstName, String VoterLastName, int VoterAge, String VoterState, String VoterSSN, boolean ifVoted, boolean isRegistered) {
        Voter voter = new Voter(VoterFirstName, VoterLastName, VoterAge, VoterState, VoterSSN, ifVoted, isRegistered);
        /* Add the voter object to the database */
    }

    public void printSuccess() {
        System.out.println("it worked");
    }







}
