package me.trae.hub.navigator.enums;

import me.trae.framework.shared.utility.enums.ChatColor;
import me.trae.hub.navigator.enums.interfaces.IGameType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum GameType implements IGameType {

    CLANS(
            "Clans",
            11,
            ChatColor.RED,
            new ItemStack(Material.TNT),
            "Factions Survival",
            new String[]{
                    "Hide. Fight. War. Win",
                    "",
                    "Fight in this medieval land with Champions classes to",
                    "take over as much territory as you can, and besiege",
                    "as many Clans as you can before they destroy you."
            }
    ),
    ARCADE(
            "Arcade",
            13,
            ChatColor.AQUA,
            new ItemStack(Material.NOTE_BLOCK),
            "Minigames",
            new String[0]
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