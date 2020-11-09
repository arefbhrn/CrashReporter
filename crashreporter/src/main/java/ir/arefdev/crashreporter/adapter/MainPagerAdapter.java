package ir.arefdev.crashreporter.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ir.arefdev.crashreporter.ui.CrashLogFragment;
import ir.arefdev.crashreporter.ui.ExceptionLogFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

	private CrashLogFragment crashLogFragment;
	private ExceptionLogFragment exceptionLogFragment;
	private final String[] titles;

	public MainPagerAdapter(FragmentManager fm, String[] titles) {
		super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
		this.titles = titles;
	}

	@Override
	public Fragment getItem(int position) {
		if (position == 0) {
			return crashLogFragment = new CrashLogFragment();
		} else if (position == 1) {
			return exceptionLogFragment = new ExceptionLogFragment();
		} else {
			return new CrashLogFragment();
		}
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	public void clearLogs() {
		crashLogFragment.clearLog();
		exceptionLogFragment.clearLog();
	}
}