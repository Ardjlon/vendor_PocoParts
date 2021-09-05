package org.lineageos.settings;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.preference.ListPreference;

public class DeviceSettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Fragment fragment = getFragmentManager().findFragmentById(android.R.id.content);
        DeviceSettingsFragment deviceSettingsFragment;
        if (fragment == null) {
            deviceSettingsFragment = new DeviceSettingsFragment();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, deviceSettingsFragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
