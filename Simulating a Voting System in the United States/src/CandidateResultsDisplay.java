
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
    The CandidateResultsDisplay class extends VBox and when is instantiated is adds a Label to itself. The purpose of this class
    is to primarily display the results of the election thus far, and to provide an announcement for the winners. 

    When the showResults() method is called, the Display adds the results from the election for each party and
    its corresponding percentage of votes (per a straight ballot approach).
    When the enableGoBack() method is called, a "Go Back" button is added which allows the user to go back to 
    the previous screen (this is only used by the AdministratorOptions class).
    When the enableLogOut() method is called, a "Logout" button is added which allows the user to log out
    directly from the display (this is used by the Press and Electorate). 
    When the enabledAnnounce() method is called, an "Announce" button is added which will log the user out and
    display the winners of the election. 

    The method getWinner() gets an arraylist of all the winners including all the members of a tie. 
    The method getNumAllCurrentVotes() will return the total number of votes cast.
*/
class CandidateResultsDisplay extends VBox {

    private Label title = new Label("Candidate Results Display"); // This is a label for the title of the display
    private Button goBack = new Button("Go Back"); // This is a back button for when we need to go back (Admin)
    private Button logoutBtn = new Button("Log out"); // This button will log the user out
    private Button annBtn = new Button("Annouce"); // This button will announce the winners 

    /* constructor, only adds a title Label */
    public CandidateResultsDisplay() {
        this.setTranslateX(0); 
        title.setFont(new Font("Arial", 25));
        this.setSpacing(20.0);
        this.getChildren().add(title);
    }

    /* Adds a go back button for when we need to go back (Admin) */
    public void enableGoBack(Stage stage, Scene scene) {
        goBack.setOnAction(e -> stage.setScene(scene));
        this.getChildren().add(goBack);
    }

