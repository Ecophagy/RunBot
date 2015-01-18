/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class DbConnector {
    

    public Connection connect(){
        Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:games.db");
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
        
        return c;
    }
    
    private void insertTestEntry(){
        try{
            Connection c = connect();
            Statement stmt = c.createStatement();
            c.setAutoCommit(false);

            String sql = "INSERT INTO SCRIM (ID, DATE, OPPONENT, MAP1, MAP2) " + 
                        "VALUES (1,'12 01, 17', 'Test team', 'cp_process', 'pl_upward');";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    public void createScrimTable(){
        try{
            Connection c = connect();
            Statement stmt = c.createStatement();
            
            String sql = "CREATE TABLE SCRIM" + 
                        "(ID INT PRIMARY KEY NOT NULL, " +
                        "DATE TEXT          NOT NULL, "  +
                        "OPPONENT TEXT, "                +
                        "MAP1 TEXT, "                   +
                        "MAP2 TEXT)";
                    
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
        public void createMatchTable(){
        try{
            Connection c = connect();
            Statement stmt = c.createStatement();
            
            String sql = "CREATE TABLE MATCH" + 
                        "(ID INT PRIMARY KEY NOT NULL, " +
                        "DATE TEXT          NOT NULL, "  +
                        "OPPONENT TEXT, "                +
                        "MAP1 TEXT NOT NULL, "           +
                        "MAP2 TEXT, "                    +
                        "LEAGUE TEXT        NOT NULL, "  +
                        "WEEK INT           NOT NULL, "  +
                        "MATCHPAGE TEXT)";

                    
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    
    public Scrim listScrims(){
        Scrim scrim = null;
        try{
            createScrimTable();
            createMatchTable();
            insertTestEntry();
            
            Connection c = connect();
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SCRIM;");
            while (rs.next()){
                String rawdate = rs.getString("date");
                SimpleDateFormat format = new SimpleDateFormat("d MM, H");
                java.util.Date date = format.parse(rawdate);
                String opponent = rs.getString("opponent");
                String map1 = rs.getString("map1");
                String map2 = rs.getString("map2");
                
                scrim = new Scrim(date, opponent, map1, map2);
            }
            rs.close();
            stmt.close();
            c.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
       }
        return scrim;
    }
    

}
