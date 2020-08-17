package me.sfclog.minigamepath;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import me.sfclog.minigamepath.event.RegisterEvent;
import net.md_5.bungee.api.ChatColor;


public class SFC_Main extends JavaPlugin{
	public static SFC_Main main;
	FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
	main = this;
	setupconfig();
	System.out.print(ChatColor.GREEN + "Plugin is enable !");
	getServer().getPluginManager().registerEvents(new RegisterEvent(), this);
	}
	private void setupconfig() {
       config.options().copyDefaults(true);
       saveConfig();	
	}
	@Override
	public void onDisable() {
	main = null;
	this.saveDefaultConfig();
	System.out.print(ChatColor.RED + "Plugin is disable !");	
	}
	
	
	public static void kick(Player p) {
		if(SFC_Main.main.config.getBoolean("kick_player")) {		
			p.kickPlayer(SFC_Main.main.config.getString("kick_msg"));
		}
		
	}

}
