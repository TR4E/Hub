package me.trae.hub.world.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.hub.world.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;

public class DisableBlockInteraction extends SpigotListener<WorldManager> {

    public DisableBlockInteraction(final WorldManager manager) {
        super(manager);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (!(Arrays.asList(Action.LEFT_CLICK_BLOCK, Action.RIGHT_CLICK_BLOCK).contains(event.getAction()))) {
            return;
        }

        if (this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(event.getPlayer()).isAdministrating()) {
            return;
        }

        event.setCancelled(true);
    }
}