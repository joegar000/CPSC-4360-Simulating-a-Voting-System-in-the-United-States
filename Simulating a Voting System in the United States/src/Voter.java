/*
Comments, edits, questions, suggestions, or concerns are welcomed!

Todo list:
1. Discuss how to save the voters information and than check to see if the information matches. As well as, if they voted once.


*/

public class Voter {
    /*Example:
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
    Note: This is a vague idea of doing it as it was 
    unclear how to store the voters information and 
    check to see if it matches. Unsure if the database 
    that was mentioned would also do this.

    Makeshift formula:
    "Registering" = Name + Age + State + SSN
    IsRegistered = "Registering"
    IfVoted = IsRegistered 
    HasVoted = IfVoted + IsRegistered

    Each will be dependent on each other.
    */
    public boolean CheckIsRegistered() {

    }
    public boolean CheckIfVoted() {
        
    }
    public boolean CheckHasVoted() {

    }


}