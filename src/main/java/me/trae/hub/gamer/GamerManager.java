package me.trae.hub.gamer;

import me.trae.core.framework.SpigotPlugin;
import me.trae.core.gamer.local.LocalGamerManager;
import me.trae.framework.shared.utility.objects.EnumData;
import me.trae.hub.gamer.enums.GamerProperty;

import java.util.UUID;

public class GamerManager extends LocalGamerManager<Gamer, GamerProperty, GamerRepository> {

    public GamerManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        super.registerModules();
    }

    @Override
    public Class<GamerRepository> getClassOfRepository() {
        return GamerRepository.class;
    }

    @Override
    public Gamer createGamerByUUID(final UUID uuid) {
        return new Gamer(uuid);
    }

    @Override
    public Gamer createGamerByData(final EnumData<GamerProperty> data) {
        return new Gamer(data);
    }
}