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

  
public class Main {
  public static void main(String[] args) throws Exception {        



      // Database stuff, we don't have to worry about this yet
      Connection conn = null;
      try {
      String url = "jdbc:sqlite:chinook.db";
      conn = DriverManager.getConnection(url);
    
      System.out.println("Got it!");
    
      } catch (SQLException e) {
         throw new Error("Problem", e);
      } finally {
        try {
          if (conn != null) {
              conn.close();
          }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }
  }
}