package ir.arefdev.crashreporter.sample;

import android.app.Application;

import ir.arefdev.crashreporter.CrashReporter;

public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		CrashReporter.initialize(this);
		// or
//		CrashReporter.initialize(this, externalPath);
	}
}
