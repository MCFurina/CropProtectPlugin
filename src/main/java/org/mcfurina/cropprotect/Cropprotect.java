package org.mcfurina.cropprotect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.block.Block;

public class Cropprotect extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("已启用!");
    }

    @Override
    public void onDisable() {
        getLogger().info("已禁用!");
    }

    // 阻止玩家踩踏耕地
    @EventHandler
    public void onFarmlandTrample(EntityChangeBlockEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.FARMLAND && event.getTo() == Material.DIRT) {
            event.setCancelled(true);
        }
    }
}