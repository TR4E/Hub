package me.trae.hub.navigator.enums;

import me.trae.framework.shared.utility.enums.ChatColor;
import me.trae.hub.navigator.enums.interfaces.IGameType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum GameType implements IGameType {

    CLANS(
            "Clans",
            10,
            ChatColor.RED,
            new ItemStack(Material.TNT),
            "Team PvP",
            new String[]{
                    "Hide, Fight, Win.",
                    "",
                    "Create alliances as you battle your way",
                    "into the world of clans.",
                    "",
                    "Get your claim down quick in an",
                    "isolated place where no one can find you,",
                    "watch your back and defend your claims.",
                    "",
                    "PvP is the core of this game mode - not for the weak."
            }
    );

    private final String name;
    private final int slot;
    private final ChatColor chatColor;
    private final ItemStack itemStack;
    private final String type;
    private final String[] description;

    GameType(final String name, final int slot, final ChatColor chatColor, final ItemStack itemStack, final String type, final String[] description) {
        this.name = name;
        this.slot = slot;
        this.chatColor = chatColor;
        this.itemStack = itemStack;
        this.type = type;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSlot() {
        return this.slot;
    }

    @Override
    public ChatColor getChatColor() {
        return this.chatColor;
    }

    @Override
    public ItemStack getItemStack() {
        return this.itemStack;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String[] getDescription() {
        return this.description;
    }

    @Override
    public String getDisplayName() {
        return ChatColor.build(this.getChatColor(), ChatColor.BOLD) + this.getName();
    }
}