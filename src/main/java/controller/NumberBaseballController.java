package controller;

import static utils.GameConstant.GAME_RESTART_OR_QUIT_PROMPT;
import static utils.GameConstant.GAME_START_MESSAGE;
import static utils.GameConstant.GAME_WIN_MESSAGE;

import model.system.GameController;
import view.InputView;
import view.OutputView;

public class NumberBaseballController {

    public static final String QUIT_GAME = "2";
    private final GameController gameController;

    public NumberBaseballController(GameController gameController) {
        this.gameController = gameController;
    }

    public void run() {
        OutputView.write(GAME_START_MESSAGE);
        while (true) {
            gameController.run();
            OutputView.write(GAME_WIN_MESSAGE);
            OutputView.write(GAME_RESTART_OR_QUIT_PROMPT);
            String input = InputView.readInput();
            if (input.equals(QUIT_GAME)) {
                return;
            }
        }
    }
}
