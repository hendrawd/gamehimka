package himka.gamehimka.util;

import android.content.Context;

/**
 * @author hendrawd on 12/3/16
 */

public class PreferenceHelper {

    private static final String KEY_LEVEL = "LEVEL";

    public static int getLevel(Context context) {
        return PreferencesManager.getInt(context, KEY_LEVEL, 0);
    }

    public static void setLevel(Context context, int level) {
        PreferencesManager.putInt(context, KEY_LEVEL, level);
    }
}
