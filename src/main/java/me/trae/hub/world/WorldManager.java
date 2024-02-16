package me.trae.hub.world;

import me.trae.core.framework.SpigotPlugin;
import me.trae.core.world.modules.DisableSaturation;
import me.trae.core.world.modules.DisableWeather;
import me.trae.hub.world.modules.*;

public class WorldManager extends me.trae.core.world.WorldManager {

    public WorldManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        super.registerModules();

        // Core
        addModule(new DisableSaturation(this));
        addModule(new DisableWeather(this));

        // Hub
        addModule(new DisableBlockInteraction(this));
        addModule(new DisableEntityDamage(this));
        addModule(new DisableInventoryInteract(this));
        addModule(new DisablePlayerDropItem(this));
        addModule(new DisablePlayerPickupItem(this));
    }
}