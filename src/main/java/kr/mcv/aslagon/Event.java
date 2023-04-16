package kr.mcv.aslagon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;


public class Event implements Listener {
    public boolean kingzombietruefalse;
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        if (event.getLocation().getWorld().getName().equals("world")) {
            if (!(event.getEntityType().equals(EntityType.ZOMBIE))) {
                int EndermanSpawnRandom = random.nextInt(3);
                int SpawnRandom = random.nextInt(101);
                if (event.getEntityType().equals(EntityType.BLAZE) || event.getEntityType().equals(EntityType.ENDER_DRAGON) || event.getEntityType().equals(EntityType.ENDER_CRYSTAL) || event.getEntityType().equals(EntityType.VILLAGER) || event.getEntityType().equals(EntityType.DROPPED_ITEM) || event.getEntityType().equals(EntityType.FALLING_BLOCK) || event.getEntityType().equals(EntityType.ARROW) || event.getEntityType().equals(EntityType.SPECTRAL_ARROW) || event.getEntityType().equals(EntityType.TRIDENT) || event.getEntityType().equals(EntityType.ENDER_SIGNAL) || event.getEntityType().equals(EntityType.ENDER_PEARL) || event.getEntityType().equals(EntityType.EGG) || event.getEntityType().equals(EntityType.SNOWBALL)) {
                    event.setCancelled(false);
                } else if (event.getEntityType().equals(EntityType.ENDERMAN) && EndermanSpawnRandom == 1) {
                    event.setCancelled(false);
                } else if (event.getEntityType().equals(EntityType.SHEEP) || event.getEntityType().equals(EntityType.COW) || event.getEntityType().equals(EntityType.PIG)) {

                    event.setCancelled(IntStream.range(1, 11).noneMatch(x -> x == SpawnRandom));

                } else if (!(SpawnRandom == 1)) {
                    event.setCancelled(true);
                }
            } else {
                int ArmorRandom = random.nextInt(3);
                boolean ArmorBoolean = random.nextBoolean();
                int hundredRandom = random.nextInt(101);
                LivingEntity zombie = (LivingEntity) event.getEntity();
                zombie.setMaxHealth(200);
                zombie.setHealth(zombie.getMaxHealth());
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 2));








                if (ArmorBoolean) {
                    if (ArmorRandom == 1) {
                        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
                        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                        zombie.getEquipment().setHelmet(helmet);
                        zombie.getEquipment().setChestplate(chestplate);
                        zombie.getEquipment().setLeggings(leggings);
                        zombie.getEquipment().setBoots(boots);

                        if (IntStream.range(1, 21).noneMatch(x -> x == hundredRandom)) {
                            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                        } else if (IntStream.range(21, 41).noneMatch(x -> x == hundredRandom)) {
                            zombie.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 3));
                        } else if (hundredRandom == 1) {
                            zombie.setCustomName(ChatColor.RED + "KING ZOMBIE");
                            zombie.setCustomNameVisible(true);
                        }

                    } else if (ArmorRandom == 2) {
                        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
                        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
                        zombie.getEquipment().setHelmet(helmet);
                        zombie.getEquipment().setChestplate(chestplate);
                        zombie.getEquipment().setLeggings(leggings);
                        zombie.getEquipment().setBoots(boots);

                        if (IntStream.range(1, 21).noneMatch(x -> x == hundredRandom)) {
                            zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                        } else if (IntStream.range(21, 41).noneMatch(x -> x == hundredRandom)) {
                            zombie.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 3));
                        } else if (hundredRandom == 1) {
                            zombie.setCustomName(ChatColor.RED + "KING ZOMBIE");
                            zombie.setCustomNameVisible(true);
                        }
                    }
                } else if (IntStream.range(1, 21).noneMatch(x -> x == hundredRandom)) {
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
                } else if (IntStream.range(21, 41).noneMatch(x -> x == hundredRandom)) {
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 3));
                } else if (hundredRandom == 1) {
                    zombie.setCustomName(ChatColor.RED + "KING ZOMBIE");
                    zombie.setCustomNameVisible(true);
                }

            }
        } else {
            event.setCancelled(false);
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
//    @EventHandler
//    public void onChat(PlayerChatEvent event) {
//        event.setCancelled(true);
//        getServer().broadcastMessage(ChatColor.RED + "Someone chatted.");
//    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();
        String message = event.getMessage();

        ArrayList<Player> recipients = new ArrayList<>();

        for (Player otherPlayer : Bukkit.getServer().getOnlinePlayers()) {
            if (sender.getWorld() == otherPlayer.getWorld()) {
                if (otherPlayer != sender && sender.getLocation().distance(otherPlayer.getLocation()) <= 50) {
                    recipients.add(otherPlayer);
                } else if (otherPlayer != sender && sender.getLocation().distance(otherPlayer.getLocation()) > 50)
                    recipients.remove(otherPlayer);
            }
        }

        if (!recipients.isEmpty()) {
            recipients.add(sender);
            event.getRecipients().clear();
            event.getRecipients().addAll(recipients);
        } else {
            event.setCancelled(true);
            Bukkit.broadcastMessage(ChatColor.RED + "Someone chatted.");
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntityType() == EntityType.PLAYER && event.getEntity().getFallDistance() >= 5) {

            Player player = (Player) event.getEntity();

            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
        }
    }
}