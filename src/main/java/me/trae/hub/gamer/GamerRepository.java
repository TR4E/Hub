package me.trae.hub.gamer;

import me.trae.core.gamer.local.LocalGamerRepository;
import me.trae.hub.gamer.enums.GamerProperty;

public class GamerRepository extends LocalGamerRepository<GamerManager, Gamer, GamerProperty> {

    public GamerRepository(final GamerManager manager) {
        super(manager);
    }
}