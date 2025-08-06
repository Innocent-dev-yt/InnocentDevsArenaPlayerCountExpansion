package com.innocentdev.arena.arenaPlayerCountExpansion;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ga.strikepractice.StrikePractice;
import ga.strikepractice.api.StrikePracticeAPI;
import ga.strikepractice.arena.Arena;

public class ArenaPlayerCountPAPIExpansion extends PlaceholderExpansion {

    private final JavaPlugin plugin;

    public ArenaPlayerCountPAPIExpansion(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "arena";
    }

    @Override
    public String getAuthor() {
        return "InnocentDev";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier == null || !identifier.endsWith("_count")) {
            return null;
        }

        String arenaName = identifier.substring(0, identifier.length() - 6); // Remove "_count"

        StrikePracticeAPI api = StrikePractice.getAPI();  // Get API instance via main plugin class
        if (api == null) {
            return null;
        }

        Arena arena = api.getArena(arenaName);
        if (arena == null) {
            return null;
        }

        Location corner1 = arena.getCorner1();
        Location corner2 = arena.getCorner2();

        if (corner1 == null || corner2 == null) {
            return null;
        }

        World world = corner1.getWorld();
        if (world == null) {
            return null;
        }

        double minX = Math.min(corner1.getX(), corner2.getX());
        double maxX = Math.max(corner1.getX(), corner2.getX());
        double minY = Math.min(corner1.getY(), corner2.getY());
        double maxY = Math.max(corner1.getY(), corner2.getY());
        double minZ = Math.min(corner1.getZ(), corner2.getZ());
        double maxZ = Math.max(corner1.getZ(), corner2.getZ());

        long count = Bukkit.getOnlinePlayers().stream()
                .filter(p -> p.getWorld().equals(world)
                        && p.getLocation().getX() >= minX && p.getLocation().getX() <= maxX
                        && p.getLocation().getY() >= minY && p.getLocation().getY() <= maxY
                        && p.getLocation().getZ() >= minZ && p.getLocation().getZ() <= maxZ)
                .count();

        return String.valueOf(count);
    }
}
