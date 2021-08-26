/*
 * Copyright (C) 2018 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.provider.Settings;

import androidx.preference.PreferenceManager;

import org.lineageos.settings.Constants;
import org.lineageos.settings.utils.DisplayUtils;
import org.lineageos.settings.utils.FileUtils;
import org.lineageos.settings.dirac.DiracUtils;
import org.lineageos.settings.thermal.ThermalUtils;
import org.lineageos.settings.kcal.KcalUtils;
import org.lineageos.settings.haptic.HapticUtils;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        // Dirac
        DiracUtils.initialize(context);

        // Thermal Profiles
        ThermalUtils.startService(context);

        // Kcal
        KcalUtils kcalUtils = new KcalUtils(context);
        kcalUtils.restoreSettings();

        // Vibrator
        HapticUtils.restoreLevel(context);

        // Dynamic Refresh rate
        DisplayUtils.updateRefreshRateSettings(context);
    }
}
