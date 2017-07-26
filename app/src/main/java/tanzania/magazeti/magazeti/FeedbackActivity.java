/*
 * Copyright (c) 2016 Ha Duy Trung
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

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import tanzania.magazeti.magazeti.annotation.Synthetic;
import tanzania.magazeti.magazeti.data.FeedbackClient;

public class FeedbackActivity extends InjectableActivity {
    @Inject FeedbackClient mFeedbackClient;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_feedback);


        findViewById(R.id.button_rate).setOnClickListener(v -> {
            AppUtils.openPlayStore(FeedbackActivity.this);
            finish();
        });

    }

    @Override
    protected boolean isDialogTheme() {
        return true;
    }

}
