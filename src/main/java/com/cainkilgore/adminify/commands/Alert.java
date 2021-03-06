package com.cainkilgore.adminify.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;


public class Alert implements CommandExecutor {
	
	public Alert() {
		// return "alert";
	}
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
		if(!(s instanceof Player)) {
			try {
				StringBuilder x = new StringBuilder();
				for(int i = 0; i < args.length; i++) {
					x.append(args[i] + " ");
				}
				
				for(int i = 0; i < 12; i++) {
					Util.broadcastUnformatted("");
				}
				
				Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=========================");
				Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.RED + 								   "                 ALERT          ");
				Util.broadcastUnformatted(x.toString());
				Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=========================");
				
				Util.delayChat(4);
				
				for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
					online.playSound(online.getLocation(), Sound.WITHER_SPAWN, 5, 5);
				}
			} catch (Exception e) {
				Util.print(Messages.error);
			}
			return true;
		}
		
		Player player = (Player) s;
		
		if(!Util.hasPermission(player, "alert")) {
			Util.sendMessage(player, Messages.noPermission);
			return true;
		}
		
		if(args.length < 1) {
			Util.sendMessage(player, Messages.invalidArguments);
			Util.sendMessage(player, Util.getCommandUsage(l));
			return true;
		}
		
		StringBuilder x = new StringBuilder();
		for(int i = 0; i < args.length; i++) {
			x.append(args[i] + " ");
		}
		
		for(int i = 0; i < 12; i++) {
			Util.broadcastUnformatted("");
		}
		
		Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=========================");
		Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.RED + 								   "                 ALERT          ");
		Util.broadcastUnformatted(x.toString());
		Util.broadcastUnformatted(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.STRIKETHROUGH + "=========================");
		
		Util.delayChat(4);
		
		for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
			online.playSound(online.getLocation(), Sound.WITHER_SPAWN, 5, 5);
		}
		return true;
	}

}
