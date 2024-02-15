package me.trae.hub.navigator.modules;

import me.trae.core.framework.types.SpigotListener;
import me.trae.core.item.ItemBuilder;
import me.trae.core.item.ItemManager;
import me.trae.core.item.events.ItemUpdateEvent;
import me.trae.core.utility.UtilEntity;
import me.trae.hub.navigator.NavigatorManager;
import me.trae.hub.navigator.menus.ServerMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class HandleNavigatorFunction extends SpigotListener<NavigatorManager> {

    public HandleNavigatorFunction(final NavigatorManager manager) {
        super(manager);
    }

    private ItemBuilder getItemBuilder() {
        return new ItemBuilder(new ItemStack(Material.COMPASS), this.getManager().NAVIGATOR_TITLE, null);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        UtilEntity.clearInventory(player);

        player.getInventory().setItem(4, this.getItemBuilder().toItemStack());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if (!(Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK).contains(event.getAction()))) {
            return;
        }

        final Player player = event.getPlayer();

        if (!(this.getInstance().getManagerByClass(ItemManager.class).isSimilar(player.getInventory().getItemInHand(), this.getItemBuilder().toItemStack()))) {
            return;
        }

        new ServerMenu(this.getManager(), player);
    }

    @EventHandler
    public void onItemUpdate(final ItemUpdateEvent event) {
        if (event.getBuilder().getItemStack().getType() != this.getItemBuilder().getItemStack().getType()) {
            return;
        }

        event.getBuilder().setDisplayName(this.getManager().NAVIGATOR_TITLE);
    }
}