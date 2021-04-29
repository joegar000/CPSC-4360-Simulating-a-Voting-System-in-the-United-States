/* I (Alejandro) have wrote a basic window for the login window.
I do not really know how to link them to lead into the correct scenes yet.*/

/* David: I had to do some fiddling with this class in order to get the logging in
process to work properly */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginWindow extends Application {
	
    //Create variable text fields for the login window.
    public static TextField firstName = new TextField();
    public static TextField lastName = new TextField();
    public static TextField SSN = new TextField();
    public static TextField password = new TextField();
    public static Label error = new Label();

    public static VBox layout1;
    public static Stage announcmentStage;

    @Override
    public void start(Stage arg0) throws Exception {
        // Ignore this
	}

    public static Scene getScene(Stage stage) {
        //Creates a scene that will link to others.
        Scene loginScene;

        //Displays instructions to the voter. Also, changes text font and size.
        Label firstLabel = new Label("Please enter your information to continue.");
        firstLabel.setFont(new Font("Arial", 18));

        //Create a somewhat nice layout.
        layout1 = new VBox(15, firstLabel);
        layout1.setAlignment(Pos.CENTER);
        
        //Creates a login button with set font and size.
        Button loginButton = new Button("Login");
        loginButton.setFont(new Font("Arial", 18));

        //Creates the display that the user will see and enter their information on.
        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.getChildren().addAll(
                new Label("Please enter your first name"),
                firstName,
                new Label("Please enter your last name"),
                lastName,
                new Label("Please enter your SSN"),
                SSN,
                new Label("Please enter your account type"),
                password,
                error,
                loginButton);
                
                //Creates lgin scene size.
                loginScene = new Scene(layout1, 950, 700);
        
        //On mouse click, it will either let the user enter the system or not.
        loginButton.setOnMouseClicked(e -> {
        	Main.checkPassword(getPassword(), getFirstName(), getLastName(), getSSN(), stage);
        });

        //Returns the login scene.
        return loginScene;
    }

    public static void announce(String winner) {
        announcmentStage = new Stage();
        VBox presentation = new VBox();
        String[] results = winner.split("=");
        Label[] labelArray = new Label[results.length];
        for (int i = 1; i < results.length; i++) {
            labelArray[i] = new Label(results[i]);
            labelArray[i].setFont(new Font("Arial", 25));
            presentation.getChildren().add(labelArray[i]);
        }
        Button exit = new Button("Close");

        presentation.setTranslateX(0); // change later

        exit.setOnMouseClicked(e -> {
                announcmentStage.close();
            });
        presentation.getChildren().add(exit);
        presentation.setAlignment(Pos.CENTER);

        Scene winScene = new Scene(presentation,1600,700);
        announcmentStage.setScene(winScene);
        announcmentStage.show();
    }
    
    //Gets the first name to see if it is within the database.
    public static String getFirstName() {
    	return firstName.getText();
    }
    
    //Gets the last name to see if it is within the database.
    public static String getLastName() {
    	return lastName.getText();
    }
    
    //Gets the SSN to see if it is within the database.
    public static String getSSN() {
    	return SSN.getText();
    }
    
    //Gets the password to see if it matches.
    public static String getPassword() {
    	return password.getText();
    }
}