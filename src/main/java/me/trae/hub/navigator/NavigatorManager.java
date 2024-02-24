package me.trae.hub.navigator;

import me.trae.core.framework.SpigotManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.hub.navigator.commands.NavigatorCommand;
import me.trae.hub.navigator.modules.HandleNavigatorFunction;

public class NavigatorManager extends SpigotManager {

    public final String NAVIGATOR_TITLE = "<red><bold>Server Navigator";

    public NavigatorManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        // Commands
        addModule(new NavigatorCommand(this));

        // Modules
        addModule(new HandleNavigatorFunction(this));
    }
}