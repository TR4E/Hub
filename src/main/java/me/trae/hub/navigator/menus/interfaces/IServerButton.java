package me.trae.hub.navigator.menus.interfaces;

import me.trae.framework.shared.utility.enums.ServerType;
import me.trae.hub.navigator.enums.GameType;

public interface IServerButton {

    ServerType getServerType();

    GameType getGameType();
}