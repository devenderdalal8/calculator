package scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.R;

public class UnitEMI extends AppCompatActivity {

    private EditText amount , rate , time;
    private TextView text ;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_emi);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        amount = findViewById(R.id.amount);
        rate = findViewById(R.id.rate);
        time = findViewById(R.id.time);
        text = findViewById(R.id.result);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            String p1 = amount.getText().toString();
            String t1 = time.getText().toString();
            String r1 = rate.getText().toString();

            if (!TextUtils.isEmpty(p1) && !TextUtils.isEmpty(r1) && !TextUtils.isEmpty(t1)) {
                int p=Integer.parseInt(p1);
                double r=Double.parseDouble(r1);
                double t=Double.parseDouble(t1);
//                int t=Integer.parseInt(r1);
//                float s1 = ((1 + r) ^ t);
                double s1 = Math.pow((1 + r) , t);
                double a = p * r * s1;
                double b = (Math.pow((1 + r), t) - 1);
                double c = (a / b);
                float c1 = Float.parseFloat(String.valueOf(c));
                String d = String.valueOf(c1);
                text.setText(d);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }

}