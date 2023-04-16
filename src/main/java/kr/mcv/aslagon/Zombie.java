package kr.mcv.aslagon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class Zombie extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("zb").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Location loc = player.getLocation();
                ArrayList<Entity> nearentities = new ArrayList<>();
                Collection<Entity> near = loc.getNearbyEntities(5, 5, 5);
                for (Entity tmpEntity : near) {
                    nearentities.add(tmpEntity);
                }
                for (Entity entity : nearentities) {
                    if (entity.getType().equals(EntityType.ZOMBIE) && entity.getCustomName().equals(ChatColor.RED + "KING ZOMBIE")) {
                        for (int i = 0; i < 5; i++) {
                            entity.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

                        }

                    } else {
                        break;
                    }
                }


            }
        }, 200L, 200L);
    }

    @Override
    public void onDisable() {

    }
}
