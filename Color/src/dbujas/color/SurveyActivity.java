package dbujas.color;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SurveyActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "dbujas.color.MESSAGE";
	
	private RadioGroup radioGroup1;
	private RadioGroup radioGroup2;
	private RadioGroup radioGroup3;
	private RadioGroup radioGroup4;
	private RadioGroup radioGroup5;
	private RadioGroup radioGroup6;
	private RadioGroup radioGroup7;
	private RadioGroup radioGroup8;
	private RadioGroup radioGroup9;
	private RadioGroup radioGroup10;
	
	private RadioButton checked;
	
	private String message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_survey);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
	    Intent intent = getIntent();
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.survey, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_survey,
					container, false);
			return rootView;
		}
	}
	
	/**
	 * calculate and display survey results
	 * @param view
	 */
	public void summarize(View view) {
		int result = 0;
		
		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup2 = (RadioGroup) findViewById(R.id.RadioGroup01);
		radioGroup3 = (RadioGroup) findViewById(R.id.RadioGroup02);
		radioGroup4 = (RadioGroup) findViewById(R.id.RadioGroup03);
		radioGroup5 = (RadioGroup) findViewById(R.id.RadioGroup04);
		radioGroup6 = (RadioGroup) findViewById(R.id.RadioGroup05);
		radioGroup7 = (RadioGroup) findViewById(R.id.RadioGroup06);
		radioGroup8 = (RadioGroup) findViewById(R.id.RadioGroup07);
		radioGroup9 = (RadioGroup) findViewById(R.id.RadioGroup08);
		radioGroup10 = (RadioGroup) findViewById(R.id.RadioGroup09);
		
		checked = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
		result += Integer.parseInt((String) checked.getText()) - 1;
		checked = (RadioButton) findViewById(radioGroup2.getCheckedRadioButtonId());
		result += -Integer.parseInt((String) checked.getText()) + 5;
		checked = (RadioButton) findViewById(radioGroup3.getCheckedRadioButtonId());
		result += Integer.parseInt((String) checked.getText()) - 1;
		checked = (RadioButton) findViewById(radioGroup4.getCheckedRadioButtonId());
		result += -Integer.parseInt((String) checked.getText()) + 5;
		checked = (RadioButton) findViewById(radioGroup5.getCheckedRadioButtonId());
		result += Integer.parseInt((String) checked.getText()) - 1;
		checked = (RadioButton) findViewById(radioGroup6.getCheckedRadioButtonId());
		result += -Integer.parseInt((String) checked.getText()) + 5;
		checked = (RadioButton) findViewById(radioGroup7.getCheckedRadioButtonId());
		result += Integer.parseInt((String) checked.getText()) - 1;
		checked = (RadioButton) findViewById(radioGroup8.getCheckedRadioButtonId());
		result += -Integer.parseInt((String) checked.getText()) + 5;
		checked = (RadioButton) findViewById(radioGroup9.getCheckedRadioButtonId());
		result += Integer.parseInt((String) checked.getText()) - 1;
		checked = (RadioButton) findViewById(radioGroup10.getCheckedRadioButtonId());
		result += -Integer.parseInt((String) checked.getText()) + 5;
		
		Intent intent = new Intent(this, EndingActivity.class);
		message = "<result>" + String.valueOf(result*2.5) + "</result>" + message;
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
			
	}

}
