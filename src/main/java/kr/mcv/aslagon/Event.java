package kr.mcv.aslagon;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

import static org.bukkit.Bukkit.getLogger;


public class Event implements Listener {
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        if (event.getEntityType() != EntityType.ZOMBIE) {
            event.setCancelled(true);
            getLogger().info(String.valueOf(event.getEntityType()));
        } else {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());

            int ArmorRandom = random.nextInt(3);
            boolean ArmorBoolean = random.nextBoolean();
            LivingEntity zombie = (LivingEntity) event.getEntity();
            if (ArmorBoolean) {
                if (ArmorRandom == 1) {
                    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                    ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.IRON_BOOTS);
                    zombie.getEquipment().setHelmet(helmet);
                    zombie.getEquipment().setChestplate(chestplate);
                    zombie.getEquipment().setLeggings(leggings);
                    zombie.getEquipment().setBoots(boots);
                } else if (ArmorRandom == 2) {
                    ItemStack helmet = new ItemStack(Material.GOLDEN_HELMET);
                    ItemStack chestplate = new ItemStack(Material.GOLDEN_CHESTPLATE);
                    ItemStack leggings = new ItemStack(Material.GOLDEN_LEGGINGS);
                    ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS);
                    zombie.getEquipment().setHelmet(helmet);
                    zombie.getEquipment().setChestplate(chestplate);
                    zombie.getEquipment().setLeggings(leggings);
                    zombie.getEquipment().setBoots(boots);
                }
            }

        }
    }

    @EventHandler
    public void onEntityDamage(EntityCombustEvent event) {
        if (event.getEntityType() == EntityType.ZOMBIE) {
            event.setCancelled(true);
        }
    }
}
