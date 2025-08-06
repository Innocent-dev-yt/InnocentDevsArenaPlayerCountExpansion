package com.innocentdev.arena.arenaPlayerCountExpansion;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaPlayerCountExpansion extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("===========================================");
        getLogger().info("  IdSPAPCE");
        getLogger().info("  Author : InnocentDev");
        getLogger().info("  Version: " + getDescription().getVersion());
        getLogger().info("  Status : ENABLED");
        getLogger().info("===========================================");
        new ArenaPlayerCountPAPIExpansion(this).register();
        getLogger().info("PlaceholderAPI expansion registered successfully.");
        // Any other startup logic...
    }


    @Override
    public void onDisable() {
        getLogger().info("===========================================");
        getLogger().info("  IdSPAPCE");
        getLogger().info("  Status : DISABLED");
        getLogger().info("===========================================");
    }
}
