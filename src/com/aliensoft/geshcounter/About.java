package com.aliensoft.geshcounter;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class About extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		ImageView hossface = (ImageView) findViewById(R.id.hossFace);
		ImageView shadyface = (ImageView) findViewById(R.id.shdyFace);
		ImageView hossemail = (ImageView) findViewById(R.id.hossEmail);
		ImageView shadyemail = (ImageView) findViewById(R.id.shadyEmail);
		ImageView hosstwit = (ImageView) findViewById(R.id.hossTwit);
		ImageView shadygoogle = (ImageView) findViewById(R.id.shadyGoogle);
		ImageView hossgoogle = (ImageView) findViewById(R.id.hossGoogle);
		ImageView shadytwit = (ImageView) findViewById(R.id.shdyTwit);
		hossface.setOnClickListener(this);
		hossemail.setOnClickListener(this);
		hossgoogle.setOnClickListener(this);
		hosstwit.setOnClickListener(this);
		shadyemail.setOnClickListener(this);
		shadyface.setOnClickListener(this);
		shadygoogle.setOnClickListener(this);
		shadytwit.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.hossEmail:
			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			emailIntent.setType("vnd.android.cursor.item/email");
			emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
					new String[] { "hossameldeenhassan.hk@gmail.com" });
			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"GeshCounter app Feedback");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
			startActivity(Intent.createChooser(emailIntent,
					"Send mail using..."));
			break;
		case R.id.hossFace:
			try {

				this.getPackageManager().getPackageInfo("com.facebook.katana",
						0);
				Intent intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("fb://profile/764379110"));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			} catch (Exception e) {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/hossam.kalabsh")));
			}
			break;
		case R.id.hossTwit:
			Intent intent = null;
			try {
				this.getPackageManager().getPackageInfo("com.twitter.android",
						0);
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("twitter://user?user_id=512970852"));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			} catch (Exception e) {
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/HossamKalabsh"));
			}
			this.startActivity(intent);
			break;
		case R.id.hossGoogle:
			try {
				Intent intent2 = new Intent(Intent.ACTION_VIEW);
				intent2.setClassName("com.google.android.apps.plus",
						"com.google.android.apps.plus.phone.UrlGatewayActivity");
				intent2.putExtra("customAppUri", "116465990971707643722");
				intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent2);
			} catch (ActivityNotFoundException e1) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://plus.google.com/u/0/116465990971707643722/posts")));
			}
			break;
		case R.id.shadyEmail:
			Intent emailIntents = new Intent(android.content.Intent.ACTION_SEND);
			emailIntents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			emailIntents.setType("vnd.android.cursor.item/email");
			emailIntents.putExtra(android.content.Intent.EXTRA_EMAIL,
					new String[] { "e.saw.90@gmail.com" });
			emailIntents.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"ESS app Feedback");
			emailIntents.putExtra(android.content.Intent.EXTRA_TEXT, "");
			startActivity(Intent.createChooser(emailIntents,
					"Send mail using..."));
			break;
		case R.id.shdyFace:
			try {

				this.getPackageManager().getPackageInfo("com.facebook.katana",
						0);
				Intent intent1 = new Intent(Intent.ACTION_VIEW,
						Uri.parse("fb://profile/657772079"));
				intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent1);
			} catch (Exception e) {
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.facebook.com/shady.william")));
			}
			break;
		case R.id.shdyTwit:
			try {
				this.getPackageManager().getPackageInfo("com.twitter.android",
						0);
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("twitter://user?user_id=566226427"));
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			} catch (Exception e) {
				intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://twitter.com/Shady_Amir"));
			}
			this.startActivity(intent);
			break;
		case R.id.shadyGoogle:
			try {
				Intent intent3 = new Intent(Intent.ACTION_VIEW);
				intent3.setClassName("com.google.android.apps.plus",
						"com.google.android.apps.plus.phone.UrlGatewayActivity");
				intent3.putExtra("customAppUri", "109053660584416977267");
				intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent3);
			} catch (ActivityNotFoundException e1) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://plus.google.com/109053660584416977267/posts")));
			}
			break;
		default:
			break;
		}

	}

}
