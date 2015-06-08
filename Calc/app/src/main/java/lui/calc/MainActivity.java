package lui.calc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends ActionBarActivity {
    public int total = 0;
    String operation = "";
    String text = "";
    boolean opFinished = false;
    boolean op1Done = false;
    boolean operationGiven = false;
    int op1 =  0;
    int op2 = 0;
    String strOp1 = "";
    String strOp2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        String bText = button.getText().toString();
        TextView myTextView = (TextView) findViewById(R.id.textView);
        if(opFinished){
            opFinished = false;
            text = "";
            op1Done = false;
            total = 0;
            strOp1 = "";
            strOp2 = "";
        }
        myTextView.setText(text);
        //if we're still on the first number
        if(!op1Done){
            strOp1 += bText;
            text += bText;
        }

        else{
            strOp2 += bText;
            text += bText;
        }

        myTextView.append(bText);
    }

    public void equalsOp(View v) {
        //Button button = (Button) v;
        //Log.i("info", "equalsOp first line");
        op1 = Integer.parseInt(strOp1);
        op2 = Integer.parseInt(strOp2);
        if (operation.equals("+")) {
            total = op1 + op2;
           // Log.i("info", "equalsOp addition");
        }
        if (operation.equals("-")) {
            total = op1 - op2;
        }

        if (operation.equals("x")) {
            total = op1 * op2;
        }
        if (operation.equals("/")) {
            total = op1 / op2;
        }

        TextView myTextView = (TextView)findViewById(R.id.textView);
        myTextView.setText(Integer.toString(total));
        opFinished = true;

    }

    public void operation(View v){
        Button button = (Button) v;
        operation = button.getText().toString();
        TextView myTextView = (TextView) findViewById(R.id.textView);
        text += operation;
        myTextView.append(button.getText().toString());
        operationGiven = true;
        op1Done = true;
    }

    public void clearTotal(View v){
        total = 0;
        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText("");
        op1 = 0;
        op2 = 0;
        op1Done = false;
        operationGiven = false;
        strOp1 = "";
        strOp2 = "";

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
