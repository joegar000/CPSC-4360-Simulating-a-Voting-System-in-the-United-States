/*
Comments, edits, questions, suggestions, or concerns are welcomed!

To do list:
1. Unsure if to only check if the voter did vote or not. 
Or check along side other factors such as voted, if they voted already, and if they are registered.
Or separately check all three.

*/

public class Voter {
    /*Example:
    Name: Joe Buden
    DOB: 03/16/1969
    State: Texas
    SSN (In some places it only requires numbers, 
    while in other places it requires numbers and dashes.): 123 - 45 - 6789 or 123456789
    Voted: No
    */
    private String VoterName;
    private String VoterDOB;
    private String VoterState;
    private String VoterSSN;
    private boolean ifVoted; 
    private boolean hasVoted;
    private boolean isRegistered;

    //User either gets or sets the persons name.
    public void setVoterName(String newVoterName) {
        this.VoterName = newVoterName;
    }
    public String getVoterName() {
        return VoterName;
    }

    //User either gets or sets the persons DOB.
    public void setVoterDOB(String newVoterDOB) {
        this.VoterDOB = newVoterDOB;
    }
    public String getVoterDOB() {
        return VoterDOB;
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

    //

}