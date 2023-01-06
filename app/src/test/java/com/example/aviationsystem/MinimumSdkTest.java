import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MinimumSdkTest {
    @Test
    public void testMinimumSdk() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = InstrumentationRegistry.getTargetContext().getPackageManager()
                .getPackageInfo(InstrumentationRegistry.getTargetContext().getPackageName(), 0);
        int minSdkVersion = packageInfo.applicationInfo.minSdkVersion;
        assertEquals(minSdkVersion, 25);
    }
}
