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

public class UnitSIP extends AppCompatActivity {
    private EditText amount , crate , erate, time;
    private TextView text ;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_sip);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        amount = findViewById(R.id.amount);
        erate = findViewById(R.id.expectedrate);
        crate = findViewById(R.id.comprate);
        time = findViewById(R.id.time);

        text = findViewById(R.id.result);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> {
            String p1 = amount.getText().toString();
            String t1 = time.getText().toString();
            String r1 = crate.getText().toString();
            String r2 = erate.getText().toString();

            if (!TextUtils.isEmpty(p1) && !TextUtils.isEmpty(r1) && !TextUtils.isEmpty(t1)&& !TextUtils.isEmpty(r2)) {
                int p=Integer.parseInt(p1);
                double cr=Double.parseDouble(r1);
                double er=Double.parseDouble(r2);
                double t=Double.parseDouble(t1);

                double s1 = Math.pow((1 + cr) , (t-1));
                double a = p * er * s1;
                double b = a/cr;
                double c = (b * (1+cr));
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