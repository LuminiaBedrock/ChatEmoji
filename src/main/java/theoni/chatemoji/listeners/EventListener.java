package theoni.chatemoji.listeners;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import theoni.chatemoji.Main;

import java.util.Arrays;
import java.util.List;

public class EventListener implements Listener {

    private Main main;

    public EventListener(Main main) {
        this.main = main;
    }
    
    @EventHandler
    public void onChat(PlayerChatEvent event) {

        List<String> message = Arrays.asList(event.getMessage().split(" "));

        for(String section : main.getConfig().getSection("emoji").getKeys(false)) {

            String original = main.getConfig().getString("emoji." + section + ".original");
            String newtext = main.getConfig().getString("emoji." + section + ".new");
            
            if(message.indexOf(original) != -1) {
                message.set(message.indexOf(original), newtext);
            }
        }

        event.setMessage(String.join(" ", message));
    }
}
