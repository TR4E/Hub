package me.trae.hub;

import me.trae.core.chat.ChatManager;
import me.trae.core.client.ClientManager;
import me.trae.core.command.CommandManager;
import me.trae.core.config.ConfigManager;
import me.trae.core.countdown.CountdownManager;
import me.trae.core.damage.DamageManager;
import me.trae.core.database.DatabaseManager;
import me.trae.core.death.DeathManager;
import me.trae.core.effect.EffectManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.gamer.GlobalGamerManager;
import me.trae.core.item.ItemManager;
import me.trae.core.menu.MenuManager;
import me.trae.core.network.NetworkManager;
import me.trae.core.player.PlayerManager;
import me.trae.core.recharge.RechargeManager;
import me.trae.core.redis.RedisManager;
import me.trae.core.scoreboard.ScoreboardManager;
import me.trae.core.server.ServerManager;
import me.trae.core.updater.UpdaterManager;
import me.trae.framework.shared.utility.enums.ChatColor;
import me.trae.hub.gamer.GamerManager;
import me.trae.hub.navigator.NavigatorManager;
import me.trae.hub.recipe.RecipeManager;
import me.trae.hub.world.WorldManager;

public class Hub extends SpigotPlugin {

    @Override
    public void registerManagers() {
        // Core
        addManager(new ChatManager(this));
        addManager(new ClientManager(this));
        addManager(new CommandManager(this));
        addManager(new ConfigManager(this));
        addManager(new CountdownManager(this));
        addManager(new DamageManager(this));
        addManager(new DatabaseManager(this));
        addManager(new DeathManager(this));
        addManager(new EffectManager(this));
        addManager(new GlobalGamerManager(this));
        addManager(new ItemManager(this, ChatColor.GREEN));
        addManager(new MenuManager(this));
        addManager(new NetworkManager(this));
        addManager(new PlayerManager(this));
        addManager(new RechargeManager(this));
        addManager(new RedisManager(this));
        addManager(new ScoreboardManager(this));
        addManager(new ServerManager(this));
        addManager(new UpdaterManager(this));

        // Hub
        addManager(new GamerManager(this));
        addManager(new NavigatorManager(this));
        addManager(new RecipeManager(this));
        addManager(new WorldManager(this));
    }
}