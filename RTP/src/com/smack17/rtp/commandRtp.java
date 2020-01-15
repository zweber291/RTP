package com.smack17.rtp;

import java.util.Random;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class commandRtp implements CommandExecutor {

	// Gets new location for player to teleport to
    public Location getNewLocation(Player player) {
        Random r = new Random();
        FileConfiguration config = Main.plugin.getConfig();
        int radius = config.getInt("distance"); // Gets distance value from config
        int randomX = r.nextInt(radius); // Gets random value within the radius set in the config
        int randomZ = r.nextInt(radius);
        int posOrNeg = r.nextInt(4); // Picks one of the locations below
        
        // Locations on an x y plain
        Location locPlusPlus = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() + randomZ), player.getLocation().getZ() + (double)randomZ);
        Location locPlusMin = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() - randomZ), player.getLocation().getZ() - (double)randomZ);
        Location locMinPlus = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() + randomZ), player.getLocation().getZ() + (double)randomZ);
        Location locMinMin = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() - randomZ), player.getLocation().getZ() - (double)randomZ);
        
        // Choose what direction player will tp in and check if it is water. If so, will pick a new location
        switch(posOrNeg) {
        case 1:
        	while(locPlusPlus.getBlock().getType() == Material.WATER) {
            	player.sendMessage("[DEBUG] Nonsolid found. Getting new location...");
        		locPlusPlus = getNewLocation(player);
        	}
        		return locPlusPlus;
        case 2:
        	while(locPlusMin.getBlock().getType() == Material.WATER) {
            	player.sendMessage("[DEBUG] Nonsolid found. Getting new location...");
        		locPlusMin = getNewLocation(player);
        	}
        		return locPlusMin;
        case 3:
        	while(locMinPlus.getBlock().getType() == Material.WATER) {
            	player.sendMessage("[DEBUG] Nonsolid found. Getting new location...");
        		locMinPlus = getNewLocation(player);
        	}
        		return locMinPlus;
        case 4:
        	while(locMinMin.getBlock().getType() == Material.WATER) {
            	player.sendMessage("[DEBUG] Nonsolid found. Getting new location...");
        		locMinMin = getNewLocation(player);
        	}
        		return locMinMin;
        default:
        	while(locPlusPlus.getBlock().getType() == Material.WATER) {
            	player.sendMessage("[DEBUG] Nonsolid found. Getting new location...");
        		locPlusPlus = getNewLocation(player);
        	}
        		return locPlusPlus;
        	}
        }

    // Sends player to the location piched in getLocation()
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
    	// Check if command sender is instance of player
        if(sender instanceof Player) {
            Player player = (Player)sender;
            // Checks if player has the correct permissions
            if(player.hasPermission("rtp.rtp")) {
                Location tpLocation = getNewLocation(player); // Get teleport location
                World world = player.getWorld(); // Get world the player is in
                world.getChunkAt((int)tpLocation.getX(), (int)tpLocation.getZ()).load(); // Loads chunk that the player will teleport to
                player.setVelocity(new Vector(0, 0, 0)); // Prevent fall damage
                player.teleport(tpLocation); // Teleport player
                player.sendMessage("\2478[\247bRTP\2478] \247aYou have been teleported!"); // Notify player that they have teleported
            } 
            else {
                player.sendMessage("\2478[\247bRTP\2478] \247cYou do not have permission to use this!"); // Notify player that they dont have permission
            }
        }
        return true;
    }
}