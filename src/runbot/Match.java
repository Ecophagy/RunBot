/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.util.Date;
import runbot.Constants.League;

/**
 *
 * @author Oliver
 */
public class Match extends Game {
    
    public String matchpage;
    public League league;
    public int week;
    
    public Match(String date, String time, String opponent, String map1, String map2, String matchpage, League league, int week){
        super(date, time, opponent, map1, map2);
        this.matchpage = matchpage;
        this.league = league;
        this.week = week;
    }
}
