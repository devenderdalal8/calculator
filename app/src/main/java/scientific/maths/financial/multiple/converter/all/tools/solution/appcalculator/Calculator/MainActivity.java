package scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Calculator;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.R;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitConverter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        Intent i;
        if(view.getId()==R.id.button1)
        {
            Intent intent = new Intent(MainActivity.this, StandardCal.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button)
        {

            Intent intent = new Intent(MainActivity.this, ScientificCal.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.button2)
        {
            i=new Intent(MainActivity.this, UnitConverter.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}