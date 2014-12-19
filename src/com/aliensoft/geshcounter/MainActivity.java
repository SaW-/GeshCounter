package com.aliensoft.geshcounter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	Spinner day, mounth, year;
	TextView result, status;
	SimpleDateFormat sdf;
	String currentDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		result = (TextView) findViewById(R.id.tvResult);
		status = (TextView) findViewById(R.id.tvStatus);

		day = (Spinner) findViewById(R.id.sDay);
		mounth = (Spinner) findViewById(R.id.sMonth);
		year = (Spinner) findViewById(R.id.sYear);

		Calendar c = Calendar.getInstance();
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setCalendar(c);

		currentDate = sdf.format(c.getTime());

		Button calc = (Button) findViewById(R.id.bCalc);

		calc.setOnClickListener(this);
	}

	public void calc() {
		String endDate = day.getSelectedItem() + "-" + mounth.getSelectedItem()
				+ "-" + year.getSelectedItem();

		try {
			Date endDateFormat = sdf.parse(endDate);
			Date currentDate2 = sdf.parse(currentDate);

			long diff = endDateFormat.getTime() - currentDate2.getTime();

			int days = (int) TimeUnit.MILLISECONDS.toDays(diff);
			// days = days - 1;

			int yearsLeft = days / 365;
			double yearsLeftMod = days / 365.0;

			yearsLeftMod = yearsLeftMod - yearsLeft;

			int monthsLeft = (int) (yearsLeftMod * 12);
			double monthsLeftMod = yearsLeftMod * 12.0;
			monthsLeftMod = monthsLeftMod - monthsLeft;
			int daysLeft = (int) Math.round(monthsLeftMod * 30);

			String output = "";
			if (days < 0) {
				Toast.makeText(this, "أنت خلصت من " + days * -1 + " يوم!",
						Toast.LENGTH_LONG).show();
				result.setText("---");
				status.setText("---");
			} else {
				if (yearsLeft > 0) {
					output += yearsLeft + " سنة";
				}
				if (yearsLeft > 0) {
					output += " و ";
				}
				if (monthsLeft > 0) {
					output += monthsLeft + " شهر";
				}
				if (daysLeft > 0 && monthsLeft > 0) {
					output += " , ";
				}
				if (daysLeft > 0) {
					output += daysLeft + " يوم";
				}

				if (days > 0 && monthsLeft > 0) {
					output += "\nكولو " + days + " يوم!";
				}
				if (yearsLeft > 0) {
					status.setText("كاحول");
				} else if (monthsLeft <= 3) {
					status.setText("رديف");
				} else if (monthsLeft > 3 && monthsLeft <= 6) {
					status.setText("رديف منتظر");
				} else {
					status.setText("كاحول");
				}

				result.setText(output);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.actionAbout:
			Intent i = new Intent(".About");
			startActivity(i);
			break;
		case R.id.actionExit:
			finish();
			break;
		case R.id.action_share:
			if (!result.getText().equals("---")) {
				Intent myIntent = new Intent(Intent.ACTION_SEND);
				myIntent.setType("text/plain");
				myIntent.putExtra(
						Intent.EXTRA_TEXT,
						"فاضل "
								+ result.getText()
								+ " يا جيش... يتوب علينا ربنا... #GeshCounter");

				startActivity(Intent.createChooser(myIntent,
						"مشاركة"));
				// myShareActionProvider.setShareIntent(myIntent);
			} else {
				Toast.makeText(this, "أحسب الأول و بعدين أعمل شير !",
						Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		calc();
	}
}
