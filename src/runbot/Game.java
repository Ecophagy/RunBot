/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Oliver
 */
public abstract class Game {
    public Date date;
    public String opponent;
    public List maps;
    
    private Game(){}; //Default Constructor
    
    public Game(Date date, String opponent, List maps){
       this.date = date; 
       this.opponent = opponent;
       this.maps = maps;
    }
}
