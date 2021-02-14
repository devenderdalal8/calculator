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

public class UnitFD extends AppCompatActivity {

    private EditText amount , rate , time;
    private TextView text ;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_fd);

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
                int p = Integer.parseInt(p1);
                double r = Double.parseDouble(r1);
                double t = Double.parseDouble(t1);

                double a = p * r * t;
                double b = a / 100;
                double c = (b + p);
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