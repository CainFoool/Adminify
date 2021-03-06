package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Adm implements CommandExecutor {
	
	boolean ownerOnline = false;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("adminify")) {
			if(!(s instanceof Player)) {
				try {
					Util.print(Messages.author);
					Util.print(Messages.version + Adminify.mainClass.getDescription().getVersion());
					Util.print(Messages.url);
					Util.print(Messages.supportURL);
					
					for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
						if(online.getName().equalsIgnoreCase("ThatJavaGuy")) {
							ownerOnline = true;
						}
					}
					
					if(ownerOnline) {
						Util.print(Messages.coderOnline);
					}
				} catch (Exception e) {
					Util.print(Messages.error);
				}
				return true;
			}
			
			Player player = (Player) s;
			
			Util.sendMessage(player, Messages.author);
			Util.sendMessage(player, Messages.version + Adminify.mainClass.getDescription().getVersion());
			Util.sendMessage(player, Messages.url);
			Util.sendMessage(player, Messages.supportURL);
			
			for(Player online : Adminify.mainClass.getServer().getOnlinePlayers()) {
				if(online.getName().equalsIgnoreCase("ThatJavaGuy")) {
					ownerOnline = true;
				}
			}
			
			if(ownerOnline) {
				Util.sendMessage(player, Messages.coderOnline);
			}
			
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("reload")) {
					if(!Util.hasPermission(player, "reload")) {
						Util.sendMessage(player, Messages.noPermission);
						return true;
					}
					Adminify.mainClass.reloadConfig();
					Util.sendMessage(player, Messages.reloaded);
				}
				return true;
			}
//		}
		return true;
	}

}
