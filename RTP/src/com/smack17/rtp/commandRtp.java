package com.zweber.rtp;

import java.util.Random;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class commandRtp implements CommandExecutor {

	// Gets new location for player to teleport to
    public Location getLocation(Player player) {
        Random r = new Random();
        int radius = 1000;
        int randomX = r.nextInt(radius);
        int randomZ = r.nextInt(radius);
        int posOrNeg = r.nextInt(4);
        
        // Locations on an x y plain
        Location locPlusPlus = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locPlusMin = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        Location locMinPlus = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locMinMin = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        
        // Choosing which of the 4 locations to use. Also checks for ocean biome (doesnt work yet)
        switch(posOrNeg) {
        case 1:
            if(locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.COLD_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_COLD_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_FROZEN_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_LUKEWARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_WARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.FROZEN_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.LUKEWARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.WARM_OCEAN) {
                locPlusPlus = getLocation(player);
            }
            return locPlusPlus;

        case 2:
            if(locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.COLD_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.DEEP_COLD_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.DEEP_FROZEN_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.DEEP_LUKEWARM_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.DEEP_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.DEEP_WARM_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.FROZEN_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.LUKEWARM_OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.OCEAN || locPlusMin.getWorld().getBiome(locPlusMin.getBlockX(), locPlusMin.getBlockZ()) == Biome.WARM_OCEAN) {
                locPlusMin = getLocation(player);
            }
            return locPlusMin;

        case 3:
            if(locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.COLD_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.DEEP_COLD_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.DEEP_FROZEN_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.DEEP_LUKEWARM_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.DEEP_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.DEEP_WARM_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.FROZEN_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.LUKEWARM_OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.OCEAN || locMinPlus.getWorld().getBiome(locMinPlus.getBlockX(), locMinPlus.getBlockZ()) == Biome.WARM_OCEAN) {
                locMinPlus = getLocation(player);
            }
            return locMinPlus;

        case 4:
            if(locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.COLD_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.DEEP_COLD_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.DEEP_FROZEN_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.DEEP_LUKEWARM_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.DEEP_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.DEEP_WARM_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.FROZEN_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.LUKEWARM_OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.OCEAN || locMinMin.getWorld().getBiome(locMinMin.getBlockX(), locMinMin.getBlockZ()) == Biome.WARM_OCEAN) {
                locMinMin = getLocation(player);
            }
            return locMinMin;
        default:
            if(locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.COLD_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_COLD_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_FROZEN_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_LUKEWARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.DEEP_WARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.FROZEN_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.LUKEWARM_OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.OCEAN || locPlusPlus.getWorld().getBiome(locPlusPlus.getBlockX(), locPlusPlus.getBlockZ()) == Biome.WARM_OCEAN) {
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
                player.sendMessage("\2478[\247bNo\2477-\247bNamed\2477 \247bOrg\2478] \247aYou have been teleported!"); // Notify player that they have teleported
            } 
            else {
                player.sendMessage("\2478[\247bNo\2477-\247bNamed\2477 \247bOrg\2478] \247cYou do not have permission to use this!"); // Notify player that they dont have permission
            }
        }
        return true;
    }
}