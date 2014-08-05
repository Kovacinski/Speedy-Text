package com.example.meh;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HighScores extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_scores);
		
		TextView best = (TextView) findViewById(R.id.best_score);
		TextView second = (TextView) findViewById(R.id.second_score);
		TextView third = (TextView) findViewById(R.id.third_score);
		
		SharedPreferences prefs = this.getSharedPreferences("wordScores", Context.MODE_PRIVATE);
		best.setText("" + prefs.getInt("Best", 0));
		second.setText("" + prefs.getInt("Second", 0));
		third.setText("" + prefs.getInt("Third", 0));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.high_scores, menu);
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
