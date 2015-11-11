package ga.uabart.twimp.Helpers;

import ga.uabart.twimp.TwimpGame;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;

import java.io.IOException;

public class IrcHelper extends PircBot {

    private TwimpGame game;

    public IrcHelper(TwimpGame game) {

        this.game = game;

        // debugging output
        this.setVerbose(true);

        this.setName("uaBArtBot");
        // Connect to the IRC server.
        try {
            this.connect("irc.twitch.tv", 6667, "oauth:9ldmg9z1p0uesld6gpa0cqn3i2btkt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IrcException e) {
            e.printStackTrace();
        }

        // Join the #uabart channel.
        this.joinChannel("#uabart");
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        if (message.equalsIgnoreCase("create")) {
            game.people.addPers(sender);
        }
    }
}
