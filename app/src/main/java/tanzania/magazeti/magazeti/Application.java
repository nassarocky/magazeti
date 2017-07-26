/*
 * Copyright (c) 2015 Ha Duy Trung
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tanzania.magazeti.magazeti;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.appcompat.BuildConfig;


import dagger.ObjectGraph;
import rx.schedulers.Schedulers;

public class Application extends android.app.Application {

    public static Typeface TYPE_FACE = null;

    private ObjectGraph mApplicationGraph;



    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(Preferences.Theme.getAutoDayNightMode(this));

        if (BuildConfig.DEBUG && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyFlashScreen()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }
        mApplicationGraph = ObjectGraph.create();
        Preferences.migrate(this);
        TYPE_FACE = FontCache.getInstance().get(this, Preferences.Theme.getTypeface(this));
        AppUtils.registerAccountsUpdatedListener(this);
        AdBlocker.init(this, Schedulers.io());
    }

    public ObjectGraph getApplicationGraph() {
        return mApplicationGraph;
    }
}
