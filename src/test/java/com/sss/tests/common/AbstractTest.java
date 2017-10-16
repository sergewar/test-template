package com.sss.tests.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by Sergewar on 16.10.2017.
 */
//@ContextHierarchy()
@ContextConfiguration(locations = "classpath:context-clean.xml")

public abstract class AbstractTest extends CleanContext {
}
