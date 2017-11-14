package nyc.c4q.simonsays;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static nyc.c4q.simonsays.SimonSaysColors.BLUE;
import static nyc.c4q.simonsays.SimonSaysColors.GREEN;
import static nyc.c4q.simonsays.SimonSaysColors.RED;
import static nyc.c4q.simonsays.SimonSaysColors.YELLOW;

public class MainActivity extends AppCompatActivity implements SimonSaysPresentation {
    private View red;
    private View yellow;
    private View blue;
    private View green;
    private TextView rounds;

    private SimonSaysPresenter presenter= new SimonSaysPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        red = findViewById(R.id.red);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onColorClicked(RED);
            }
        });

        green = findViewById(R.id.green);

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onColorClicked(GREEN);
            }
        });

        yellow = findViewById(R.id.yellow);

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onColorClicked(YELLOW);
            }
        });

        blue = findViewById(R.id.blue);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onColorClicked(BLUE);
            }
        });

        rounds = (TextView) findViewById(R.id.rounds);

        rounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStartClicked();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.attach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.detach();
    }

    @Override
    public void showGameExplanation() {
        Toast.makeText(this,"watch the button pattern and repeat!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRoundNumber(int roundNumber) {
        rounds.setText("Round: " + roundNumber);
    }

    @Override
    public void showColors(List<SimonSaysColors> colors) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList<Animator> animators = new ArrayList<>();

        for (SimonSaysColors color : colors) {
            View viewToAnimate = findViewForColor(color);
            ObjectAnimator animator = ObjectAnimator.ofFloat(viewToAnimate, "alpha", 1f, 0f, 1f);
            animator.setDuration(1000);
            animators.add(animator);
        }

        animatorSet.playSequentially(animators);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation, boolean isReverse) {

            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
            }

            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Toast.makeText(MainActivity.this, "On Animation End", Toast.LENGTH_SHORT).show();
                presenter.onColorsShown();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }

    @Override
    public void loseGame() {

    }

    private View findViewForColor(SimonSaysColors color) {
        switch (color) {
            case RED:
                return red;
            case GREEN:
                return green;
            case YELLOW:
                return yellow;
            case BLUE:
                return blue;
            default:
                return null;
        }
    }
}
