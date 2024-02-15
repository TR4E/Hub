package me.trae.hub.navigator.enums.interfaces;

import me.trae.framework.shared.utility.enums.ChatColor;
import org.bukkit.inventory.ItemStack;

public interface IGameType {

    String getName();

    int getSlot();

    ChatColor getChatColor();

    ItemStack getItemStack();

    String getType();

    String[] getDescription();

    String getDisplayName();
}