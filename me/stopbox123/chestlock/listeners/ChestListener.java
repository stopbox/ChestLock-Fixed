package me.stopbox123.chestlock.listeners;

import java.util.HashMap;

import me.stopbox123.chestlock.commands.AddFriend;
import me.stopbox123.chestlock.commands.LockChest;
import me.stopbox123.firework.ColorUtil;
import me.stopbox123.firework.FireWorksUtil;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestListener implements Listener {
	
        
        LockChest lockedcheck;
        AddFriend friend;
        
        public ChestListener(LockChest lockedcheck, AddFriend friend)
        {
                this.lockedcheck = lockedcheck;
                this.friend = friend;
        }
        
        @SuppressWarnings("unused")
		@EventHandler
        public void isLocked(PlayerInteractEvent e) throws Exception {
                if(e.getAction() != Action.RIGHT_CLICK_BLOCK)
                {
                        // There is no Block that we are interacting with
                        return;
                }
                if (e.getClickedBlock().getType() == Material.CHEST)
                { 
                        String owner = this.lockedcheck.locked.get(e.getClickedBlock().getLocation());
                        String friend = this.friend.friends.get(e.getClickedBlock().getLocation());
                        
                        // or if the interacting player isn't the owner
                 if (!owner.equals(e.getPlayer().getName()) || !friend.equals(e.getPlayer().getName()))
                 {
                	 
                 e.setCancelled(true);
                                 e.getPlayer().sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "ChestLock" + ChatColor.GRAY + "] " + ChatColor.AQUA + "You may not open that chest owned by " + lockedcheck.locked.get(e.getClickedBlock().getLocation()));

                                 
                 } 
              // Check if the block does not have an owner
                 if (owner == null) {
                	return; 
                 }
                }
        }
}