/*
    
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Press {
    private boolean viewCompletion;
    private String nameOfPress;

    //Default constructor
    public Press() {
    }

    //Constructor with the arguements.
    public Press(boolean viewCompletion, String nameOfPress) {
        this.viewCompletion = viewCompletion;
        this.nameOfPress = nameOfPress;
    }

    //User either gets or sets the Press name.
    public void setPressName(String newName) {
        this.nameOfPress = newName;
    }
    public String getPressName() {
        return nameOfPress;
    }
    //User either gets or sets the viewCompletion
    public void setCompletion(boolean completion) {
        this.viewCompletion = completion;
    }
    public boolean getCompletion() {
        return viewCompletion;
    }
    
}