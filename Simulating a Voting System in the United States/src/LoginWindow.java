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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginWindow extends Application {
	
    public static TextField firstName = new TextField();
    public static TextField lastName = new TextField();
    public static TextField SSN = new TextField();
    public static TextField password = new TextField();


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
        VBox layout1 = new VBox(15, firstLabel);
        layout1.setAlignment(Pos.CENTER);
        
        Button loginButton = new Button("Login");

        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.getChildren().addAll(
                new Label("Please enter your first name"),
                firstName,
                new Label("Please enter your last name"),
                lastName,
                new Label("Please enter your SSN"),
                SSN,
                new Label("Please enter your password"),
                password,
                loginButton);

        loginScene = new Scene(layout1, 800, 750);
        
        loginButton.setOnMouseClicked(e -> {
        	Main.checkPassword(getPassword(), getFirstName(), getLastName(), getSSN(), stage);
        });

        return loginScene;
    }
    
    
    public static String getFirstName() {
    	return firstName.getText();
    }
    
    public static String getLastName() {
    	return lastName.getText();
    }
    
    public static String getSSN() {
    	return SSN.getText();
    }
    
    public static String getPassword() {
    	return password.getText();
    }
}