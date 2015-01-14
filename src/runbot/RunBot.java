package runbot;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;

public class RunBot{

    public static void main(String[] args) throws Exception {
            //Configure what we want our bot to do
            Configuration configuration = new Configuration.Builder()
                            .setName("RuNBot") //Set the nick of the bot. CHANGE IN YOUR CODE
                            .setServerHostname("irc.quakenet.org") //Join the freenode network
                            .addAutoJoinChannel("#run") //Join the official #pircbotx channel
                            .addListener(new MyListener()) //Add our listener that will be called on Events
                            .buildConfiguration();

            //Create our bot with the configuration
            PircBotX bot = new PircBotX(configuration);
            //Connect to the server
            bot.startBot();
    }

}
