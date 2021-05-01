import java.util.*;
import javafx.application.*;
import javafx.stage.*;


public class Main extends Application {
	
	public static void main(String[] args) {

		// Set up the database tables
		Database.setUpVoters();
		Database.setUpPollWorkers();
		Database.setUpAdministrators();
		Database.setUpCandidates();
		Database.setUpElectorate();
		Database.setUpPress();

		// Add the default users
		Database.registerAdministrator("1", "Default", "User");
		Database.registerPress("2", "Associated", "Press");


		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
	
		// Pull up the login window
		primaryStage.setTitle("Welcome to the US elections!");
		primaryStage.setScene(LoginWindow.getScene(primaryStage));
		primaryStage.show();
	}
	

	// Method for checking that the information input into the fields is correct
	public static void checkPassword(String password, String firstName, String lastName, String SSN, Stage primaryStage) {

   		// If the voter password is correct
   		if (password.equals(Voter.VoterPassword)) {

			// Get the voter's information based on their SSN
			String[] info = Database.getVoterInformation(SSN);
			boolean voted;

			// Check if the voter has already voted
			if (info[5].equals("true") || info[5].equals("TRUE")) voted = true;
			else voted = false;

   			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in, if no match, give not registered error
			if (info[1].equals(firstName) && info[2].equals(lastName) && !voted) {
				Voter voter = new Voter(info[0], info[1], info[2], info[3], info[4], voted);
				primaryStage.setScene(VoterOptions.getScene(primaryStage));
			} 
			
			//If the user has already voted, then they will stay in the login screen.
			else if (voted) {
				primaryStage.setScene(LoginWindow.getScene(primaryStage));
				LoginWindow.error.setText("You've already voted.");

			}
			// After the voter votes, update the database
			Database.voterVoted(SSN);
   		}

		// If the poll worker password is correct
   		else if (password.equals(PollWorker.password)) {

			// Get the poll worker's information based on their SSN
			String[] info = Database.getPollWorkerInformation(SSN);

			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in
			if (info[1].equals(firstName) && info[2].equals(lastName)) {
				PollWorker pollWorker = new PollWorker(info[0], info[1], info[2]);
				primaryStage.setScene(PollWorkerOptions.getScene(primaryStage));
			}
   		}

		// If the administrator password is correct
   		else if (password.equals(Administrator.adminPassword)) {

			// Get the administrator's information based on their SSN
			String[] info = Database.getAdministratorInformation(SSN);

			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in
			if (info[1].equals(firstName) && info[2].equals(lastName)) {
				Administrator admin = new Administrator(info[0], info[1], info[2]);
				primaryStage.setScene(AdministratorOptions.getScene(primaryStage));
			}
   		}
		
		// If the electorate password is correct
		else if (password.equals(Electorate.ePassword)) {
			
			// Get the electorate's information based on their SSN
			String[] info = Database.getElectorInformation(SSN);

			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in
			if (info[2].equals(firstName) && info[3].equals(lastName)) {
				Electorate elec = new Electorate(info[0], info[1], info[2], info[3]);
				primaryStage.setScene(ElectorateHandler.getScene(primaryStage));
			}
   		}

		// If the press password is correct
		else if (password.equals(Press.pPassword)) {
			System.out.println("password ready");

			// Get the electorate's information based on their SSN
			String[] info = Database.getPressInformation(SSN);
			
			// Compare firstName and lastName with database objects, if there is
   			// a match sign the user in
			if (info[1].equals(firstName) && info[2].equals(lastName)) {
				System.out.println("right name");
				Press p = new Press(info[0], info[1], info[2]);
				primaryStage.setScene(PressHandler.getScene(primaryStage));
			}
   		}
	}
}