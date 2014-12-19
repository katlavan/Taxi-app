package com.app.taxi.myTaxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.app.taxi.myTaxi.R;


public class MainActivity extends Activity {



    private TextView orderFrom;
    private TextView orderTo;
    private TextView orderNumber;


    private CheckBox checkWithFriend;
    private CheckBox checkWithAnimal;
    private CheckBox checkWith5ppl;
    private CheckBox checkWithWeapon;

    private EditText PhoneNumberEntry;
    private Toast toastInfoCheck;

    PhoneNumberFormattingTextWatcher PhoneWatcher = new PhoneNumberFormattingTextWatcher();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PhoneNumberEntry = (EditText) findViewById(R.id.textMain_number);
        PhoneNumberEntry.addTextChangedListener(PhoneWatcher);

        orderFrom =(TextView) findViewById(R.id.textMain_from);
        orderTo =(TextView) findViewById(R.id.textMain_to);
        orderNumber =(TextView) findViewById(R.id.textMain_number);
        orderNumber.setText("+380639810577");

        checkWithFriend = (CheckBox) findViewById(R.id.drunkFriend);
        checkWithAnimal = (CheckBox) findViewById(R.id.checkBox2);
        checkWith5ppl = (CheckBox) findViewById(R.id.checkBox3);
        checkWithWeapon = (CheckBox) findViewById(R.id.checkBox4);

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendDataFromMainToConfirm(View view){
        Intent intent = new Intent(getApplicationContext(),Confirm_after_order.class);

        intent.putExtra("From",orderFrom.getText().toString());
        intent.putExtra("To",orderTo.getText().toString());
        intent.putExtra("Number",orderNumber.getText().toString());

        if(checkWithFriend.isChecked()) {
            intent.putExtra("Drunk", checkWithFriend.getText().toString());
        }


        if(orderNumber.length()== 16){
            orderNumber.setTextColor(getResources().getColor(R.color.black));
            startActivity(intent);
        }
        else{
            orderNumber.setTextColor(getResources().getColor(R.color.red));
            toastInfoCheck = Toast.makeText(getApplicationContext(), "Wrong number", Toast.LENGTH_SHORT);
            toastInfoCheck.show();
        }

    }


}
