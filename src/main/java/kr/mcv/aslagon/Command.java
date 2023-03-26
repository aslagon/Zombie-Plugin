package kr.mcv.aslagon;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

import static org.bukkit.Bukkit.getServer;


public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("zb")) {
            if (args.length == 1) {
                if (args[0].equals("reload")) {
                    getServer().shutdown();
                } else if (args[0].equals("start")) {
                    Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
                    Random random = new Random();
                    Player randomPlayer = players[random.nextInt(players.length)];
                    getServer().broadcastMessage(String.valueOf(randomPlayer));
                }
            } else {
                commandList((Player) sender);
            }
        }
        return false;

    }

    public void commandList(Player player) {
        player.sendMessage("/zb reload -> server shutdown and start");
    }
}
