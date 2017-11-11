package nyc.c4q.simonsays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhaimennoor on 11/10/17.
 */

public interface SimonSaysPresentation {
    void showGameExplanation();

    void showRoundNumber(int roundNumber);

    void showColors(List<SimonSaysColors> colors);

    void loseGame();
}
