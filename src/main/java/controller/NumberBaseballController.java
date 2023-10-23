package controller;

import static utils.GameConstant.INPUT_PROMPT_MESSAGE;
import static utils.GameConstant.QUIT_GAME;

import java.util.List;
import model.player.Computer;
import model.player.User;
import model.referee.GameScoreboard;
import model.system.GameController;
import utils.BaseballNumberUtils;
import view.InputView;
import view.OutputView;

public class NumberBaseballController {

    private final GameController gameController;
    private final InputView inputView;
    private final OutputView outputView;

    public NumberBaseballController(GameController gameController, InputView inputView, OutputView outputView) {
        this.gameController = gameController;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.startGame();
        do {
            Computer computer = setupGame();
            playGame(computer);
        } while (!isUserWantToQuit());
    }

    private void playGame(Computer computer) {
        List<Integer> userBaseballNumber = getUserBaseballNumber();
        User user = User.create(userBaseballNumber);
        GameScoreboard gameScoreboard = gameController.run(user, computer);
        outputView.hint(gameScoreboard.getStrike(), gameScoreboard.getBall());
        if (gameController.isRunning(gameScoreboard)) {
            playGame(computer);
            return;
        }
        outputView.missonClear();
    }

    private boolean isUserWantToQuit() {
        String input = inputView.readInput();
        return input.equals(QUIT_GAME);
    }

    private List<Integer> getUserBaseballNumber() {
        outputView.write(INPUT_PROMPT_MESSAGE);
        List<Integer> numbers = inputView.readInputNumbers();
        return numbers;
    }

    private Computer setupGame() {
        List<Integer> randomNumbers = BaseballNumberUtils.createRandomNumbers();
        return Computer.create(randomNumbers);
    }
}
