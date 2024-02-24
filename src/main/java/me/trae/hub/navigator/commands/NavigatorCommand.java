package me.trae.hub.navigator.commands;

import me.trae.core.client.Client;
import me.trae.core.command.types.PlayerCommand;
import me.trae.framework.shared.client.enums.Rank;
import me.trae.framework.shared.gamer.global.types.GlobalGamer;
import me.trae.hub.navigator.NavigatorManager;
import me.trae.hub.navigator.menus.ServerMenu;
import org.bukkit.entity.Player;

public class NavigatorCommand extends PlayerCommand<NavigatorManager> {

    public NavigatorCommand(final NavigatorManager manager) {
        super(manager, "navigator", new String[0], Rank.DEFAULT);
    }

    @Override
    public String getDescription() {
        return "Open Menu of Servers";
    }

    @Override
    public void execute(final Player player, final Client client, final GlobalGamer globalGamer, final String[] args) {
        new ServerMenu(this.getManager(), player);
    }
}