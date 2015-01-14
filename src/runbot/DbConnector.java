/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.sql.*;

/**
 *
 * @author Oliver
 */
public class DbConnector {
    
    public Connection connect(){
        Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test:db");
        }
        catch(Exception e){
            //LOGGING
        }
        
        return c;
    }
    
    public void createTable(){
        try{
            Connection c = connect();
            Statement stmt = c.createStatement();
            
            String sql = null; //CREATE
            
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        }
        catch(Exception e){
            //Logging
        }
    }
    
}
