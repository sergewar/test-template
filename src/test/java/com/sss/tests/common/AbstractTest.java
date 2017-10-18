package com.sss.tests.common;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Created by Sergewar on 16.10.2017.
 */
@DirtiesContext(hierarchyMode = DirtiesContext.HierarchyMode.CURRENT_LEVEL)
public abstract class AbstractTest extends CleanContext {
    @Autowired
    @Qualifier("webdriverInstance")
    private WebDriver wdInstance;
}
