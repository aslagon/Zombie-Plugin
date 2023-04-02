package kr.mcv.aslagon;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;
import java.util.stream.IntStream;


public class Event implements Listener {
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        if (!(event.getEntityType().equals(EntityType.ZOMBIE))) {
            int EndermanSpawnRandom = random.nextInt(3);
            int SpawnRandom = random.nextInt(101);
            if (event.getEntityType().equals(EntityType.BLAZE) || event.getEntityType().equals(EntityType.ENDER_DRAGON) || event.getEntityType().equals(EntityType.ENDER_CRYSTAL) || event.getEntityType().equals(EntityType.VILLAGER) || event.getEntityType().equals(EntityType.DROPPED_ITEM) || event.getEntityType().equals(EntityType.FALLING_BLOCK) || event.getEntityType().equals(EntityType.ARROW) || event.getEntityType().equals(EntityType.SPECTRAL_ARROW) || event.getEntityType().equals(EntityType.TRIDENT) || event.getEntityType().equals(EntityType.ENDER_SIGNAL) || event.getEntityType().equals(EntityType.ENDER_PEARL) || event.getEntityType().equals(EntityType.EGG) || event.getEntityType().equals(EntityType.SNOWBALL)) {
                event.setCancelled(false);
            }
            else if (event.getEntityType().equals(EntityType.ENDERMAN) && EndermanSpawnRandom == 1) {
                event.setCancelled(false);
            }
            else if (event.getEntityType().equals(EntityType.SHEEP) || event.getEntityType().equals(EntityType.COW) || event.getEntityType().equals(EntityType.PIG)) {

                event.setCancelled(IntStream.range(1, 10).noneMatch(x -> x == SpawnRandom));

            }
            else if (!(SpawnRandom == 1)) {
                event.setCancelled(true);
            }
        } else {
            int ArmorRandom = random.nextInt(3);
            boolean ArmorBoolean = random.nextBoolean();
            LivingEntity zombie = (LivingEntity) event.getEntity();
            zombie.setMaxHealth(80);
            zombie.setHealth(zombie.getMaxHealth());
            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
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
    public void onEntityCombust(EntityCombustEvent event) {
        if (event.getEntityType().equals(EntityType.ZOMBIE)) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().getType() == EntityType.ZOMBIE && event.getEntity().getType() == EntityType.PLAYER) {
            Random random = new Random();
            int EffectRandom = random.nextInt(6);

            if (EffectRandom == 1) {
                Player player = (Player) event.getEntity();
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
            }
            else if (EffectRandom == 2) {
                Player player = (Player) event.getEntity();
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 2));
            }

        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        event.setDeathMessage(ChatColor.RED + "Someone died.");
    }
}