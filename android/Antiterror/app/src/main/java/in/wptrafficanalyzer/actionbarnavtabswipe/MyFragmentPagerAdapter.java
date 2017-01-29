package in.wptrafficanalyzer.actionbarnavtabswipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
	
	final int PAGE_COUNT = 5;
	
	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int arg0) {
		Bundle data = new Bundle();
		switch(arg0){
		
			/** Home tab is selected */
			case 0:
				HomeFragment homeFragment = new HomeFragment();
				data.putInt("current_page", arg0+1);
				homeFragment.setArguments(data);
				return homeFragment;
				
			/** Suspicious Report tab is selected */
			case 1:
				ReportFragment reportFragment = new ReportFragment();
				data.putInt("current_page", arg0+1);
				reportFragment.setArguments(data);
				return reportFragment;

			/** Alerts is selected */
			case 2:
				AlertFragment alertFragment = new AlertFragment();
				data.putInt("current_page", arg0+1);
                alertFragment.setArguments(data);
				return alertFragment;

			/** Danger Zones is selected */
			case 3:
				MapFragment mapFragment = new MapFragment();
				data.putInt("current_page", arg0+1);
				mapFragment.setArguments(data);
				return mapFragment;

			/** Donate is selected */
			case 4:
                DonateFragment donateFragment = new DonateFragment();
                data.putInt("current_page", arg0+1);
                donateFragment.setArguments(data);
                return donateFragment;
		}
		
		return null;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {		
		return PAGE_COUNT;
	}
	
}
