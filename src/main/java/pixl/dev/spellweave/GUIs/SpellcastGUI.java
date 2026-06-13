package pixl.dev.spellweave.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellcastGUI {

    private ItemStack clicked = new ItemStack(Material.RED_STAINED_GLASS_PANE);
    private ItemStack notClicked = new ItemStack(Material.LIME_STAINED_GLASS_PANE);;

    public void openSpellcastGUI(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9*5, "Spellcasting");

        // Filler item
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
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
        ItemMeta clickedMeta = clicked.getItemMeta();
        clickedMeta.setDisplayName(" ");
        clicked.setItemMeta(clickedMeta);

            // Not clicked
        ItemMeta notClickedMeta = notClicked.getItemMeta();
        notClickedMeta.setDisplayName(" ");
        notClicked.setItemMeta(notClickedMeta);

        // Arrangement of main GUI
            // Filler GUI
        inv.setItem(0, filler);
        inv.setItem(1, filler);
        inv.setItem(7, filler);
        inv.setItem(8, filler);
        inv.setItem(9, filler);
        inv.setItem(10, filler);
        inv.setItem(16, filler);
        inv.setItem(17, filler);
        inv.setItem(18, filler);
        inv.setItem(19, filler);
        inv.setItem(25, filler);
        inv.setItem(26, filler);
        inv.setItem(27, filler);
        inv.setItem(28, filler);
        inv.setItem(34, filler);
        inv.setItem(35, filler);
        inv.setItem(36, filler);
        inv.setItem(37, filler);
        inv.setItem(43, filler);
        inv.setItem(44, filler);

            // Clickable material
        inv.setItem(2,notClicked);
        inv.setItem(3, notClicked);
        inv.setItem(4, notClicked);
        inv.setItem(5, notClicked);
        inv.setItem(6, notClicked);
        inv.setItem(11, notClicked);
        inv.setItem(12, notClicked);
        inv.setItem(13, notClicked);
        inv.setItem(14, notClicked);
        inv.setItem(15, notClicked);
        inv.setItem(20, notClicked);
        inv.setItem(21, notClicked);
        inv.setItem(22, notClicked);
        inv.setItem(23, notClicked);
        inv.setItem(24, notClicked);
        inv.setItem(29, notClicked);
        inv.setItem(30, notClicked);
        inv.setItem(31, notClicked);
        inv.setItem(32, notClicked);
        inv.setItem(33, notClicked);

            // confirm button
        inv.setItem(39, confirm);

            // exit button
        inv.setItem(41, exit);

        // Opens inventory
        p.openInventory(inv);
    }
    public boolean[][] getWeavedSpell(Player p){
        Inventory inv = p.getOpenInventory().getTopInventory();

        boolean[][] pattern = new boolean[4][5];
        int[][] slotnums = {
                {2, 3, 4, 5, 6},
                {11,12,13,14,15},
                {20,21,22,23,24},
                {29,30,31,32,33},
        };

        for (int row=0;row<slotnums.length;row++){
            for (int col=0;col<slotnums[row].length;col++){
                ItemStack item = inv.getItem(slotnums[row][col]);

                // Checks if material in that slot has red stained glass (aka is clicked) and isnt nothing
                pattern[row][col] = item != null && item.getType()==Material.RED_STAINED_GLASS_PANE;
            }
        }


        return pattern;
    }

    public void toggleSpellweave(Player p, InventoryClickEvent e){ // For when the spellweave is clicked
        if (isClickInSpellweave(p,e)){
            int index = e.getRawSlot();
            if (p.getOpenInventory().getItem(index).isSimilar(notClicked)) {
                p.getOpenInventory().getTopInventory().setItem(index, clicked);
            }
            else if (p.getOpenInventory().getItem(index).isSimilar(clicked)) {
                p.getOpenInventory().getTopInventory().setItem(index, notClicked);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }
    public boolean isClickInSpellweave(Player p, InventoryClickEvent e){ // for when checking to toggleSpellWeave in clicklistener
        if ((e.getCurrentItem().isSimilar(notClicked))||(e.getCurrentItem().isSimilar(clicked))){
            return true;
        }
        return false;
    }
    public String isSpellweave(Player p){ // Checks if the Spellweave matches preexisting spells
        // Checks using SpellManager

    }
}
