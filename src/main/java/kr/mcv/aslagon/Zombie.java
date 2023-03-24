package kr.mcv.aslagon;

import org.bukkit.plugin.java.JavaPlugin;

public class Zombie extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("zb").setExecutor(new Command());
    }

    @Override
    public void onDisable() {

    }
}
