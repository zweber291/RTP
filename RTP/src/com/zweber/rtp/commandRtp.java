package com.zweber.rtp;

import java.util.Random;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class commandRtp implements CommandExecutor {


    public Location getLocation(Player player) {
        Random r = new Random();
        int radius = 1000;
        int randomX = r.nextInt(radius);
        int randomZ = r.nextInt(radius);
        int posOrNeg = r.nextInt(4);
        Location locPlusPlus = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locPlusMin = new Location(player.getWorld(), player.getLocation().getX() + (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() + randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        Location locMinPlus = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() + randomZ) + 2, player.getLocation().getZ() + (double)randomZ);
        Location locMinMin = new Location(player.getWorld(), player.getLocation().getX() - (double)randomX, player.getWorld().getHighestBlockYAt((int)player.getLocation().getX() - randomX, (int)player.getLocation().getZ() - randomZ) + 2, player.getLocation().getZ() - (double)randomZ);
        
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

    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
        if(sender instanceof Player) {
            Player player = (Player)sender;
            if(player.hasPermission("rtp.rtp")) {
                Location tpLocation = getLocation(player);
                World world = player.getWorld();
                world.getChunkAt((int)tpLocation.getX(), (int)tpLocation.getZ()).load();
                player.setVelocity(new Vector(0, 0, 0));
                player.teleport(tpLocation);
                player.sendMessage("\2478[\247bNo\2477-\247bNamed\2477 \247bOrg\2478] \247aYou have been teleported!");
            } 
            else {
                player.sendMessage("\2478[\247bNo\2477-\247bNamed\2477 \247bOrg\2478] \247cYou do not have permission to use this!");
            }
        }
        return true;
    }
}