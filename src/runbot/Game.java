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
    public Date date;
    public String opponent;
    public String map1;
    public String map2;
    
    public Game(){}; //Default Constructor
    
    public Game(Date date, String opponent, String map1, String map2){
       this.date = date; 
       this.opponent = opponent;
       this.map1 = map1;
       this.map2 = map2;
    }
}
