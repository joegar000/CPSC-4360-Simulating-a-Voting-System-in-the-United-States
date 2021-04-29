import java.util.ArrayList;

/*
David Garcia

Poll workers can register voters, display saved voter information,
and display the candidate database

*/



public class PollWorker {
    
    // password is the same for all pollworkers
    private String firstName;
    private String lastName;
    private String SSN;
    public static String password = "PollWorker";

    public PollWorker() {
    }

    public PollWorker(String ssn, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = ssn;
    }

    public String[] getVoterInfo(String SSN) {
        return Database.getVoterInformation(SSN);
    }

    public ArrayList<String[]> displayVoterDatabase() {
        return Database.getAllVoterInformation();
    }

    public void registerVoter(String ssn, String first_name, String last_name, String age, String state, boolean hasVoted) {
        Database.registerVoter(ssn, first_name, last_name, age, state, hasVoted);
    }
}