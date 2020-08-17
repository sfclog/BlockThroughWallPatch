package me.sfclog.minigamepath.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.sfclog.minigamepath.SFC_Main;
import me.sfclog.minigamepath.util.BlockPathFinder;


public class RegisterEvent implements Listener  {

	
    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent e) {
     Player p = e.getPlayer();
          if ((e.getBlock().getLocation().distance(p.getPlayer().getEyeLocation()) > 2)
             && !BlockPathFinder.line(p.getPlayer().getEyeLocation(), e.getBlock().getLocation()).contains(e.getBlock()) && !e.isCancelled()) {      
        	 SFC_Main.kick(p);
             e.setCancelled(true);
          }
    }
     @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPlace(BlockPlaceEvent e) {
          Player p = e.getPlayer();
            if ((e.getBlock().getLocation().distance(p.getPlayer().getEyeLocation()) > 2)
             && !BlockPathFinder.line(p.getPlayer().getEyeLocation(), e.getBlock().getLocation()).contains(e.getBlock()) && !e.isCancelled()) {
             SFC_Main.kick(p);
             e.setCancelled(true);
          }
    }
     @EventHandler(priority = EventPriority.HIGH)
    public void onInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.CHEST || e.getClickedBlock().getType() == Material.TRAPPED_CHEST || e.getClickedBlock().getType() == Material.ENDER_CHEST) {
                Player p = e.getPlayer();
                if ((e.getClickedBlock().getLocation().distance(p.getPlayer().getEyeLocation()) > 2)
                        && !BlockPathFinder.line(p.getPlayer().getEyeLocation(), e.getClickedBlock().getLocation()).contains(e.getClickedBlock()) && !e.isCancelled()) {
                	    SFC_Main.kick(p);
                        e.setCancelled(true);
                }
            }
        }
    }
}
