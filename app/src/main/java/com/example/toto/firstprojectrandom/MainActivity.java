package com.example.toto.firstprojectrandom;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
 private  int num1;
    private int num2;
    Button tryagain  ;

    TextView txtwin  ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tryagain = (Button) findViewById(R.id.winbutton);
        Button tryagain=(Button)findViewById(R.id.winbutton);
        tryagain.setVisibility(View.INVISIBLE);
        txtwin =(TextView)findViewById(R.id.txtwin);
        randomnumber();


    }

    private void randomnumber( ) {
        Random randomnum=new Random();
        num1=randomnum.nextInt(1000);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


public void buttonclick(View view){
chektherandom(view);


}

    private void chektherandom(View view) {
        EditText txt=(EditText)findViewById(R.id.numbertxt);

        String strnum=txt.getText().toString();

 if(strnum.isEmpty()){

     Toast.makeText(this, "Please enter the number in text", Toast.LENGTH_LONG).show();
 }
 else {
     num2 = Integer.parseInt(strnum);

     int minus = Math.abs(num1 - num2);
     if (minus <= 5 && minus > 0) {
         Toast.makeText(this, "The number is very close ", Toast.LENGTH_LONG).show();
     } else if (num1 > num2) {

         Toast.makeText(this, "Your number Smaller than Random ", Toast.LENGTH_LONG).show();
     } else if (num1 < num2) {

         Toast.makeText(this, "Your number bigger than random  ", Toast.LENGTH_LONG).show();
     } else {

         Toast.makeText(this, "You win", Toast.LENGTH_LONG).show();
         txtwin.setText("**You win ** If you wont to Play Again please tab the button");
         tryagain.setVisibility(View.VISIBLE);



     }


     txt.setText("");


 }

    }

    public void Playagain(View view) {
        randomnumber();
        txtwin.setVisibility(View.INVISIBLE);
        tryagain.setVisibility(View.INVISIBLE);
    }
}
