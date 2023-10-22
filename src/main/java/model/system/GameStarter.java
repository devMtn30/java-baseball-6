package model.system;

import static utils.GameConstant.INPUT_PROMPT_MESSAGE;

import java.util.List;
import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.referee.Referee;
import utils.BaseballNumberUtils;
import view.InputView;
import view.OutputView;

public class GameStarter {

    public GameStarter() {
    }

    public GameScoreboard start(Computer computer) {
        GameScoreboard gameScoreboard = new GameScoreboard();
        OutputView.write(INPUT_PROMPT_MESSAGE);
        String input = InputView.readInput();
        if (BaseballNumberUtils.isValidBaseballNumber(input)) {
            List<Integer> baseballNumber = BaseballNumberUtils.createBaseballNumber(input);
            User user = User.create(baseballNumber);
            Referee referee = Referee.create(user, computer);
            gameScoreboard = referee.JudgeBaseBallGame();
            OutputView.write(gameScoreboard);
        }
        return gameScoreboard;
    }

}
