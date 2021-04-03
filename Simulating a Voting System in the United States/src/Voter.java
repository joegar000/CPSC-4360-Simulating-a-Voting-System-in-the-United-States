/*


Comments, edits, questions, suggestions, or concerns are welcomed!


*/

public class Voter {
    /*Example:
    Name: Joe Buden
    DOB: 03/16/1969
    State: Texas
    SSN (In some places it only requires numbers, while in other places it requires numbers and dashes.): 123 - 45 - 6789 or 123456789
    Voted: No
    */
    public String Name;
    public String DOB;
    public String State;
    protected String SSN;
    protected boolean ifVoted; 

    //User either get or set the persons name.
    public void setName(String newName) {
        this.Name = newName;
    }
    public String getName() {
        return Name;
    }

    //User either get or set the persons DOB.
    public void setDOB(String newDOB) {
        this.DOB = newDOB;
    }
    public String getDOB() {
        return DOB;
    }

    //User either get or set the persons State.
    public void setState(String newState) {
        this.State = newState;
    }
    public String getState() {
        return State;
    }
}

