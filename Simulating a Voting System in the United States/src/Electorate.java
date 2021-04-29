/*

*/

public class Electorate {
    private String SSN, state, firstName, lastName;
    public static String ePassword = "Electorate";

    //Default constructor
    public Electorate() {

    }

    //Constructor with the arguements.
    public Electorate(String SSN, String state, String firstName, String lastName) {
        this.SSN = SSN;
        this.state = state;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //User either gets or sets the Elector SSN.
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    public String getSSN() {
        return SSN;
    }

    //User either gets or sets the Elector SSN.
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    //User either gets or sets the Elector SSN.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    //User either gets or sets the Elector SSN.
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    
}
