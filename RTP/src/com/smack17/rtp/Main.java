package com.smack17.rtp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	FileConfiguration config = this.getConfig();
	public static Main plugin;
	
    public void onEnable() {
    	plugin = this;
        getLogger().info("Enabling RTP"); // Sends message to console saying the plugin was enabled
        getCommand("rtp").setExecutor(new commandRtp()); // Associates /rtp command with the commandRtp class
        config.addDefault("distance", 1000); // Creates configuration file to configure distance teleported
        config.options().copyDefaults(true); // Copies values to config file
        saveConfig(); // Saves config
    }

    public void onDisable() {
        getLogger().info("Disabling RTP"); // Sends message to console saying the plugin was disabled
    }
    
}