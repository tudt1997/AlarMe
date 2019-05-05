
package com.e15cn1.alarme.util;

import android.support.annotation.IdRes;


public final class FragmentTagUtils {

    /**
     * For general use.
     */
    public static String makeTag(Class<?> cls, @IdRes int viewId) {
        return cls.getName() + ":" + viewId;
    }

    /**
     * A version suitable for our ViewHolders.
     */
    public static String makeTag(Class<?> cls, @IdRes int viewId, long itemId) {
        return makeTag(cls, viewId) + ":" + itemId;
    }

    private FragmentTagUtils() {}
}
