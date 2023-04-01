package kr.mcv.aslagon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Zombie extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("zb").setExecutor(new Command());
        Bukkit.getPluginManager().registerEvents(new Event(), this);
    }

    @Override
    public void onDisable() {

    }
}
