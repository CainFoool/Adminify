package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Snowman implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("snowman")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "snowman")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(!Util.isSnowman(player)) {
				Util.setSnowman(player, true);
				Util.sendMessage(player, Messages.isSnowman);
				return true;
			}
			
			Util.setSnowman(player, false);
			Util.sendMessage(player, Messages.noSnowman);
//		}
		return true;
	}

}
