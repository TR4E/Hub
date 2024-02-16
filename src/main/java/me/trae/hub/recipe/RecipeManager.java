package me.trae.hub.recipe;

import me.trae.core.framework.SpigotPlugin;
import me.trae.hub.recipe.modules.DisableRecipeCraft;

public class RecipeManager extends me.trae.core.recipe.RecipeManager {

    public RecipeManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        super.registerModules();

        addModule(new DisableRecipeCraft(this));
    }
}