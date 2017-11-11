package nyc.c4q.simonsays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button red;
    private Button yellow;
    private Button blue;
    private Button green;
    private Button start;
    private ArrayList<String> simon;
    private ArrayList<String> user;
    private boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fetchButtons();

        letMeKnowIfAllButtonsExist();
    }

    private void letMeKnowIfAllButtonsExist() {
        List<Button> buttons = Arrays.asList(red, green, blue, yellow);
        for (Button button : buttons) {
            String checking = button.getText().toString();
            Log.d("checkforgreen", checking);
        }
    }

    private void fetchButtons() {
        red = (Button) findViewById(R.id.red);
        green = (Button) findViewById(R.id.green);
        yellow = (Button) findViewById(R.id.button_Y);
        blue = (Button) findViewById(R.id.blue);
        start = (Button) findViewById(R.id.begin);
    }

    public void onStart() {
        super.onStart();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation lightup = new AlphaAnimation(1, 0);
                lightup.setDuration(3000);
                Toast.makeText(MainActivity.this, "Start button was clicked", Toast.LENGTH_SHORT).show();
                Random rnd = new Random();
                int[] randColor = {R.color.blue, R.color.green, R.color.red, R.color.yellow, R.color.pink};
                red.setBackground(blue.getBackground());
                red.startAnimation(lightup);
                yellow.setBackground(green.getBackground());
                //green.setBackgroundColor(getResources().getColor(R.color.pink));
            }
        });

        setupColorButtonClickListners();

//        listCheck(simon, user);
        gamePlay(simon, user);
    }

    private void setupColorButtonClickListners() {
        setOnClickListenerForAColorButton(blue, "Blue clicked");
        setOnClickListenerForAColorButton(red, "Red clicked");
        setOnClickListenerForAColorButton(yellow, "Yellow clicked");
        setOnClickListenerForAColorButton(green, "Green clicked");
    }

    private void setOnClickListenerForAColorButton(Button button, final String toast) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //    public boolean listCheck(ArrayList<String> simon, ArrayList<String> user) {
//            if(clicked){
//                Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
//                simon.add(green.getText().toString());
//                String checking = green.getText().toString();
//                Log.d("checkforgreen", checking);
//            }
//
//
//        return clicked;
//    }
    public boolean gamePlay(ArrayList<String> simon, ArrayList<String> user) {
        final Animation lightup = new AlphaAnimation(1, 0);
        lightup.setDuration(3000);
        Random simonChoice = new Random();
        int choice = simonChoice.nextInt(4);
        if (clicked) {


            switch (choice) {

                case 1:
                    simon.add(green.getText().toString());
                    lightup.setDuration(3000);
                    green.startAnimation(lightup);

                    break;
                case 2:
                    simon.add(red.getText().toString());
                    red.startAnimation(lightup);

                    break;
                case 3:
                    simon.add(yellow.getText().toString());
                    yellow.startAnimation(lightup);

                    break;
                case 4:
                    simon.add(blue.getText().toString());
                    blue.startAnimation(lightup);

                    break;
            }
        }

        return true;
    }


}


//TODO create button methods and logic, as well as key bindings, fields as well
//TODO XML needs to be properly adjusted and designed, color schema,
//TODO a second activity, that will be explicit intent, which will contain the Simon game
//and the main_activity will be the splash page