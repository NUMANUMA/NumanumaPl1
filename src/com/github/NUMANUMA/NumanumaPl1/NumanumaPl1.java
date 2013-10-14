package com.github.NUMANUMA.NumanumaPl1;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NumanumaPl1 extends JavaPlugin {
    Logger log;
    public Event eve = new Event(this);

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info("プラグインが有効になりました。");

        getServer().getPluginManager().registerEvents(eve, this);
    }

    @Override
    public void onDisable() {
        log.info("プラグインが無効になりました。");
    }
}
