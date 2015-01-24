/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.util.Date;

/**
 *
 * @author Oliver
 */
public abstract class Game {
    public String time;
    public String date;
    public String opponent;
    public String map1;
    public String map2;
    
    public Game(){}; //Default Constructor
    
    public Game(String date, String time, String opponent, String map1, String map2){
       this.date = date; 
       this.time = time;
       this.opponent = opponent;
       this.map1 = map1;
       this.map2 = map2;
    }
}
