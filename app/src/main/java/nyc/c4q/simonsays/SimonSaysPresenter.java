package nyc.c4q.simonsays;

import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/**
 * Created by muhaimennoor on 11/10/17.
 */

public class SimonSaysPresenter {
    private ArrayList<SimonSaysColors> simonColors = new ArrayList<>();
    private Stack<SimonSaysColors> simonSaysColorsStack = new Stack<>();
    private Random r = new Random();
    private TextView rounds;
    private @Nullable
    SimonSaysPresentation presentation;
    private int roundNumber = 0;
    private boolean listeningToUserInput = false;

    public void attach(SimonSaysPresentation presentation) {
        this.presentation = presentation;
    }

    public void detach() {
        presentation = null;
    }

    public void onStartClicked() {
        if (presentation != null && roundNumber == 0) {
            presentation.showGameExplanation();
            goToNextRound();
        }
    }

    private void goToNextRound() {
        roundNumber++;
        presentation.showRoundNumber(roundNumber);
        generateNewColor();
    }

    private void generateNewColor() {
        int ordinal = r.nextInt(SimonSaysColors.values().length);
        SimonSaysColors nextColor = SimonSaysColors.values()[ordinal];
        simonColors.add(nextColor);

        if (presentation != null) {
            presentation.showColors(simonColors);
        }
    }


    public void onColorsShown() {
        this.listeningToUserInput = true;
        simonSaysColorsStack.clear();

        // Add colors to stack so that last color is in the bottom
        for (int i = simonColors.size() - 1; i >= 0; i--) {
            simonSaysColorsStack.add(simonColors.get(i));
        }
    }

    public void onColorClicked(SimonSaysColors userColor) {
        if (presentation != null && listeningToUserInput) {
            SimonSaysColors simonColor = simonSaysColorsStack.pop();
                if (simonColor != userColor) {
                    presentation.loseGame();
                    startNewGame();
                }

                // User got through all the colors, advance to next level
                if (simonSaysColorsStack.isEmpty()) {
                    goToNextRound();
                }
            }

            }



    private void startNewGame() {//created new methods

    }
}
