package scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Data.DBHelper;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Data.ExtendedDoubleEvaluator;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Data.History;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.R;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitArea;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitConverter;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitEMI;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitFD;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitLength;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitLoan;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitSIP;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitTemperature;
import scientific.maths.financial.multiple.converter.all.tools.solution.appcalculator.Unit.UnitWeight;

public class StandardCal extends AppCompatActivity implements View.OnClickListener {

    private EditText e1,e2;
    private int count=0;
    private String expression="";
    private DBHelper dbHelper;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_cal);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        e1 = findViewById(R.id.editText1);
        e2 = findViewById(R.id.editText2);
        dbHelper = new DBHelper(this);
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setItemIconTintList(null);
        nv.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent;
            switch (id) {
                case R.id.area:
                    intent = new Intent(StandardCal.this, UnitArea.class);
                    startActivity(intent);
                    break;
                case R.id.length:
                    intent = new Intent(StandardCal.this, UnitLength.class);
                    startActivity(intent);
                    break;
                case R.id.weight:
                    intent = new Intent(StandardCal.this, UnitWeight.class);
                    startActivity(intent);
                    break;
                case R.id.tempearture:
                    intent = new Intent(StandardCal.this, UnitTemperature.class);
                    startActivity(intent);
                    break;
                case R.id.emi:
                    intent = new Intent(StandardCal.this, UnitEMI.class);
                    intent.putExtra("name", "UnitEMI");
                    startActivity(intent);
                    break;
                case R.id.sip:
                    intent = new Intent(StandardCal.this, UnitSIP.class);
                    startActivity(intent);
                    break;

                case R.id.fd:
                    intent = new Intent(StandardCal.this, UnitFD.class);
                    startActivity(intent);
                    break;
                case R.id.loan:
                    intent = new Intent(StandardCal.this, UnitLoan.class);
                    startActivity(intent);
                    break;

            }
            return true;
        });
    }

    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.num0:
                e2.setText(e2.getText()+"0");
                break;

            case R.id.num1:
                e2.setText(e2.getText()+"1");
                break;

            case R.id.num2:
                e2.setText(e2.getText()+"2");
                break;

            case R.id.num3:
                e2.setText(e2.getText()+"3");
                break;


            case R.id.num4:
                e2.setText(e2.getText()+"4");
                break;

            case R.id.num5:
                e2.setText(e2.getText()+"5");
                break;

            case R.id.num6:
                e2.setText(e2.getText()+"6");
                break;

            case R.id.num7:
                e2.setText(e2.getText()+"7");
                break;

            case R.id.num8:
                e2.setText(e2.getText()+"8");
                break;

            case R.id.num9:
                e2.setText(e2.getText()+"9");
                break;

            case R.id.dot:
                if(count==0 && e2.length()!=0)
                {
                    e2.setText(e2.getText()+".");
                    count++;
                }
                break;

            case R.id.clear:
                e1.setText("");
                e2.setText("");
                count=0;
                expression="";
                break;

            case R.id.backSpace:
                String text = e2.getText().toString();
                if(text.length()>0)
                {
                    if(text.endsWith("."))
                    {
                        count=0;
                    }
                    String newText= text.substring(0, text.length()-1);
                    //to delete the data contained in the brackets at once
                    if(text.endsWith(")"))
                    {
                        char []a= text.toCharArray();
                        int pos=a.length-2;
                        int counter=1;
                        //to find the opening bracket position
                        for(int i=a.length-2;i>=0;i--)
                        {
                            if(a[i]==')')
                            {
                                counter++;
                            }
                            else if(a[i]=='(')
                            {
                                counter--;
                            }
                            //if decimal is deleted b/w brackets then count should be zero
                            else if(a[i]=='.')
                            {
                                count=0;
                            }
                            //if opening bracket pair for the last bracket is found
                            if(counter==0)
                            {
                                pos=i;
                                break;
                            }
                        }
                        newText= text.substring(0,pos);
                    }
                    //if e2 edit text contains only - sign or sqrt at last then clear the edit text e2
                    if(newText.equals("-")||newText.endsWith("sqrt"))
                    {
                        newText="";
                    }
                    //if pow sign is left at the last
                    else if(newText.endsWith("^"))
                        newText=newText.substring(0,newText.length()-1);

                    e2.setText(newText);
                }
                break;

            case R.id.plus:
                operationClicked("+");
                break;

            case R.id.minus:
                operationClicked("-");
                break;

            case R.id.divide:
                operationClicked("/");
                break;

            case R.id.multiply:
                operationClicked("*");
                break;

            case R.id.sqrt:
                if(e2.length()!=0)
                {
                    text =e2.getText().toString();
                    e2.setText("sqrt(" + text + ")");
                }
                break;

            case R.id.square:
                if(e2.length()!=0)
                {
                    text =e2.getText().toString();
                    e2.setText("("+ text +")^2");
                }
                break;

            case R.id.posneg:
                if(e2.length()!=0)
                {
                    String s=e2.getText().toString();
                    char arr[]=s.toCharArray();
                    if(arr[0]=='-')
                        e2.setText(s.substring(1,s.length()));
                    else
                        e2.setText("-"+s);
                }
                break;

            case R.id.equal:
                /*for more knowledge on DoubleEvaluator and its tutorial go to the below link
                http://javaluator.sourceforge.net/en/home/*/
                if(e2.length()!=0)
                {
                    text =e2.getText().toString();
                    expression=e1.getText().toString()+ text;
                }
                e1.setText("");
                if(expression.length()==0)
                    expression="0.0";
                DoubleEvaluator evaluator = new DoubleEvaluator();
                try
                {
                    //evaluate the expression
                    Double result = new ExtendedDoubleEvaluator().evaluate(expression);
                    //insert expression and result in sqlite database if expression is valid and not 0.0
                    if(!expression.equals("0.0"))
                        dbHelper.insert("STANDARD",expression+" = "+ result);
                    e2.setText(result +"");
                }
                catch (Exception e)
                {
                    e2.setText("Invalid Expression");
                    e1.setText("");
                    expression="";
                    e.printStackTrace();
                }
                break;

            case R.id.openBracket:
                e1.setText(e1.getText()+"(");
                break;

            case R.id.closeBracket:
                e1.setText(e1.getText()+")");
                break;

            case R.id.history:
                Intent i=new Intent(this, History.class);
                i.putExtra("calcName","STANDARD");
                startActivity(i);
                break;
            case R.id.intent:
                Intent intent = new Intent(this, ScientificCal.class);
                intent.putExtra("calcName", "SCIENTIFIC CALCULATOR");
                startActivity(intent);
                break;
        }
    }

    private void operationClicked(String op) {
        if(e2.length()!=0)
        {
            String text=e2.getText().toString();
            e1.setText(e1.getText() + text+op);
            e2.setText("");
            count=0;
        }
        else
        {
            String text=e1.getText().toString();
            if(text.length()>0)
            {
                String newText=text.substring(0,text.length()-1)+op;
                e1.setText(newText);
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (t.onOptionsItemSelected(item)) {

            return false;
        }

        return super.onOptionsItemSelected(item);
    }

}
