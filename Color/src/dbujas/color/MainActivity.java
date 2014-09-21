package dbujas.color;

import java.util.Random;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "dbujas.color.MESSAGE";
	public static int red;
	public static int green;
	public static int blue;
	
	private long startTime;
	//private int touchCount = 0;
	
	private SeekBar seekBar1;
	private SeekBar seekBar2;
	private SeekBar seekBar3;

	private TextView field1;
	private TextView field2;
	private TextView rgbLeft;
	private TextView rgbRight;
	
	/*
	 * (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
		seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
		seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
		field1 = (TextView) findViewById(R.id.textView4);
		field2 = (TextView) findViewById(R.id.textView3);
		rgbLeft = (TextView) findViewById(R.id.textView5);
		rgbRight = (TextView) findViewById(R.id.textView6);
		
		//set right field color
		Random rand = new Random();
		red = rand.nextInt(256);
		green = rand.nextInt(256);
		blue = rand.nextInt(256); 
		rgbRight.setText("rgb("+red+","+green+","+blue+")");
		field2.setBackgroundColor(Color.rgb(red, green, blue));
		
		//start a clock
		Time now = new Time();
		now.setToNow();
		startTime = now.toMillis(false);
		
		/*
		 * adds a listener to SeekBars
		 * every change on SeekBar will result in modifying left colored field and its caption
		 */
		OnSeekBarChangeListener listener = new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				int r = seekBar1.getProgress();
				int g = seekBar2.getProgress();
				int b = seekBar3.getProgress();
				rgbLeft.setText("rgb("+r+","+g+","+b+")");
				field1.setBackgroundColor(Color.rgb(r, g, b));
            }
			
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                // Auto-generated method stub
            }
		};

		seekBar1.setOnSeekBarChangeListener(listener);
		seekBar2.setOnSeekBarChangeListener(listener);
		seekBar3.setOnSeekBarChangeListener(listener);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	/** 
	 * Compares colors in colored fields
	 * if they are the same, survey window is displayed
	 */
	public void compare(View view) {
		rgbLeft = (TextView) findViewById(R.id.textView5);
		rgbRight = (TextView) findViewById(R.id.textView6);
		if(rgbLeft.getText().equals(rgbRight.getText())) {
			Intent intent = new Intent(this, SurveyActivity.class);
			Time now = new Time();
			now.setToNow();
			long time = now.toMillis(false) - startTime;
			String message = "<time>" + String.valueOf(time/1000) + "</time>";
			intent.putExtra(EXTRA_MESSAGE, message);
			startActivity(intent);
		}
		else
		    new AlertDialog.Builder(this)
				.setTitle("Niezgodnoœæ kolorów")
				.setMessage("Kolory nie s¹ takie same!")
				.show();
		
	}
	
}
