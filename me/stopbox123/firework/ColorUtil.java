package me.stopbox123.firework;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;

public class ColorUtil {
	
	public static FireworkEffect Locked() {
		return FireworkEffect.builder().with(Type.BALL).withColor(Color.RED).build();
		}

}
