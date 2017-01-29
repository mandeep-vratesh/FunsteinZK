package in.wptrafficanalyzer.actionbarnavtabswipe;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	ActionBar mActionBar;
	ViewPager mPager;
    String message="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//remove the title bar forcefully
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);

		//for calling the emergency numbers and sending panic alert sms
		Button police = (Button) findViewById(R.id.police);
		Button ambulance = (Button) findViewById(R.id.ambulance);
		Button fire_brigade = (Button) findViewById(R.id.firebrigade);
		Button blood_bank = (Button) findViewById(R.id.bloodbank);
        Button ats = (Button) findViewById(R.id.ats);
        Button emergency_disaster_management = (Button) findViewById(R.id.emergency_disaster_management);
		Button under_attack = (Button) findViewById(R.id.under_attack);
        final GPSTracker gps = new GPSTracker(getApplicationContext());
        final TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        final SmsManager smsManager = SmsManager.getDefault();



        police.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:8655344569"));
				startActivity(callIntent);
			}
		});

		fire_brigade.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:8655344569"));
				startActivity(callIntent);
			}
		});

		ambulance.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:8655344569"));
				startActivity(callIntent);
			}
		});

		blood_bank.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:8655344569"));
				startActivity(callIntent);
			}
		});

		emergency_disaster_management.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:8655344569"));
				startActivity(callIntent);
			}
		});

		ats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:8655344569"));
                startActivity(callIntent);
            }
        });

		under_attack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Long press to send your location to nearest police station", Toast.LENGTH_SHORT).show();
			}
		});

		under_attack.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
                message="heLP ME!!!\n\nOperator:"+telephonyManager.getNetworkOperator()+"\n\nPhysical:("+gps.getLatitude()+","+gps.getLongitude()+")\n\nNetwork:"+gps.getLocation()+"\n\nDevice:"+telephonyManager.getDeviceId();
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                smsManager.sendTextMessage("7208287697",null,message,null,null);
				return false;
			}
		});
		/** Getting a reference to action bar of this activity */
        mActionBar = getActionBar();
        
        /** Set tab navigation mode */
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        /** Getting a reference to ViewPager from the layout */
        mPager = (ViewPager) findViewById(R.id.pager);
        
        /** Getting a reference to FragmentManager */
        FragmentManager fm = getSupportFragmentManager();
        
        /** Defining a listener for pageChange */
        ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener(){
        	@Override
        	public void onPageSelected(int position) {        		
        		super.onPageSelected(position);
        		mActionBar.setSelectedNavigationItem(position);        		
        	}        	
        };
        
        /** Setting the pageChange listner to the viewPager */
        mPager.setOnPageChangeListener(pageChangeListener);
        
        /** Creating an instance of FragmentPagerAdapter */
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(fm);
        
        /** Setting the FragmentPagerAdapter object to the viewPager object */
        mPager.setAdapter(fragmentPagerAdapter);

        mActionBar.setDisplayShowTitleEnabled(true);
        
        /** Defining tab listener */
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
			
			@Override
			public void onTabReselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTabSelected(Tab tab,
				android.app.FragmentTransaction ft) {
				mPager.setCurrentItem(tab.getPosition());
				
			}

			@Override
			public void onTabUnselected(Tab tab,
					android.app.FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}
		};

		/** Creating Android Tab */
        Tab tab = mActionBar.newTab()
                           .setText("HOME")
                           .setIcon(R.drawable.home)
                           .setTabListener(tabListener);
        
        mActionBar.addTab(tab);

        /** Creating Apple Tab */
        tab = mActionBar.newTab()
                       .setText("SUSPICIOUS REPORT")
                       .setIcon(R.drawable.report)
                       .setTabListener(tabListener);                               

        mActionBar.addTab(tab);

		tab = mActionBar.newTab()
				.setText("ALERTS")
				.setIcon(R.drawable.alert)
				.setTabListener(tabListener);

		mActionBar.addTab(tab);

		tab = mActionBar.newTab()
				.setText("DANGER ZONES")
				.setIcon(R.drawable.danger)
				.setTabListener(tabListener);

		mActionBar.addTab(tab);

		tab = mActionBar.newTab()
				.setText("DONATE")
				.setIcon(R.drawable.donate)
				.setTabListener(tabListener);

		mActionBar.addTab(tab);
	}
}
