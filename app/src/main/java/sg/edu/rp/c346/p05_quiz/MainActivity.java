package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ow, rt;
    TextView tv;
    Button sub , mins, add;
    int pax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ow = (CheckBox) findViewById(R.id.checkBox);
        rt = (CheckBox) findViewById(R.id.checkBox1);
        sub = (Button) findViewById(R.id.button3);
        mins = (Button) findViewById(R.id.button);
        add = (Button) findViewById(R.id.button2);
        tv = (TextView) findViewById(R.id.textView2);

        if(ow.isChecked() && rt.isChecked())
        {
            Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_SHORT).show();
        }

        pax = Integer.parseInt(tv.getText().toString());

        if (pax <=0)
        {
            Toast.makeText(MainActivity.this,"Invalid input",Toast.LENGTH_SHORT).show();
        }

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pax++;
                String num = String.valueOf(pax);
                tv.setText(num);
            }
        });

        mins.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pax--;
                String num = String.valueOf(pax);
                tv.setText(num);
            }
        });



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ow.isChecked())
                {
                    Intent intent = new Intent(MainActivity.this,FlightDetails.class);
                    double price = 100 * pax;
                    intent.putExtra("cost",price);
                    intent.putExtra("type","One-Way Trip");
                    startActivity(intent);
                }

                if (rt.isChecked())
                {
                    Intent intents = new Intent(MainActivity.this,FlightDetails.class);
                    double costs = 100 * pax * 2;
                    intents.putExtra("cost",costs);
                    intents.putExtra("type","Round Trip");
                    startActivity(intents);
                }

            }
        });




    }
}
