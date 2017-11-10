package nyc.c4q.simonsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View red;
    private View yellow;
    private View blue;
    private View green;
    private TextView rounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        yellow = findViewById(R.id.yellow);
        blue = findViewById(R.id.blue);
        rounds = (TextView) findViewById(R.id.rounds);
    }

}
