/*
David Garcia

Poll workers can register voters, display saved voter information,
and display the candidate database

*/



public class PollWorker {
    
    // username and password is the same for all pollworkers
    private String firstName;
    private String lastName;
    public static String password = "1234";
    private boolean loggedIn = false;

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

    public void registerVoter(String ssn, String first_name, String last_name, String age, String state, boolean hasVoted) {
        Database.registerVoter(ssn, first_name, last_name, age, state, hasVoted);
    }
}