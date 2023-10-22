package model.system;

import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;

public final class GameController {

    private final GameStarter gameStarter;

    public GameController(GameStarter gameStarter, GameTerminator gameTerminator) {
        this.gameStarter = gameStarter;
    }

    public GameScoreboard run(User user, Computer computer) {
        GameScoreboard gameScoreboard = gameStarter.start(computer, user);
        return gameScoreboard;
    }


}
