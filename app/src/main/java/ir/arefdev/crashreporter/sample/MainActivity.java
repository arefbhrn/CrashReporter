package ir.arefdev.crashreporter.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ir.arefdev.crashreporter.CrashReporter;
import ir.arefdev.crashreporter.ui.CrashReporterActivity;

public class MainActivity extends AppCompatActivity {
	Context context;
	Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.nullPointer).setOnClickListener(v -> {
			context = null;
			context.getResources();
		});

		findViewById(R.id.indexOutOfBound).setOnClickListener(v -> {
			ArrayList<String> list = new ArrayList<>();
			list.add("hello");
			String crashMe = list.get(2);
		});

		findViewById(R.id.classCastExeption).setOnClickListener(v -> {
			Object x = 0;
			System.out.println((String) x);

		});

		findViewById(R.id.arrayStoreException).setOnClickListener(v -> {
			Object[] x = new String[3];
			x[0] = 0;
		});

		//Crashes and exceptions are also captured from other threads
		new Thread(() -> {
			try {
				context = null;
				context.getResources();
			} catch (Exception e) {
				//log caught Exception
				CrashReporter.logException(e);
			}

		}).start();

		mContext = this;
		findViewById(R.id.crashLogActivity).setOnClickListener(v -> {
			Intent intent = new Intent(mContext, CrashReporterActivity.class);
			startActivity(intent);
		});
	}
}
