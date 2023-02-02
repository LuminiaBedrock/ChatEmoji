package theoni.chatemoji;

import cn.nukkit.plugin.PluginBase;
import theoni.chatemoji.listeners.EventListener;

public class Main extends PluginBase {

    public void onEnable() {
        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
    }
}
