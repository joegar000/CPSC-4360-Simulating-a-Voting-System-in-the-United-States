import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Candidate {
    private boolean viewCompletion;
    private String nameOfUser;
    enum State { // Not sure if this is the best way to do this, but does limit the input
        Alabama, Alaska, Arizona, Arkansas, California, Colorado, 
        Connecticut, Delaware, DistrictOfColumbia, Florida, Georgia, 
        Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, 
        Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, 
        Missouri, Montana, Nebraska, Nevada, NewHampshire, NewJersey, NewMexico, 
        NewYork, NorthCarolina, NorthDakota, Ohio, Oklahoma, Oregon, Pennsylvania, 
        RhodeIsland, SouthCarolina, SouthDakota, Tennessee, Texas, Utah, 
        Vermont, Virginia, Washington, WestVirginia, Wisconsin, Wyoming
    };
    private State userState;

    //Default constructor
    public Candidate() {

    }

    //Constructor with the arguements.
    public Candidate(boolean viewCompletion, String nameOfUser, State theState) {
        this.viewCompletion = viewCompletion;
        this.nameOfUser = nameOfUser;
        this.userState = theState;
        
    }

    //User either gets or sets the Electorate name.
    public void setUserName(String newName) {
        this.nameOfUser = newName;
    }
    public String getUserName() {
        return nameOfUser;
    }

    //User either gets or sets the viewCompletion
    public void setCompletion(boolean completion) {
        this.viewCompletion = completion;
    }
    public boolean getCompletion() {
        return viewCompletion;
    }

    //User either gets or sets the State the user is from
    public void setState(State theState) {
        this.userState = theState;
    }
    public State getState() {
        return userState;
    }
}
