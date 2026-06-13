package pixl.dev.spellweave.Main;

import org.bukkit.plugin.java.JavaPlugin;
import pixl.dev.spellweave.Commands.Commands;
import pixl.dev.spellweave.GUIs.SpellcastGUI;

public final class Main extends JavaPlugin {

    private SpellcastGUI gui;
    @Override
    public void onEnable() {
        // Plugin startup logic
        gui = new SpellcastGUI();
            // Command set
        getCommand("spellweave").setExecutor(new Commands(gui));
        getCommand("spellweave").setTabCompleter(new Commands(gui));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
