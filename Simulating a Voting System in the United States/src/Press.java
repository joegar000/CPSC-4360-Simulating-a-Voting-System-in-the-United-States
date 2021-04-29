/*
    
*/

public class Press {
    private String SSN, firstName, lastName;
    public static String ePassword = "Press";

    //Default constructor
    public Press() {
    }

    //Constructor with the arguements.
    public Press(String SSN, String firstName, String lastName) {
        this.SSN = SSN;
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