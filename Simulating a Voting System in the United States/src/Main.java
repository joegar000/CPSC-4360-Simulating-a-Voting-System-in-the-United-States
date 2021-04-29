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
		Database.setUpElectorate();
		Database.setUpPress();

		
		Database.registerCandidate("Joe", "Biden", "Democraft", "President", "Kamala Harris", "0");
		Database.registerCandidate("Mary", "Jane", "Independent", "President", "Mason Hoover", "0");
		Database.registerCandidate("Matt", "Guy", "Green", "Senate", "0");
		Database.registerCandidate("Matt", "Geatz", "Republican", "Senate", "0");
		Database.registerCandidate("Tim", "Sim", "Republican", "Senate", "0");
		Database.registerCandidate("Donald", "Trump", "Republican", "President", "Mike Pence", "0");



		Database.registerPollWorker("987654321", "David", "Garcia");
		Database.registerAdministrator("431765289", "Kaden", "Carter");
		Database.registerAdministrator("12","D","I");
		Database.registerElector("12","Texas","D","I");
		Database.registerVoter("12","D","I","21","Texas", false);
		Database.registerVoter("21","I","D","45","Texas", false);
		

		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome to the US elections!");

		primaryStage.setScene(LoginWindow.getScene(primaryStage));
		primaryStage.show();


   		// Return to login screen
	}
	
	// I had to make a separate method for checking the password in order for logging in to work properly, we can make all the next steps within this method
	public static void checkPassword(String password, String firstName, String lastName, String SSN, Stage primaryStage) {

   		// Take firstName, lastName, and password from javaFX fields
   		if (password.equals(Voter.VoterPassword)) {

			String[] info = Database.getVoterInformation(SSN);
			boolean voted;

			if (info[5].equals("true") || info[5].equals("TRUE")) voted = true;
			else voted = false;

			//Voter user = //voter pulled from database with SSN acting as the key;
			Voter voter;

   			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in, if no match, give not registered error
			if (info[1].equals(firstName) && info[2].equals(lastName) && !voted) {
				voter = new Voter(info[0], info[1], info[2], info[3], info[4], voted);
				primaryStage.setScene(VoterOptions.getScene(primaryStage));

			} 
			
			//If the user has already voted, then they will stay in the login screen.
			else if (voted) {
				primaryStage.setScene(LoginWindow.getScene(primaryStage));
				LoginWindow.error.setText("You've already voted.");

			} else {
				
			}


			Database.voterVoted(SSN);	// AFTER THE VOTER VOTES, CALL Database.voterVoted() TO UPDATE THEIR VOTE STATUS TO TRUE
   			  // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(PollWorker.password)) {

			String[] info = Database.getPollWorkerInformation(SSN);

			if (info[1].equals(firstName) && info[2].equals(lastName)) {
				PollWorker pollWorker = new PollWorker(info[0], info[1], info[2]);
				primaryStage.setScene(PollWorkerOptions.getScene(primaryStage));

			}

			else {
				// display some kind of error, the pollworker's first and last name do not match the ssn
			}

   		 	 // Compare firstName and lastName with database objects, if there is
   			  // a match sign the user in, if no match, give not registered error

   		 	 // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(Administrator.adminPassword)) {

			String[] info = Database.getAdministratorInformation(SSN);

			if (info[1].equals(firstName) && info[2].equals(lastName)) {
				Administrator admin = new Administrator(info[0], info[1], info[2]);
				primaryStage.setScene(AdministratorOptions.getScene(primaryStage));
			}

			else {
				// display some kind of error, the pollworker's first and last name do not match the ssn
			}
   		  	// Compare firstName and lastName with database objects, if there is
   		  	// a match sign the user in, if no match, give not registered error

   		  	//Administrator user = administrator pulled from database with SSN acting as the key;

			// Take user to new JavaFX screen with the administrator options
   			// The different buttons will be user.method() using setOnClickListeners
   		} else if (password.equals(Electorate.ePassword)) {

			String[] info = Database.getElectorInformation(SSN);

			if (info[2].equals(firstName) && info[3].equals(lastName)) {
				Electorate elec = new Electorate(info[0], info[1], info[2], info[3]);
				primaryStage.setScene(ElectorateHandler.getScene(primaryStage));
			} else {
				
			}
   		} else if (password.equals(Press.ePassword)) {

			String[] info = Database.getPressInformation(SSN);

			if (info[2].equals(firstName) && info[3].equals(lastName)) {
				Press p = new Press(info[0], info[1], info[2]);
				primaryStage.setScene(PressHandler.getScene(primaryStage));
			}

			else {
			
			}
   		}
	}
}