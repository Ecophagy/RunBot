/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.types.GenericMessageEvent;

/**
 *
 * @author Oliver
 */
public class MyListener extends ListenerAdapter {
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                //When someone says hello, respond with Hello World
                if (event.getMessage().startsWith("?helloworld"))
                        event.respond("Hello world!");
                else if(event.getMessage().startsWith("!nextscrim")){
                    DbConnector dbc = new DbConnector();
                    //TODO: Make "next scrim" function in DbConnector
                }
                else if(event.getMessage().startsWith("!scrims")){
                    DbConnector dbc = new DbConnector();
                    Scrim scrims = dbc.listScrims();
                    SimpleDateFormat format = new SimpleDateFormat("H:m d/MM/yyyy");
                    String date =  format.format(scrims.DateandTime);
                    event.respond("Date: " + date);
                    event.respond("Opponent: " + scrims.opponent);
                    event.respond("Maps: " + scrims.map1 + " & " + scrims.map2);
                }
        }
}