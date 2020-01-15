package com.smack17.rtp;

import java.util.Random;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class commandRtp implements CommandExecutor {

	// Gets new location for player to teleport to
    public Location getLocation(Player player) {
        Random r = new Random();
        FileConfiguration config = Main.plugin.getConfig();
        int radius = config.getInt("distance"); // Gets distance value from config
        int randomX = r.nextInt(radius); // Gets random value within the radius set in the config
        int randomZ = r.nextInt(radius);
        int posOrNeg = r.nextInt(4); // Picks one of the locations below
        
        // Locations on an x y plain
        Location locPlusPlus = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locPlusMin = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        Location locMinPlus = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locMinMin = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        
        // Gets locations 2 blocks below one of the 4 locations (to test if its water)
        Location locPlusPlusBelow = new Location(locPlusPlus.getWorld(), locPlusPlus.getX(), locPlusPlus.getY()-2, locPlusPlus.getZ());
        Location locPlusMinBelow = new Location(locPlusMin.getWorld(), locPlusMin.getX(), locPlusMin.getY()-2, locPlusMin.getZ());
        Location locMinPlusBelow = new Location(locMinPlus.getWorld(), locMinPlus.getX(), locMinPlus.getY()-2, locMinPlus.getZ());
        Location locMinMinBelow = new Location(locMinMin.getWorld(), locMinMin.getX(), locMinMin.getY()-2, locMinMin.getZ());
        
        // Checking if end location is water, and if so, pick a new location (may not work right now)
        switch(posOrNeg) {
        case 1:
            if(locPlusPlusBelow.getBlock().getType() == Material.WATER) {
            	System.out.println("Water found. Finding new location...");
                locPlusPlus = getLocation(player);
            }
            return locPlusPlus;

        case 2:
            if(locPlusMinBelow.getBlock().getType() == Material.WATER) {
            	System.out.println("Water found. Finding new location...");
                locPlusMin = getLocation(player);
            }
            return locPlusMin;

        case 3:
            if(locMinPlusBelow.getBlock().getType() == Material.WATER) {
            	System.out.println("Water found. Finding new location...");
                locMinPlus = getLocation(player);
            }
            return locMinPlus;

        case 4:
            if(locMinMinBelow.getBlock().getType() == Material.WATER) {
            	System.out.println("Water found. Finding new location...");
                locMinMin = getLocation(player);
            }
            return locMinMin;
        default:
            if(locPlusPlusBelow.getBlock().getType() == Material.WATER) {
            	System.out.println("Water found. Finding new location...");
                locPlusPlus = getLocation(player);
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
                Location tpLocation = getLocation(player); // Get players current location
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