package me.trae.hub.world.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.hub.world.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DisablePlayerDropItem extends SpigotListener<WorldManager> {

    public DisablePlayerDropItem(final WorldManager manager) {
        super(manager);
    }

    @EventHandler
    public void onPlayerDropItem(final PlayerDropItemEvent event) {
        if (this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(event.getPlayer()).isAdministrating()) {
            return;
        }

        event.setCancelled(true);
    }
}