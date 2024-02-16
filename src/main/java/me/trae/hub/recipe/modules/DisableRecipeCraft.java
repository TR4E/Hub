package me.trae.hub.recipe.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.core.recipe.events.RecipeCraftEvent;
import me.trae.hub.recipe.RecipeManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class DisableRecipeCraft extends SpigotListener<RecipeManager> {

    public DisableRecipeCraft(final RecipeManager manager) {
        super(manager);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onRecipeCraft(final RecipeCraftEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(event.getPlayer()).isAdministrating()) {
            return;
        }

        event.setCancelled(true);
    }
}