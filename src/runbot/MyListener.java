/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package runbot;

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
                else if(event.getMessage().startsWith("!scrims")){
                    DbConnector dbc = new DbConnector();
                    Scrim scrims = dbc.listScrims();
                    event.respond(scrims.date.toString());
                }
        }
}