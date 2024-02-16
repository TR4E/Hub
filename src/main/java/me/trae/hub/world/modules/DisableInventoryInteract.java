package me.trae.hub.world.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.framework.shared.utility.UtilJava;
import me.trae.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DisableInventoryInteract extends SpigotListener<WorldManager> {

    public DisableInventoryInteract(final WorldManager manager) {
        super(manager);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(final InventoryClickEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getWhoClicked() instanceof Player && this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(UtilJava.cast(Player.class, event.getWhoClicked())).isAdministrating()) {
            return;
        }

        event.setCancelled(true);
    }
}