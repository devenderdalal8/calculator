package scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.R;

public class UnitConverter extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.area);
        button.setOnClickListener(this);
        Button button2 = findViewById(R.id.length);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.weight);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.tempearture);
        button4.setOnClickListener(this);
        Button button5 = findViewById(R.id.emi);
        button5.setOnClickListener(this);
        Button button6 = findViewById(R.id.sip);
        button6.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        Intent i ;
        switch(v.getId())
        {
            case R.id.area:
                i=new Intent(UnitConverter.this,UnitArea.class);
                startActivity(i);
                break;
            case R.id.length:
                i=new Intent(UnitConverter.this,UnitLength.class);
                startActivity(i);
                break;
            case R.id.weight:
                i=new Intent(UnitConverter.this,UnitWeight.class);
                startActivity(i);
                break;
            case R.id.tempearture:
                i=new Intent(UnitConverter.this,UnitTemperature.class);
                startActivity(i);
                break;
            case R.id.emi:
                i=new Intent(UnitConverter.this, UnitEMI.class);
                i.putExtra("name", "UnitEMI");
                startActivity(i);
                break;
            case R.id.sip:
                i=new Intent(UnitConverter.this,UnitSIP.class);
                startActivity(i);
                break;

            case R.id.fd:
                i=new Intent(UnitConverter.this,UnitFD.class);
                startActivity(i);
                break;
            case R.id.loan:
                i=new Intent(UnitConverter.this,UnitLoan.class);
                startActivity(i);
                break;

        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }


}
