import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Database {

    private static Connection voterConn = null;
    private static Connection pollWorkerConn = null;
    private static Connection administratorConn = null;
    private static Connection candidatesConn = null;
    private static Connection electorateConn = null;
    private static Connection pressConn = null;


    // SET UP DATABASES
    public static void setUpVoters() {
        voterConn = Database.connect("jdbc:sqlite:voters.db");
        Database.createNewVoterTable();
    }

    public static void setUpPollWorkers() {
        pollWorkerConn = Database.connect("jdbc:sqlite:pollworkers.db");
        Database.createNewPollWorkerTable();
    }

    public static void setUpAdministrators() {
        administratorConn = Database.connect("jdbc:sqlite:administrators.db");
        Database.createNewAdministratorTable();
    }

    public static void setUpCandidates() {
        candidatesConn = Database.connect("jdbc:sqlite:candidates.db");
        Database.createNewCandidatesTable();
    }

    public static void setUpElectorate() {
        electorateConn = Database.connect("jdbc:sqlite:electorate.db");
        Database.createNewElectorateTable();
    }

    public static void setUpPress() {
        pressConn = Database.connect("jdbc:sqlite:press.db");
        Database.createNewPressTable();
    }




    // CREATE DATABASE TABLES
    public static void createNewVoterTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS voters (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + "	age text NOT NULL,\n"
                + "	state text NOT NULL,\n"
                + " voted text NOT NULL DEFAULT FALSE\n"
                + ");";
        
        try (Statement stmt = voterConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "votertable");
        }
    }

    public static void createNewPollWorkerTable() {        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pollworkers (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = pollWorkerConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewAdministratorTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS administrators (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = administratorConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "admintable");
        }
    }

    public static void createNewCandidatesTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS candidates (\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + " party text NOT NULL,\n"
                + " position text NOT NULL,\n"
                + " votes text NOT NULL,\n"
                + " runningmate text NULL\n"
                + ");";
        
        try (Statement stmt = candidatesConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "candidate table");
        }
    }

    public static void createNewElectorateTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS electorate (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + " state text NOT NULL,"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = electorateConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "electorate table");
        }
    }

    public static void createNewPressTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS press (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = pressConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "presstable");
        }
    }




    // VOTER METHODS
    public static void vote(String party, String vote) {
        String sql = "UPDATE candidates SET votes = ? WHERE party = ?";
        
            try (PreparedStatement stmt = candidatesConn.prepareStatement(sql)) {
                String[] votesArr = Database.getCandidate(party);
                String votes = votesArr[votesArr.length-1];
                int voteCount = Integer.parseInt(votes);
                //int newVoteCount = voteCount+1;
                votes = Integer.toString(++voteCount);
                stmt.setString(1, votes);
                stmt.setString(2, party);
                stmt.executeUpdate();
            }
            catch(SQLException e) {
                System.out.println(e.getMessage() + "vote");
            }
            
    }

    public static void registerVoter(String ssn, String first_name, String last_name, String age, String state, boolean votedBool) {
        String voted = votedBool ? "TRUE" : "FALSE";

        String sql = "INSERT INTO voters(ssn,first_name,last_name,age,state,voted) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = voterConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, age);
            pstmt.setString(5, state);
            pstmt.setString(6, voted);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "registervoter");
        }
    }

    public static String[] getVoterInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name, age, state, voted FROM voters WHERE ssn LIKE ?";
        String[] info = new String[6];

        try (PreparedStatement stmt = voterConn.prepareStatement(sql)) {
            stmt.setString(1,ssn);
            ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
                    info[3] = rs.getString("age");
                    info[4] = rs.getString("state");
                    info[5] = rs.getString("voted");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getvoter");
        }
        return info;
    }

    // This returns an arraylist of string arrays for display the entire voter database, I assume
    // you could write javafx code that loops through and gets all the voter information
    public static ArrayList<String[]> getAllVoterInformation() {
        String sql = "SELECT ssn, first_name, last_name, age, state, voted FROM voters";
        ArrayList<String[]> allVoters = new ArrayList<>();

        try (Statement stmt = voterConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                
            while (rs.next()) {
                String[] info = new String[6];
                info[0] = rs.getString("ssn");
                info[1] = rs.getString("first_name");
                info[2] = rs.getString("last_name");
                info[3] = rs.getString("age");
                info[4] = rs.getString("state");
                info[5] = rs.getString("voted");
                allVoters.add(info);
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getvoter");
        }
        return allVoters;
    }


    public static void voterVoted(String ssn) {
        String sql = "UPDATE voters SET voted = ? WHERE ssn LIKE ?";
        
            try (PreparedStatement stmt = voterConn.prepareStatement(sql)) {
                String voted = "TRUE";
                stmt.setString(1, voted);
                stmt.setString(2, ssn);
                stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "votervoted");
        }
    }





    // POLL WORKER METHODS
    public static void registerPollWorker(String ssn, String first_name, String last_name) {
        String sql = "INSERT INTO pollworkers(ssn,first_name,last_name) VALUES(?,?,?)";

        try (PreparedStatement pstmt = pollWorkerConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Get the information for one poll worker based on their ssn
    public static String[] getPollWorkerInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name FROM pollworkers WHERE ssn LIKE ?";
        String[] info = new String[3];

        try (PreparedStatement stmt = pollWorkerConn.prepareStatement(sql)) {
            stmt.setString(1,ssn);
            ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return info;
    }


    


    // ADMINISTRATOR METHODS
    public static void registerAdministrator(String ssn, String first_name, String last_name) {
        String sql = "INSERT INTO administrators(ssn,first_name,last_name) VALUES(?,?,?)";
    
        try (PreparedStatement pstmt = administratorConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "admin register");
        }
    }

    // Get the information for one administrator based on their ssn
    public static String[] getAdministratorInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name FROM administrators WHERE ssn LIKE ?";
        String[] info = new String[3];
            try (PreparedStatement stmt = administratorConn.prepareStatement(sql)) {
                stmt.setString(1,ssn);
                ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getadmin");
        }
    
        return info;
    }





    // CANDIDATE METHODS
    // Register a candidate without a running mate
    public static void registerCandidate(String first_name, String last_name, String party, String position, String vote) {
        String sql = "INSERT INTO candidates(first_name,last_name,party,position,votes,runningmate) VALUES(?,?,?,?,?,NULL)";
    
        try (PreparedStatement pstmt = candidatesConn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, party);
            pstmt.setString(4, position);
            pstmt.setString(5, vote);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "registercandidate1");
        }
    }
    // Register a candidate with a running mate
    public static void registerCandidate(String first_name, String last_name, String party, String position, String runningMate, String vote) {
        String sql = "INSERT INTO candidates(first_name,last_name,party,position,votes,runningmate) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = candidatesConn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, party);
            pstmt.setString(4, position);
            pstmt.setString(5, vote);
            pstmt.setString(6, runningMate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "registercandidate2");
        }
    }

    // Get a candidate based on their party
    public static String[] getCandidate(String party) {
        String sql = "SELECT first_name, last_name, party, position, votes, runningmate FROM candidates WHERE party LIKE ?";
        String[] info = new String[6];
            try (PreparedStatement stmt = candidatesConn.prepareStatement(sql)) {
                stmt.setString(1,party);
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    if (rs.getString("runningmate") == null) {
                        info = new String[5];
                        info[0] = rs.getString("first_name");
                        info[1] = rs.getString("last_name");
                        info[2] = rs.getString("party");
                        info[3] = rs.getString("position");
                        info[4] = rs.getString("votes");
                    }
                    else {
                        info = new String[6];
                        info[0] = rs.getString("first_name");
                        info[1] = rs.getString("last_name");
                        info[2] = rs.getString("party");
                        info[3] = rs.getString("position");
                        info[4] = rs.getString("runningmate");
                        info[5] = rs.getString("votes");
                    }
                }
    
            }
            catch(SQLException e) {
                System.out.println(e.getMessage() + "getcandidate");
            }
    
        return info;
    }

    // This returns an arraylist of string arrays for display the entire candidate database, I assume
    // you could write javafx code that loops through and gets all the candidate information
    public static ArrayList<String[]> getAllCandidates() {
        String sql = "SELECT first_name, last_name, party, position, votes, runningmate FROM candidates";
        ArrayList<String[]> allCandidates = new ArrayList<>();

            try (Statement stmt = candidatesConn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            int x = 0;
            while (rs.next()) {
                if (rs.getString("runningmate") == null) {
                    String[] info = new String[5];
                    info[0] = rs.getString("first_name");
                    info[1] = rs.getString("last_name");
                    info[2] = rs.getString("party");
                    info[3] = rs.getString("position");
                    info[4] = rs.getString("votes");
                    allCandidates.add(info);
                }
                else {
                    String[] info = new String[6];
                    info[0] = rs.getString("first_name");
                    info[1] = rs.getString("last_name");
                    info[2] = rs.getString("party");
                    info[3] = rs.getString("position");
                    info[4] = rs.getString("votes");
                    info[5] = rs.getString("runningmate");
                    allCandidates.add(info);
                }
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "displayallcandidates");
        }
    
        return allCandidates;
    }



    // ELECTOR METHODS
    public static void registerElector(String ssn, String state, String first_name, String last_name) {
        String sql = "INSERT INTO electorate(ssn,state,first_name,last_name) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = electorateConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, state);
            pstmt.setString(3, first_name);
            pstmt.setString(4, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Get an elector's information based on their ssn
    public static String[] getElectorInformation(String ssn) {
        String sql = "SELECT ssn, state, first_name, last_name FROM electorate WHERE ssn LIKE ?";
        String[] info = new String[4];
            try (PreparedStatement stmt = electorateConn.prepareStatement(sql)) {
                stmt.setString(1,ssn);
                ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("state");
                    info[2] = rs.getString("first_name");
                    info[3] = rs.getString("last_name");
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getelector");
        }
    
        return info;
    }





    // PRESS METHODS
    public static void registerPress(String ssn, String first_name, String last_name) {
        String sql = "INSERT INTO press(ssn,first_name,last_name) VALUES(?,?,?)";

        try (PreparedStatement pstmt = pressConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "press register");
        }
    }

    // Get the press's information based on their ssn
    public static String[] getPressInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name FROM press WHERE ssn LIKE ?";
        String[] info = new String[3];
            try (PreparedStatement stmt = pressConn.prepareStatement(sql)) {
                stmt.setString(1,ssn);
                ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getpress");
        }
    
        return info;
    }




    // DATABASE CREATION METHODS
    public static Connection connect(String url) {
        Connection conn = null;

        Database.createNewDatabase(url);

        try {
            // db parameters
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void createNewDatabase(String url) {

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
