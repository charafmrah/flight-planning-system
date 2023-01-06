package com.example.aviationsystem;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MinimumSdkTest {
    @Test
    public void testMinimumSdk() throws PackageManager.NameNotFoundException {
        /*
        Context context = ApplicationProvider.getApplicationContext();
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        int minSdkVersion = packageInfo.applicationInfo.minSdkVersion;
        assertEquals(minSdkVersion, 25);

         */
    }
}