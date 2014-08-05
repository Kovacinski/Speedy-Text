package com.example.meh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		TextView display = (TextView) findViewById(R.id.display_score);
		Button no = (Button) findViewById(R.id.no);
		Button yes = (Button) findViewById(R.id.yes);
		Intent mIntent = getIntent();
		int score = mIntent.getIntExtra("Score", 0);
		display.setText("You typed " + score + " words in 60 Seconds. Would you like to try again?");
		//updates the high Scores
		SharedPreferences prefs = this.getSharedPreferences("wordScores", Context.MODE_PRIVATE);
		Editor edit = prefs.edit();  
		if(score >= prefs.getInt("Best", 0) )
		{
			edit.putInt("Third", prefs.getInt("Second", 0));
			edit.putInt("Second", prefs.getInt("Best", 0));
		    edit.putInt("Best", score);
		}
		else if(score > prefs.getInt("Second", 0))
		{
			edit.putInt("Third", prefs.getInt("Second", 0));
			edit.putInt("Second", score);
		}
		else if(score > prefs.getInt("Third", 0))
		{
			edit.putInt("Third",score);
		}
		edit.commit();
		yes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Score.this, Game.class);
			    startActivity(intent);
			}
		});
		
		no.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Score.this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK); 
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
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
