package com.sss.tests.common;

import org.springframework.test.annotation.DirtiesContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by Sergewar on 16.10.2017.
 */
@DirtiesContext(hierarchyMode = DirtiesContext.HierarchyMode.CURRENT_LEVEL)
public abstract class AbstractTest extends CleanContext {

    @BeforeMethod
    protected void initEyes(final Method method) {
        EyesProvider.getEyes(true).open(getWdInstance(), "My awesome app",
                method.getName());
    }

    @AfterMethod
    public void closeEyes() {
        EyesProvider.getEyes().close(false);
        EyesProvider.getEyes().abortIfNotClosed();
    }
}
