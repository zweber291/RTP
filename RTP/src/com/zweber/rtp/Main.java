package com.zweber.rtp;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

    FileConfiguration config;
    public static Main plugin;

    public Main()
    {
        config = getConfig();
    }

    public void onEnable()
    {
        getLogger().info("Enabling RTP");
        getCommand("rtp").setExecutor(new commandRtp());
    }

    public void onDisable()
    {
        getLogger().info("Disabling RTP");
    }
}