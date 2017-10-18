package com.sss.steps.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 */
public class ApplicationListenerBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListenerBean.class);

    @Autowired
    @Qualifier("allProps")
    private Properties allPropps;

    /**
     * @param event context refreshed event
     */
    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
//        System.out.print("context refreshed event fired: ");
//        System.out.println(event);
//        LOGGER.info(allPropps.toString());
        saveEnvPropertiesForAllure(allPropps);
    }

    /**
     * @param event context started event
     */
    @EventListener
    public void handleContextStarted(ContextStartedEvent event) {
//        System.out.print("context started event fired: ");
//        System.out.println(event);
    }

    /**
     * @param event context stopped event
     */
    @EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
//        System.out.print("context stopped event fired: ");
//        System.out.println(event);
    }

    /**
     * @param event context closed event
     */
    @EventListener
    public void handleContextClosed(ContextClosedEvent event) {
//        System.out.print("context  closed event fired: ");
//        System.out.println(event);
    }

    private void saveEnvPropertiesForAllure(Properties properties) {
        OutputStream output = null;

        if ("false".equals(System.getProperty("isEnvironmentPropertySaved", "false"))) {

            LOGGER.info("Используем следующие настройки окружения и запуска:");
            for (String propertyName : properties.stringPropertyNames()) {
                LOGGER.info(propertyName + ": " + properties.getProperty(propertyName));
            }

            String pathPropertiesFile = System.getProperty("user.dir") + File.separator +
                    "env" + File.separator +
                    "environment.properties";
            LOGGER.info("Saving environment properties in file: " + pathPropertiesFile);
            try {
                File file = new File(pathPropertiesFile);
                if (file.exists()) {
                    file.delete();
                }
                file.getParentFile().mkdirs();
                file.createNewFile();

                output = new FileOutputStream(pathPropertiesFile);
                properties.store(output, null);
                System.setProperty("isEnvironmentPropertySaved", "true");
            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            LOGGER.debug("Environment properties saved already");
        }

    }
}