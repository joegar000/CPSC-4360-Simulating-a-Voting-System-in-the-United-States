/*
Project: Voting System
CPSC - 4360 - 01, Spring 2021

*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.*;

// David Garcia
// COSC 1174
// 3/19/2019
// The purpose of this program is to display a 3 by 3 grid with the horizontal lines being blue and the vertical lines being red. The horizontal lines will always remain
// 1/3 of the Scene's height from the side closest to them. Likewise, the vertical will always remain 1/3 of the Scene's width from the side closest to them.

  
/*public class Main {
  public static void main(String[] args) throws Exception {        

    String firstName = "";
    String lastName = "";
    String SSN = "";
    String password = ""; */



import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;


public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(LoginWindow.getScene());
		primaryStage.show();

		String firstName = "";
		String lastName = "";
		String SSN = "";
		String password = "";
   		
		// Set up JavaFX window 'n stuff
   		// Have empty fields for user to input credentials

   		// Take firstName, lastName, and password from javaFX fields
   		if (password.equals("")) {
   			  // Compare firstName and lastName with database objects, if there is
   			  // a match sign the user in, if no match, give not registered error

   			  //Voter user = //voter pulled from database with SSN acting as the key;

   			  primaryStage.setScene(VoterOptions.getScene());
   			  // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(PollWorker.password)) {
   		 	 // Compare firstName and lastName with database objects, if there is
   			  // a match sign the user in, if no match, give not registered error

   		 	 //PollWorker user = pollw worker pulled from database with SSN acting as the key;

   		 	 primaryStage.setScene(PollWorkerOptions.getScene());
   		 	 // The different buttons will be user.method() using setOnClickListeners
   		}

   		else if (password.equals(Administrator.adminPassword)) {
   		  	// Compare firstName and lastName with database objects, if there is
   		  	// a match sign the user in, if no match, give not registered error

   		  	//Administrator user = administrator pulled from database with SSN acting as the key;

			primaryStage.setScene(AdministratorOptions.getScene());// Take user to new JavaFX screen with the administrator options
   			// The different buttons will be user.method() using setOnClickListeners
   		}

   		// Return to login screen
	}
}