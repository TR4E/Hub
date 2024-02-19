package me.trae.hub.navigator.menus;

import me.trae.core.client.Client;
import me.trae.core.client.ClientManager;
import me.trae.core.menu.Button;
import me.trae.core.network.modules.ConnectPlayer;
import me.trae.core.network.modules.ServerInformation;
import me.trae.framework.shared.client.enums.Rank;
import me.trae.framework.shared.network.data.PlayerData;
import me.trae.framework.shared.network.data.ServerData;
import me.trae.framework.shared.utility.UtilFormat;
import me.trae.framework.shared.utility.enums.ChatColor;
import me.trae.hub.navigator.menus.interfaces.IServerButton;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ServerButton extends Button<ServerMenu> implements IServerButton {

    public ServerButton(final ServerMenu menu, final int slot, final ItemStack itemStack) {
        super(menu, slot, itemStack);
    }

    @Override
    public String getDisplayName() {
        return this.getGameType().getDisplayName();
    }

    @Override
    public String[] getLore() {
        final List<String> lore = new ArrayList<>();

        lore.add(ChatColor.DARK_GRAY + this.getGameType().getType());
        lore.add(" ");

        Arrays.asList(this.getGameType().getDescription()).forEach(line -> lore.add(ChatColor.setDefault(line, ChatColor.GRAY)));
        lore.add(" ");

        final ServerData serverData = this.getServerData();
        if (serverData != null) {
            lore.add(UtilFormat.pairString("Players Online", String.format("<green>%s</green>", serverData.getOnlinePlayers().size())));
            lore.add(UtilFormat.pairString("Server Version", String.format("<green>%s</green>", serverData.getVersion())));
            lore.add(" ");
        }

        lore.add(UtilFormat.pairString("Status", this.getServerStatus()));
        lore.add(" ");

        final Player player = Bukkit.getPlayer(this.getMenu().getUUID());

        if (this.canConnect(player, this.getInstance().getManagerByClass(ClientManager.class).getClientByPlayer(player))) {
            lore.add("<yellow>Click to Connect!</yellow>");
        } else {
            lore.add("<red>You cannot connect!</red>");
        }

        return lore.toArray(new String[0]);
    }

    @Override
    public void onClick(final Player player, final Client client, final ClickType clickType) {
        if (!(this.canConnect(player, client))) {
            return;
        }

        this.getNetworkManager().getModuleByClass(ConnectPlayer.class).execute(player, this.getServerType());
    }

    private boolean canConnect(final Player player, final Client client) {
        final ServerData serverData = this.getServerData();

        if (serverData != null && serverData.isOnline()) {
            if (serverData.isWhitelisted()) {
                if (client.getRank().ordinal() >= Rank.ADMIN.ordinal()) {
                    return true;
                }

                final PlayerData playerData = serverData.getPlayerByUUID(player.getUniqueId());
                if (playerData != null) {
                    return playerData.isWhitelisted() || playerData.isOperator();
                }
            } else {
                return true;
            }
        }

        return false;
    }

    private ServerData getServerData() {
        return this.getNetworkManager().getModuleByClass(ServerInformation.class).getServer(this.getServerType());
    }

    private String getServerStatus() {
        String status = "<red>Offline</red>";

        final ServerData serverData = this.getServerData();
        if (serverData != null) {
            status = "<green>Online</green>";

            if (serverData.isWhitelisted()) {
                status = "<gold>Whitelisted</gold>";
            }
        }

        return status;
    }
}