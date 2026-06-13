package pixl.dev.spellweave.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellcastGUI {
    public void openSpellcastGUI(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9*5, "Spellcasting");

        // Filler item
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(null);
        filler.setItemMeta(fillerMeta);

        // Exit button
        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName(ChatColor.RED + "Exit");
        exit.setItemMeta(exitMeta);

        // Confirm button
        ItemStack confirm = new ItemStack(Material.EMERALD);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(ChatColor.GREEN + "Confirm Cast");
        confirm.setItemMeta(confirmMeta);

        // Spellcast picture buttons (clicked / red glass and not clicked / green glass)

            // Clicked
        ItemStack clicked = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta clickedMeta = clicked.getItemMeta();
        clickedMeta.setDisplayName(null);
        clicked.setItemMeta(clickedMeta);

            // Not clicked
        ItemStack notClicked = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta notClickedMeta = notClicked.getItemMeta();
        notClickedMeta.setDisplayName(null);
        notClicked.setItemMeta(notClickedMeta);

        // Arrangement of main GUI
            // Filler GUI
        inv.setItem(0, filler);
        inv.setItem(1, filler);
        inv.setItem(7, filler);
        inv.setItem(8, filler);
        inv.setItem(9, filler);
        inv.setItem(10, filler);
        inv.setItem(17, filler);
        inv.setItem(18, filler);
        inv.setItem(19, filler);
        inv.setItem(25, filler);
        inv.setItem(26, filler);
    }
}
