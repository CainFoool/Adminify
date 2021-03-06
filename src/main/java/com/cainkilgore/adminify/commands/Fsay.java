package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Fsay implements CommandExecutor {
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("fsay")) {
			if(!(s instanceof Player)) {
				try {
					Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
					if(argPlayer == null) {
						Util.print(Messages.invalidPlayer);
						return true;
					}
					
					StringBuilder x = new StringBuilder();
					for(int i = 1; i < args.length; i++) {
						x.append(args[i] + " ");
					}
					
					argPlayer.chat(x.toString());
				} catch (Exception e) {
					Util.print(Messages.error);
				}
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "fsay")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}

			if(args.length < 2) {
				Util.sendMessage(player, Messages.invalidArguments);
				Util.sendMessage(player, Util.getCommandUsage(l));
				return true;
			}
			
			Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			StringBuilder x = new StringBuilder();
			for(int i = 1; i < args.length; i++) {
				x.append(args[i] + " ");
			}
			
			argPlayer.chat(x.toString());
//		}
		return true;
	}

}
