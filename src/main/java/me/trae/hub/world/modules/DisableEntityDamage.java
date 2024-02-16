package me.trae.hub.world.modules;

import me.trae.core.client.ClientManager;
import me.trae.core.damage.events.CustomDamageEvent;
import me.trae.core.framework.types.SpigotListener;
import me.trae.hub.world.WorldManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageEvent;

public class DisableEntityDamage extends SpigotListener<WorldManager> {

    public DisableEntityDamage(final WorldManager manager) {
        super(manager);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCustomDamage(final CustomDamageEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (!(event.getDamagee() instanceof Player) && event.getCause() == EntityDamageEvent.DamageCause.VOID) {
            return;
        }

        if (event.getDamager() instanceof Player && this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(event.getDamagerCasted(Player.class)).isAdministrating()) {
            return;
        }

        event.setCancelled("No Damage in Hub");
    }
}