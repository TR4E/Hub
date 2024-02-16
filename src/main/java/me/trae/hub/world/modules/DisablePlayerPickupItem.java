package me.trae.hub.world.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.hub.world.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DisablePlayerPickupItem extends SpigotListener<WorldManager> {

    public DisablePlayerPickupItem(final WorldManager manager) {
        super(manager);
    }

    @EventHandler
    public void onPlayerPickupItem(final PlayerPickupItemEvent event) {
        if (this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(event.getPlayer()).isAdministrating()) {
            return;
        }

        event.setCancelled(true);
    }
}