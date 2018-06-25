
package jp.mixi.practice.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {
    private static final String PREF_KEY_STORAGE_SETTINGS ="pref_key_storage_settings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        // TODO:preferences.xmlを作成してください
        // TODO:作成したpreferences.xmlの読み込み処理を実装してください
        // TODO:ListPreferenceの設定が変更されたらSummaryに反映してください



    }

}
