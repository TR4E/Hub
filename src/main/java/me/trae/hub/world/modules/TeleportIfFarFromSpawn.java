package me.trae.hub.world.modules;

import me.trae.core.framework.types.SpigotUpdater;
import me.trae.core.utility.UtilServer;
import me.trae.framework.shared.updater.annotations.Update;
import me.trae.hub.world.WorldManager;
import org.bukkit.entity.Player;

public class TeleportIfFarFromSpawn extends SpigotUpdater<WorldManager> {

    public TeleportIfFarFromSpawn(final WorldManager manager) {
        super(manager);
    }

    @Update(delay = 500L)
    public void onUpdate() {
        for (final Player player : UtilServer.getOnlinePlayers()) {
            if (player.getWorld().getSpawnLocation().distance(player.getLocation()) < 100.0D) {
                continue;
            }

            player.teleport(player.getWorld().getSpawnLocation());
        }
    }
}