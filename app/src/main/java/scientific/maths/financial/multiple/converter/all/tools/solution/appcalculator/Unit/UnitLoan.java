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

public class UnitLoan extends AppCompatActivity {
    private EditText amount , rate , time;
    private TextView text ;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_loan);

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
                double r2=Double.parseDouble(r1);
                double t=Double.parseDouble(t1);
                double r = r2 / 1200;

                double s1 = Math.pow((1 + r) , t);
                double a = (p / r) * (1-(1/s1));
                float c = Float.parseFloat(String.valueOf(a));
                String d = String.valueOf(c);
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