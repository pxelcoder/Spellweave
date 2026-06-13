package pixl.dev.spellweave.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import pixl.dev.spellweave.GUIs.SpellcastGUI;

public class ClickListener implements Listener {

    private SpellcastGUI gui;

    public ClickListener(SpellcastGUI gui) {
        this.gui = gui;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Spellcasting")) {
            if (e.getRawSlot()>=e.getView().getTopInventory().getSize()){
                return;
            }
            e.setCancelled(true);

            int slot = e.getRawSlot(); // gets slot # that was clicked

            if (e.getCurrentItem() != null) { // nullpointerexception my beloved
                Player player = (Player) e.getWhoClicked();

                if (gui.isClickInSpellweave(player,e)) { // toggles the spell to make it cool and epic
                    gui.toggleSpellweave(player,e);
                }
            }
        }
    }
}
