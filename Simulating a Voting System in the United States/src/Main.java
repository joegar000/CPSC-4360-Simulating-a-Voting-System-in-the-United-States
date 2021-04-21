/*
Project: Voting System
CPSC - 4360 - 01, Spring 2021

*/
import java.util.*;
  
/*public class Main {
  public static void main(String[] args) throws Exception {        

    String firstName = "";
    String lastName = "";
    String SSN = "";
    String password = ""; */



import javafx.application.*;
import javafx.stage.*;


public class Main extends Application {
	
	public static void main(String[] args) {
		Database.setUpVoters();
		Database.setUpPollWorkers();
		Database.setUpAdministrators();
		Database.setUpCandidates();

		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to the US elections!");

		/*HEY YOU LOOK HERE!!! Okay, since the login window is not linked yet. 
		When you run, it will only display the login screen. If you wish to see 
		if your FX stuff is working with this project just edit these parts.
		
		primaryStage.setScene(YOURCLASS.getScene(primaryStage));
		primaryStage.setScene(VoterOptions.getScene(primaryStage));

		Then if you still see the login screen. Comment this part 
		out until you are done and restore it afterwards.

		"primaryStage.setScene(VoterOptions.getScene(primaryStage));"
		and
		"primaryStage.setScene(AdministratorOptions.getScene(primaryStage));"

		Then you should be able to test your FX.
		
		*/
		primaryStage.setScene(LoginWindow.getScene(primaryStage));
		primaryStage.show();


   		// Return to login screen
	}
	
	// I had to make a separate method for checking the password in order for logging in to work properly, we can make all the next steps within this method
	public static void checkPassword(String password, String firstName, String lastName, String SSN, Stage primaryStage) {

   		// Take firstName, lastName, and password from javaFX fields
   		if (password.equals(Voter.VoterPassword)) {
   			  // Compare firstName and lastName with database objects, if there is
   			  // a match sign the user in, if no match, give not registered error

   			  //Voter user = //voter pulled from database with SSN acting as the key;

   			  primaryStage.setScene(VoterOptions.getScene(primaryStage));
   			  // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(PollWorker.password)) {
   		 	 // Compare firstName and lastName with database objects, if there is
   			  // a match sign the user in, if no match, give not registered error

   		 	 //PollWorker user = pollw worker pulled from database with SSN acting as the key;

   		 	 primaryStage.setScene(PollWorkerOptions.getScene(primaryStage));
   		 	 // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(Administrator.adminPassword)) {
   		  	// Compare firstName and lastName with database objects, if there is
   		  	// a match sign the user in, if no match, give not registered error

   		  	//Administrator user = administrator pulled from database with SSN acting as the key;

			primaryStage.setScene(AdministratorOptions.getScene(primaryStage));// Take user to new JavaFX screen with the administrator options
   			// The different buttons will be user.method() using setOnClickListeners
   		}
	}
}