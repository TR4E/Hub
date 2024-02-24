package me.trae.hub;

import me.trae.core.Core;
import me.trae.core.chat.ChatManager;
import me.trae.core.client.ClientManager;
import me.trae.core.command.CommandManager;
import me.trae.core.config.ConfigManager;
import me.trae.core.countdown.CountdownManager;
import me.trae.core.damage.DamageManager;
import me.trae.core.database.DatabaseManager;
import me.trae.core.death.DeathManager;
import me.trae.core.donation.global.GlobalDonationManager;
import me.trae.core.donation.local.LocalDonationManager;
import me.trae.core.effect.EffectManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.gamer.global.GlobalGamerManager;
import me.trae.core.item.ItemManager;
import me.trae.core.menu.MenuManager;
import me.trae.core.network.NetworkManager;
import me.trae.core.perk.PerkManager;
import me.trae.core.player.PlayerManager;
import me.trae.core.recharge.RechargeManager;
import me.trae.core.redis.RedisManager;
import me.trae.core.scoreboard.ScoreboardManager;
import me.trae.core.server.ServerManager;
import me.trae.core.updater.UpdaterManager;
import me.trae.hub.gamer.GamerManager;
import me.trae.hub.navigator.NavigatorManager;
import me.trae.hub.recipe.RecipeManager;
import me.trae.hub.world.WorldManager;

public class Hub extends SpigotPlugin {

    @Override
    public void registerManagers() {
        addManager(new GamerManager(this));
        addManager(new NavigatorManager(this));
        addManager(new RecipeManager(this));
        addManager(new WorldManager(this));
    }

    @Override
    public void registerFactories() {
        addFactory(new Core() {
            @Override
            public boolean loadOnStart() {
                return true;
            }

            @Override
            public void registerManagers() {
                addManager(ChatManager.class);
                addManager(ClientManager.class);
                addManager(CommandManager.class);
                addManager(ConfigManager.class);
                addManager(CountdownManager.class);
                addManager(DamageManager.class);
                addManager(DatabaseManager.class);
                addManager(DeathManager.class);
                addManager(GlobalDonationManager.class);
                addManager(LocalDonationManager.class);
                addManager(EffectManager.class);
                addManager(GlobalGamerManager.class);
                addManager(ItemManager.class);
                addManager(MenuManager.class);
                addManager(NetworkManager.class);
                addManager(PerkManager.class);
                addManager(PlayerManager.class);
                addManager(RechargeManager.class);
                addManager(me.trae.core.recipe.RecipeManager.class);
                addManager(RedisManager.class);
                addManager(ScoreboardManager.class);
                addManager(ServerManager.class);
                addManager(UpdaterManager.class);
                addManager(me.trae.core.world.WorldManager.class);
            }
        });
    }
}