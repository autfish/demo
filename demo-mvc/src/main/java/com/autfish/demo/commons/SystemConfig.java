package com.autfish.demo.commons;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/1/17.
 */
public class SystemConfig {
    private static Logger logger = LogManager.getLogger("system");

    private static Properties props = new Properties();
    private File configFile = null;

    public SystemConfig(String filePath) {
        try {
            this.configFile = ResourceUtils.getFile(filePath);
            this.refresh();
        } catch(FileNotFoundException e) {
            logger.error(e);
            logger.warn("file [" + filePath + "] not found!");
            this.configFile = null;
        }
    }

    public void refresh() {
        if(this.configFile != null)
            SystemConfig.loadConfig(this.configFile);
        else
            logger.warn("load configuration file failed!");
    }

    private synchronized static void loadConfig(File configFile) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(configFile);
            if(props.isEmpty()) {
                props.load(fis);
            } else {
                Properties temp = new Properties();
                temp.load(fis);
                for (Object key : temp.keySet()) {
                    String value = temp.getProperty(key.toString());
                    if (props.getProperty(key.toString()) == null || !props.getProperty(key.toString()).equals(value)) {
                        props.setProperty(key.toString(), value);
                        logger.info("Detecting property change: " + key.toString() + "=" + value);
                    }
                }
            }

        } catch (IOException ex) {
            logger.error(ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ie) {}
        }
    }

    public static boolean isDebug() {
        return BooleanUtils.toBoolean(props.getProperty("debug"));
    }
}
