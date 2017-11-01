package nyc.c4q.simonsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    private Button red;
    private Button yellow;
    private Button blue;
    private Button green;
    private Button start;
    private final String Tag="TestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                final Animation lightup= new AlphaAnimation(1,0);
                lightup.setDuration(3000);
                Toast.makeText(MainActivity.this, "Start button was clicked", Toast.LENGTH_SHORT).show();
                Random rnd= new Random();
                int[] randColor={R.color.blue,R.color.green,R.color.red,R.color.yellow,R.color.pink};
                red.setBackground(blue.getBackground());
                red.startAnimation(lightup);
                yellow.setBackground(green.getBackground());
                green.setBackgroundColor(getResources().getColor(R.color.pink));
            }
        });
    }

}

















//TODO create button methods and logic, as well as key bindings, fields as well
//TODO XML needs to be properly adjusted and designed, color schema,
//TODO a second activity, that will be explicit intent, which will contain the Simon game
//and the main_activity will be the splash page