package me.stopbox123.chestlock.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddFriend implements CommandExecutor {

	public HashMap<Location, String> friends = new HashMap<Location, String>();
	
	public LockChest lockedcheck;
	
	public AddFriend(LockChest lockedcheck) {
		this.lockedcheck = lockedcheck;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("allow")) {
			if (!(sender instanceof Player)) {
				return false;
			}
			Player p = (Player)sender;
			 @SuppressWarnings("deprecation")
             Block b = p.getTargetBlock(null, 10);
			 String owner = lockedcheck.locked.get(b.getLocation());
			 if (b.getType() == Material.CHEST) {	
			 if (owner.equals(p.getName())) {
				 lockedcheck.locked.put(b.getLocation(), args[0]);
				 p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "You have added player " + args[0]);
			 } else {
				 p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "This not your chest so no!");
			 }
			 }
		
		return false;
	}
		
		return false;
		}
}
