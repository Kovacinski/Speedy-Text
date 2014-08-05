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

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button play = (Button) findViewById(R.id.play);
		Button high_score = (Button) findViewById(R.id.high_score);
		//checks to see if there are 3 highScores and if not puts a zero in their place
		
		SharedPreferences prefs = this.getSharedPreferences("wordScores", Context.MODE_PRIVATE);
		Editor editor = prefs.edit();
		if(!prefs.contains("Best"))
		{
			editor.putInt("Best", 0);
		}
		if(!prefs.contains("Second"))
		{
			editor.putInt("Second", 0);
		}
		if(!prefs.contains("Third"))
		{
			editor.putInt("Third", 0);
		}
		editor.commit();
		
		
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Game.class);
			    startActivity(intent);
			}
		});
		
		high_score.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, HighScores.class);
			    startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
