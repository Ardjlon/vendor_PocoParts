package org.lineageos.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragment;
import androidx.preference.SwitchPreference;
import androidx.preference.ListPreference;

import org.lineageos.settings.R;
import org.lineageos.settings.speaker.ClearSpeakerActivity;
import org.lineageos.settings.kcal.KcalSettingsActivity;

public class DeviceSettingsFragment extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {

     private static final String PREF_CLEAR_SPEAKER = "clear_speaker_settings";

     private Preference mClearSpeakerPref;

     @Override
     public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.device_settings);

     mClearSpeakerPref = (Preference) findPreference(PREF_CLEAR_SPEAKER);
        mClearSpeakerPref.setOnPreferenceClickListener(preference -> {
            Intent intent = new Intent(getActivity().getApplicationContext(), ClearSpeakerActivity.class);
            startActivity(intent);
            return true;
        });
    }
}
