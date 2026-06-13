package pixl.dev.spellweave.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import pixl.dev.spellweave.GUIs.SpellcastGUI;

import java.util.ArrayList;

public class Commands implements CommandExecutor, TabCompleter {
    private SpellcastGUI gui;

    public Commands(SpellcastGUI gui){
        this.gui = gui;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // EXAMPLE COMMAND
        if (cmd.getName().equalsIgnoreCase("example")) {
            if ((args.length == 0) && (sender instanceof Player)) {
                gui.openSpellcastGUI((Player) sender);
            }
        }
        return true;
    }

    public ArrayList<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("example");
        }
        return completions;
    }
}
