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

import androidx.preference.PreferenceManager;

import org.lineageos.settings.Constants;
import org.lineageos.settings.utils.DisplayUtils;
import org.lineageos.settings.utils.FileUtils;
import org.lineageos.settings.doze.DozeUtils;
import org.lineageos.settings.haptic.HapticUtils;
import org.lineageos.settings.thermal.ThermalUtils;
import org.lineageos.settings.touchsampling.TouchSamplingUtils;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        // Thermal Profiles
        ThermalUtils.initialize(context);

        // Dynamic Refresh Rate
        DisplayUtils.updateRefreshRateSettings(context);

        // Vibrator
        HapticUtils.restoreLevel(context);

        // Touch Sampling
        TouchSamplingUtils.restoreSamplingValue(context);

        // Doze
        DozeUtils.checkDozeService(context);
    }
}
