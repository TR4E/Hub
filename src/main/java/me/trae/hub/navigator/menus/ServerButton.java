package me.trae.hub.navigator.menus;

import me.trae.core.client.Client;
import me.trae.core.menu.Button;
import me.trae.core.network.NetworkManager;
import me.trae.core.network.modules.ConnectPlayer;
import me.trae.framework.shared.utility.enums.ChatColor;
import me.trae.hub.navigator.menus.interfaces.IServerButton;
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

        // TODO: 15/02/2024 - Server Data (Players Online, Whitelisted, Server Version?)

        lore.add(ChatColor.YELLOW + "Click to Connect");

        return lore.toArray(new String[0]);
    }

    @Override
    public void onClick(final Player player, final Client client, final ClickType clickType) {
        if (!(this.canConnect(player, client))) {
            return;
        }

        this.getInstance().getManagerByClass(NetworkManager.class).getModuleByClass(ConnectPlayer.class).execute(player, this.getServerType());
    }

    private boolean canConnect(final Player player, final Client client) {
        return true;
    }
}