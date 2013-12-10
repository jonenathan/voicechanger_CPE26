package com.example.signal;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;

import android.view.View;


public class MainActivity extends Activity {

		Button Record,Realtime;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	    Record = (Button)findViewById(R.id.button1);
	    Realtime = (Button)findViewById(R.id.button2);
	    
	    Record.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openMainActivity = new Intent(MainActivity.this,AudioRecordTest.class);
				startActivity(openMainActivity);
			}
		});

	   }

	
}



