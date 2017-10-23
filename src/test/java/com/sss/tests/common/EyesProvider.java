package com.sss.tests.common;

import com.applitools.eyes.selenium.Eyes;

/**
 * Created by Танечка on 23.10.2017.
 */
public class EyesProvider {
    private EyesProvider() {
        //hide constructor
    }

    private static Eyes eyes;

    public static synchronized Eyes getEyes(boolean force) {
        if (eyes == null || force) {
            eyes = new Eyes();
            eyes.setApiKey("p0vBsK3104Ze0qtL111zdXgXFWbRraRBr111iT8XRHWuQVMvo110");
        }
        return eyes;
    }

    public static synchronized Eyes getEyes() {
        return getEyes(false);
    }
}
