package org.lineageos.settings.kcal;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.lineageos.settings.R;

public class KcalSettingsActivity extends Activity {

    private KcalSettings mKcalSettingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment fragment = getFragmentManager().findFragmentById(android.R.id.content);
        if (fragment == null) {
            mKcalSettingsFragment = new KcalSettings();
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, mKcalSettingsFragment)
                    .commit();
        } else {
            mKcalSettingsFragment = (KcalSettings) fragment;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_reset:
                mKcalSettingsFragment.resetKcalData();
                return true;
            case R.id.action_preset:
                new PresetDialog().show(getFragmentManager(),
                        KcalSettingsActivity.class.getName(), mKcalSettingsFragment);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_reset, menu);
        return true;
    }
}
