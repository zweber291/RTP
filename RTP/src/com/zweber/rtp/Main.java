package com.zweber.rtp;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        getLogger().info("Enabling RTP"); // Sends message to console saying the plugin was enabled
        getCommand("rtp").setExecutor(new commandRtp()); // Associates /rtp command with the commandRtp class
    }

    public void onDisable() {
        getLogger().info("Disabling RTP"); // Sends message to console saying the plugin was disabled
    }
    
}