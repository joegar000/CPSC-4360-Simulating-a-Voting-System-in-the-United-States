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



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class Main extends Application {
	public void start(Stage primaryStage) {
		
		/** Creating a pane */
		Pane pane = new Pane();
		
		/** Creating the first (horizontal) line */
		Line line1 = new Line(0, 0, 0, 0);
		/** Adding the line to the pane */
		pane.getChildren().add(line1);
		/** Setting the line's color */
		line1.setStroke(Color.BLUE);
		/** Making the line always reach from one side of the pane to the other */
		line1.endXProperty().bind(pane.widthProperty());
		/** Making the line always be 1/3 away from the parallel side that is closest to it */
		line1.startYProperty().bind((pane.heightProperty().divide(3)));
		line1.endYProperty().bind((pane.heightProperty().divide(3)));
		
		/** Creating the second (horizontal) line */
		Line line2 = new Line(0, 0, 0, 0);
		/** Adding the line to the pane */
		pane.getChildren().add(line2);
		/** Setting the line's color */
		line2.setStroke(Color.BLUE);
		/** Making the line always reach from one side of the pane to the other */
		line2.endXProperty().bind(pane.widthProperty());
		/** Making the line always be 1/3 away from the parallel side that is closest to it */
		line2.startYProperty().bind((pane.heightProperty().multiply(2).divide(3)));
		line2.endYProperty().bind((pane.heightProperty().multiply(2).divide(3)));
		
		/** Creating the third (first vertical) line */
		Line line3 = new Line(0, 0, 0, 0);
		/** Adding the line to the pane */
		pane.getChildren().add(line3);
		/** Setting the line's color */
		line3.setStroke(Color.RED);
		/** Making the line always reach from one side of the pane to the other */
		line3.endYProperty().bind(pane.heightProperty());
		/** Making the line always be 1/3 away from the parallel side that is closest to it */
		line3.startXProperty().bind((pane.widthProperty().divide(3)));
		line3.endXProperty().bind((pane.widthProperty().divide(3)));
		
		/** Creating the fourth (second vertical) line */
		Line line4 = new Line(0, 0, 0, 0);
		/** Adding the line to the pane */
		pane.getChildren().add(line4);
		/** Setting the line's color */
		line4.setStroke(Color.RED);
		/** Making the line always reach from one side of the pane to the other */
		line4.endYProperty().bind(pane.heightProperty());
		/** Making the line always be 1/3 away from the parallel side that is closest to it */
		line4.startXProperty().bind((pane.widthProperty().multiply(2).divide(3)));
		line4.endXProperty().bind((pane.widthProperty().multiply(2).divide(3)));
		
		
		/** Adding the pane to a scene and displaying it */
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("GridDisplay");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

    /*// Set up JavaFX window 'n stuff
    // Have empty fields for user to input credentials

    // Take firstName, lastName, and password from javaFX fields
    if (password.equals("")) {
      // Compare firstName and lastName with database objects, if there is
      // a match sign the user in, if no match, give not registered error

      Voter user = //voter pulled from database with SSN acting as the key;

      // Take user to new JavaFX screen with the voter options
      // The different buttons will be user.method() using setOnClickListeners
    }

    else if (password.equals(PollWorker.password)) {
      // Compare firstName and lastName with database objects, if there is
      // a match sign the user in, if no match, give not registered error

      PollWorker user = //voter pulled from database with SSN acting as the key;

      // Take user to new JavaFX screen with the voter options
      // The different buttons will be user.method() using setOnClickListeners
    }

    else if (password.equals(Administrator.adminPassword)) {
      // Compare firstName and lastName with database objects, if there is
      // a match sign the user in, if no match, give not registered error

      Administrator user = //voter pulled from database with SSN acting as the key;

      // Take user to new JavaFX screen with the voter options
      // The different buttons will be user.method() using setOnClickListeners
    }

    // Return to login screen */
  }
}