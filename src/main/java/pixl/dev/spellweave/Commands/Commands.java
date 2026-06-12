package pixl.dev.spellweave.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;

public class Commands implements CommandExecutor, TabCompleter {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }

    public ArrayList<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> completions = new ArrayList<>();
        return completions;
    }
}
