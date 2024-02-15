package me.trae.hub.navigator.menus;

import me.trae.core.client.Client;
import me.trae.core.menu.Menu;
import me.trae.framework.shared.utility.enums.ServerType;
import me.trae.hub.navigator.NavigatorManager;
import me.trae.hub.navigator.enums.GameType;
import org.bukkit.entity.Player;

public class ServerMenu extends Menu<NavigatorManager> {

    public ServerMenu(final NavigatorManager manager, final Player player) {
        super(manager, player, 27, manager.NAVIGATOR_TITLE);
    }

    @Override
    public void fillPage(final Player player, final Client client) {
        for (final GameType gameType : GameType.values()) {
            final ServerType serverType = ServerType.getByName(gameType.name());
            if (serverType == null) {
                continue;
            }

            addButton(new ServerButton(this, gameType.getSlot(), gameType.getItemStack()) {
                @Override
                public ServerType getServerType() {
                    return serverType;
                }

                @Override
                public GameType getGameType() {
                    return gameType;
                }
            });
        }
    }
}