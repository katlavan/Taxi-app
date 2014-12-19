package com.app.taxi.myTaxy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.taxi.myTaxi.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Confirm_after_order extends Activity {

    private TextView confirmFrom;
    private TextView confirmTo;
    private TextView confirmNumber;
    private TextView addCheckFriend;
    private TextView orderringTime;
    private TextView orderringDate;


    private Date currentTime;
    private DateFormat timeFormat;

    private String formattedTime;
    private String formattedDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_after_order);

        confirmFrom = (TextView) findViewById(R.id.confirm_from);
        confirmTo = (TextView) findViewById(R.id.confirm_to);
        confirmNumber = (TextView) findViewById(R.id.confirm_number);
        addCheckFriend = (TextView) findViewById(R.id.textView_check_1);
        orderringTime = (TextView) findViewById(R.id.text_time_order);
        orderringDate = (TextView) findViewById(R.id.text_date_order);


        currentTime = Calendar.getInstance().getTime();
        timeFormat = android.text.format.DateFormat.getTimeFormat(this);
        formattedTime = timeFormat.format(currentTime);
        orderringTime.setText(formattedTime);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        formattedDate = df.format(c.getTime());
        orderringDate.setText(formattedDate);

        confirmFrom.setText(getIntent().getStringExtra("From"));
        confirmTo.setText(getIntent().getStringExtra("To"));
        confirmNumber.setText(getIntent().getStringExtra("Number"));
        addCheckFriend.setText(getIntent().getStringExtra("Drunk"));


    }
    public void goToGoogleMap(View view){
        Intent intent = new Intent(this,MapActivity.class);
        startActivity(intent);
    }
    public void goBackToMain(View view){

        this.finish();
    }
    public void mLocationLatLng(View view){
        Intent intent = new Intent(this,MyLocation.class);
        startActivity(intent);
    }
}
