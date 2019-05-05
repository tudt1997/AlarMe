
package com.e15cn1.alarme.util;

import android.content.res.Resources;

public final class ConfigurationUtils {

    public static int getOrientation(Resources res) {
        return res.getConfiguration().orientation;
    }

    private ConfigurationUtils() {}

}
