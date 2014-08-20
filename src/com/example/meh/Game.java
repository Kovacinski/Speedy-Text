package com.example.meh;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class Game extends Activity {
	boolean clicked = false;
	String[] myStringArray = new String[]{"apple","boat","cow","donut","tricky"};
	String word;
	int arrayNum, score = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		final Button start = (Button) findViewById(R.id.start);
		final TextView mTextField = (TextView) findViewById(R.id.clock);
	    final TextView words = (TextView) findViewById(R.id.words);
	    final AutoCompleteTextView user = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		
		start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(!clicked)
				{
					clicked = true;
					arrayNum = new Random().nextInt(myStringArray.length);
					word = myStringArray[arrayNum];
					words.setText(word);
					start.setText("Enter");
				new CountDownTimer(60000, 1000) {

				     public void onTick(long millisUntilFinished) {
				         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
				     }

				     public void onFinish() {
				         //mTextField.setText("done! Total words = " + score);
				    	 Intent myIntent = new Intent(Game.this, Score.class);
				    	 myIntent.putExtra("Score", score);
				    	 startActivity(myIntent);
				     }
				  }.start(); 
				}
				else
				{
					
					if((user.getText().toString()).equals(word))
                    {
                        score++;
                        user.setText("");
                        arrayNum = new Random().nextInt(myStringArray.length);
    					word = myStringArray[arrayNum];
    					words.setText(word);
    					words.setTextSize(30);  
    					user.setTextColor(Color.BLACK);
                    }
					else
					{
						words.setText(word);
						user.setText(user.getText().toString());
						user.setTextColor(Color.RED);
					}
				}
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