    /* for when we need to log out (Press and Electorate)*/
    public void enableLogOut(Stage stage)  {
        logoutBtn.setOnMouseClicked(e -> {
            stage.setScene(LoginWindow.getScene(stage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        this.getChildren().add(logoutBtn);
    };

    public void enableAnnounce(Stage stage)  {
        // Sets the action for when the announce button is clicked
        annBtn.setOnMouseClicked(e -> {
            stage.setScene(LoginWindow.getScene(stage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
            ArrayList<String[]> winner = getWinner(); // Contains an ArrayList of all the winner candidates
            String container = "";
            ArrayList<String> partyList = new ArrayList<String>(); // Contains an ArrayList of the pary(s) that won
            for (int i = 0; i < winner.size(); i++){
                if (partyList.size()<1) {
                    partyList.add(winner.get(i)[2]);
                } else if (!partyList.contains(winner.get(i)[2])) {
                    partyList.add(winner.get(i)[2]);
                }
            }

            for (int g = 0; g < winner.size(); g++){
                System.out.println(" Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" Party: " + winner.get(g)[2] +" Position: "+winner.get(g)[3]);
            }

            // These if statements deal with formatting in the case of a single winner, tie, and if no once votes. 
            if (partyList.size()>1) {
                container+="=There was a tie. The parties are";
                if (partyList.size()>2) {
                    for (int r = 0; r < partyList.size(); r++) {
                        if (r==0) 
                            container+=" " + partyList.get(r);
                        else if (r<partyList.size()-1)
                            container+=", " + partyList.get(r);
                        else
                            container+=", and " + partyList.get(r);
                    }
                } else {
                    for (int r = 0; r < partyList.size(); r++) {
                        if (r==0) 
                            container+=" " + partyList.get(r);
                        else
                            container+=" and " + partyList.get(r);
                    }
                }
                container+=". Here are the following contestants in the tie:";
                for (int g = 0; g < winner.size(); g++){
                    container+=" =Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" -- Party: " + winner.get(g)[2] +" -- Position: "+winner.get(g)[3];
                }
            } else if (partyList.isEmpty()) {
                container+="=There were no winners... no one voted.";
            } else {
                container+="=Congratulations to the winners of the " + partyList.get(0) + " party. Here are the candidates:";
                for (int g = 0; g < winner.size(); g++){
                    container+=" =Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" -- Party: " + winner.get(g)[2] +" -- Position: "+ winner.get(g)[3];
                }
            }

            LoginWindow.announce(container); // Usese a method in announce passing the string that contains all the formatting with a deliminter "="
        });
        this.getChildren().add(annBtn);
    };

    /* This method calculates the winner, returns an array list with all winners */
    public ArrayList<String[]> getWinner() {

        // This block gets the parties and respective votes
        ArrayList<String[]> candidates = Database.getAllCandidates(); // This ArrayList contains String arrays with information on all the candidates
        HashSet<String[]> partiesAdded = new HashSet<String[]>(); // This HashSet will contain String arrays with information on the parties and votes
        for (int i = 0; i < candidates.size(); i++ ) {
            Iterator<String[]> itParties = partiesAdded.iterator(); // iterator to iterate through HashSet
            String party = candidates.get(i)[2];
            String total = candidates.get(i)[4];
            String[] temp = {party,total};
            boolean check = true;
            for (int d = 0; d < partiesAdded.size(); d++) {
                String[] temp2 = itParties.next();
                System.out.println(temp2[0]);
                if (temp2[0].equalsIgnoreCase(temp[0])) {
                    check = false;
                }
            }
            if (check==true)
                partiesAdded.add(temp);
        }

        // This block gets the party winner from the parties
        String[] winner = new String[2]; // This will contain the current party winner
        Set<String> tieHolder = new HashSet<String>(); // This will contain parties if they tie
        Iterator<String[]> it = partiesAdded.iterator();
        for (int t = 0; t<partiesAdded.size(); t++) {
            String[] temp = it.next();
            if (winner[0]==null) {
                winner = temp;
            } else {
                if (Integer.parseInt(winner[1]) < Integer.parseInt(temp[1])) {
                    winner = temp;
                    //tieHolder = new String[10];
                    tieHolder.clear();
                } else if (Integer.parseInt(winner[1]) == Integer.parseInt(temp[1])) {
                    if (tieHolder.isEmpty()){
                        tieHolder.add(winner[0]);
                        tieHolder.add(temp[0]);
                    } else {
                        tieHolder.add(temp[0]);
                    }
                }
            }

        }


        //This block gets all the candidates from the party(s) that win(s)
        ArrayList<String[]> candidatesCollection = Database.getAllCandidates(); // This ArrayList contains String arrays with information on all the candidates
        ArrayList<String[]> winnerArrayList = new ArrayList<String[]>(); // This arrayList will contain the individual winnners (candidates)
        if (tieHolder.isEmpty()) {
            System.out.println("is empty");
            for (int i = 0; i < candidatesCollection.size(); i++ ) {
                System.out.println(winner[0] + " compared to "+ candidatesCollection.get(i)[2]);
                if (winner[0].equalsIgnoreCase(candidatesCollection.get(i)[2])) {
                    winnerArrayList.add(candidatesCollection.get(i));
                    System.out.println("gets added");
                } 
            }
        } else {
            Iterator<String> itTie = tieHolder.iterator();
            for (int f = 0; f < tieHolder.size(); f++){
                String temp = itTie.next();
                for (int i = 0; i < candidatesCollection.size(); i++ ) {
                    if (temp.equalsIgnoreCase(candidatesCollection.get(i)[2])) {
                        winnerArrayList.add(candidatesCollection.get(i));
                    } 
                }
            }
        }

        return winnerArrayList;
    }

    /* to be called wherever this Display is used */
    public void showResults() {
        ArrayList<String[]> candidates = Database.getAllCandidates(); // This ArrayList contains String arrays with information on all the candidates
        double totalVotes = (double) getNumAllCurrentVotes(candidates); // This will contain the total votes cast
        
        HashSet<String[]> partiesAdded = new HashSet<String[]>(); // This HashSet will contain String arrays with information on the parties and votes
        for (int i = 0; i < candidates.size(); i++ ) {
            Iterator<String[]> itParties = partiesAdded.iterator();
            String party = candidates.get(i)[2];
            String total = candidates.get(i)[4];
            String[] temp = {party,total};
            boolean check = true;
            for (int d = 0; d < partiesAdded.size(); d++) {
                String[] temp2 = itParties.next();
                System.out.println(temp2[0]);
                if (temp2[0].equalsIgnoreCase(temp[0])) {
                    check = false;
                }
            }
            if (check==true)
                partiesAdded.add(temp);
        }
        
        Iterator<String[]> itParties = partiesAdded.iterator();
        for (int g = 0; g < partiesAdded.size(); g++){
            String[] temp = itParties.next();
            double result = Integer.parseInt(temp[1])/totalVotes*100;
            String party = temp[0];
            PartyResultLabel label = new PartyResultLabel(party, result);
            this.getChildren().add(label);
        }
        
    }

    /* to get all of the current Votes, the candidates are passed as a parameter */
    public int getNumAllCurrentVotes(ArrayList<String[]> candidates){
        int votes = 0; // this holds the total number of votes

        //This block gets the parties and respective votes and puts them into a HashSet
        HashSet<String[]> partiesAdded = new HashSet<String[]>(); // This HashSet will contain String arrays with information on the parties and votes
        for (int i = 0; i < candidates.size(); i++ ) {
            Iterator<String[]> itParties = partiesAdded.iterator(); // iterator to iterate through HashSet
            String party = candidates.get(i)[2];
            String total = candidates.get(i)[4];
            String[] temp = {party,total};
            boolean check = true;
            for (int d = 0; d < partiesAdded.size(); d++) {
                String[] temp2 = itParties.next();
                System.out.println(temp2[0]);
                if (temp2[0].equalsIgnoreCase(temp[0])) {
                    check = false;
                }
            }
            if (check==true)
                partiesAdded.add(temp);
        }

        // This block totals all the votes from each of the parties
        Iterator<String[]> itParties = partiesAdded.iterator();
        for (int g = 0; g < partiesAdded.size(); g++){
            String[] temp = itParties.next();
            System.out.println("Party: "+temp[0]+" Votes: "+temp[1]);
            votes+=Integer.parseInt(temp[1]);
        }
        
        return votes;
    }

    /*Label Class for parties */
    public class PartyResultLabel extends Label {
        public PartyResultLabel(String party, double result) {
            this.setText("Party: " + party + " --- Resulting Percentage: " + String.format("%.2f",result));
        }
    }

    
}