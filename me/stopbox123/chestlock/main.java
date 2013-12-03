package me.stopbox123.chestlock;

import me.stopbox123.chestlock.commands.AddFriend;
import me.stopbox123.chestlock.commands.LockChest;
import me.stopbox123.chestlock.listeners.ChestListener;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
        
        public void onEnable() {
                PluginManager pm = Bukkit.getPluginManager();
                LockChest lockchest = new LockChest();
                AddFriend addfriend = new AddFriend(lockchest);
                pm.registerEvents(new ChestListener(lockchest, addfriend), this);
                getCommand("lock").setExecutor(lockchest);
                getCommand("allow").setExecutor(addfriend);
        }

}