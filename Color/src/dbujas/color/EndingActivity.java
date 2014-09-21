package dbujas.color;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EndingActivity extends ActionBarActivity {
	
	private String message;
	private String result;
	private String time;
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
	    message = intent.getStringExtra(SurveyActivity.EXTRA_MESSAGE);
	    
	    result = cutBetween(message, "<result>", "</result>");
	    time = cutBetween(message, "<time>", "</time>");

	    textView = new TextView(this);
	    textView.setText("Wynik testu System Usability:\n" + result + "\n\n"
	    		+ "Czas wykonania æwiczenia:\n"	+ time + " sekund");
	    textView.setTextSize(20);
	    textView.setGravity(Gravity.CENTER);
	    
	    setContentView(textView);
	}

    /**
     * 
     * @param s
     * @param prefix
     * @param suffix
     * @return text between prefix and suffix in String s
     */
    private String cutBetween(String s, String prefix, String suffix) {
        int beginIndex, endIndex;
        beginIndex = s.indexOf(prefix)+prefix.length();
        endIndex = s.substring(beginIndex).indexOf(suffix) + beginIndex;
        if(beginIndex >= 0 && endIndex > beginIndex)
            return s.substring(beginIndex, endIndex);
        else 
        	return "";
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ending, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_ending,
					container, false);
			return rootView;
		}
	}

}
