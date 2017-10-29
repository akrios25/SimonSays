package nyc.c4q.simonsays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     //TODO create button methods and logic, as well as key bindings, fields as well
    //TODO XML needs to be properly adjusted and designed, color schema,
    //TODO a second activity, that will be explicit intent, which will contain the Simon game
    //and the main_activity will be the splash page.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
