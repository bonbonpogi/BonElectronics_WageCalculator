package mcm.edu.ph.WageCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(this);
    }
    @Override
    public void onClick (View view){
        EditText workinghours = findViewById(R.id.txtWorkingHours);
        TextView totalhours = findViewById(R.id.txtTotalHrs);
        TextView totalwage = findViewById(R.id.txtTotalWage);
        TextView totalhoursovt = findViewById(R.id.txtTotalHrsOvt);
        TextView totalwageovt = findViewById(R.id.txtTotalWageOvt);

        double input = 0.0;
        double hours = 0.0;
        double wage = 0.0;
        double hours2 = 0.0;
        double wage2 = 0.0;

        input =  Double.parseDouble(workinghours.getText().toString());

        switch (view.getId()) {
            case R.id.btnCalculate:
                hours = input;
                totalhours.setText(Double.toString(hours) + "hours");
                if(input > 8) {
                    wage = ((input - 8) * 130) + 800;
                    totalwage.setText("P" + Double.toString(wage));
                }
                else {
                    wage = input * 100;
                    totalwage.setText("P" + Double.toString(wage));
                }
                if (input>8) {
                    hours2 = input - 8;
                    totalhoursovt.setText(Double.toString(hours2) + "hours");
                }
                else {
                    totalhoursovt.setText(Double.toString(0)+"hours");
                }
                if (input>8){
                    wage2 = (input-8)*130;
                    totalwageovt.setText("P"+Double.toString(wage2));

                }
                else{
                    totalwageovt.setText("P"+Double.toString(0));
                }
                break;
        }
    }

}