
package com.e15cn1.alarme.util;

public final class Preconditions {
    private Preconditions() {}

    public static <T> T checkNotNull(T obj) {
        if (null == obj)
            throw new NullPointerException();
        return obj;
    }
}
