package com.sss.tests.common;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by Танечка on 16.10.2017.
 */
@ContextHierarchy({
        @ContextConfiguration("classpath:context-static.xml"),
        @ContextConfiguration("classpath:context-dynamic.xml")
})
abstract class CleanContext extends AbstractTestNGSpringContextTests {
}
