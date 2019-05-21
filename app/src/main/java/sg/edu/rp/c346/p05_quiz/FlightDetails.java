package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {

    TextView type, cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        type = (TextView) findViewById(R.id.textView3);
        cost = (TextView)findViewById(R.id.textView2);

        Intent intentReceived = getIntent();
        String modes = intentReceived.getStringExtra("type");
        double price = intentReceived.getDoubleExtra("cost",0);
        type.setText("You have selected " + modes);
        cost.setText("Your air ticket costs $ " + price);

    }
}
