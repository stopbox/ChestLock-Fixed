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

public class LockChest implements CommandExecutor {
        
        public HashMap<Location, String> locked = new HashMap<Location, String>();

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                if (cmd.getName().equalsIgnoreCase("lock")) {
                        if (!(sender instanceof Player)) {
                                sender.sendMessage("Players can only do this!");
                                return false;
                        }
                        Player p = (Player)sender;
                        @SuppressWarnings("deprecation")
                        Block b = p.getTargetBlock(null, 10);
                        if (b.getType() == Material.CHEST) {
                                if (locked.containsKey(b.getLocation()) == true) {
                                        p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "That chest is locked all ready by " + locked.get(b.getLocation()));
                                } else {
                                        locked.put(b.getLocation(), p.getName());
                                        p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "That Chest is now locked!");
                                        System.out.println(b.getLocation());
                                        System.out.println(locked.keySet());
        
                                }
                                }
                        }
                
                return false;
        }

}
