package baseball;

import controller.NumberBaseballController;
import model.system.GameController;
import model.system.GameStarter;
import model.system.GameTerminator;
import view.InputView;
import view.OutputView;
import view.processing.Convertor;
import view.processing.Validator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameStarter(), new GameTerminator());
        InputView inputView = new InputView(new Convertor(), new Validator());
        NumberBaseballController numberBaseBallController = new NumberBaseballController(gameController,
            inputView, new OutputView());
        numberBaseBallController.run();
    }
}
