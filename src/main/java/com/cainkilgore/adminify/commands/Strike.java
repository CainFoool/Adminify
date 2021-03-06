package com.cainkilgore.adminify.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cainkilgore.adminify.Adminify;
import com.cainkilgore.adminify.Messages;
import com.cainkilgore.adminify.Util;

public class Strike implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender s, Command c, String l, String [] args) {
//		if(l.equalsIgnoreCase("strike")) {
			if(!(s instanceof Player)) {
				Util.print(Messages.noConsole);
				return true;
			}
			
			Player player = (Player) s;
			
			if(!Util.hasPermission(player, "strike")) {
				Util.sendMessage(player, Messages.noPermission);
				return true;
			}
			
			if(args.length < 1) {
				player.getWorld().strikeLightning(player.getTargetBlock(null, 0).getLocation());
				return true;
			}
			
			Player argPlayer = Adminify.mainClass.getServer().getPlayer(args[0]);
			if(argPlayer == null) {
				Util.sendMessage(player, Messages.invalidPlayer);
				return true;
			}
			
			Util.strikePlayer(argPlayer);
			Util.sendMessage(player, Messages.strikePlayer.replace("{P}", argPlayer.getName()));
			Util.sendMessage(argPlayer, Messages.adminStrike.replace("{A}", player.getName()));
//		}
		return true;
	}

}
