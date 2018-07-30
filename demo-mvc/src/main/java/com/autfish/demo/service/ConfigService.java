package com.autfish.demo.service;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ConfigService {

    @Value("classpath:system.properties")
    private ClassPathResource configFile;

    private static Properties props = new Properties();

    public ConfigService() {
        this.refresh();
    }

    @Scheduled(cron = "* 0/5 * * * ?")
    public void refresh() {
        try {
            if (props.isEmpty()) {
                props = PropertiesLoaderUtils.loadAllProperties("system.properties");
            } else {
                Properties temp = PropertiesLoaderUtils.loadAllProperties("system.properties");
                for (Object key : temp.keySet()) {
                    String value = temp.getProperty(key.toString());
                    if (props.getProperty(key.toString()) == null || !props.getProperty(key.toString()).equals(value)) {
                        props.setProperty(key.toString(), value);
                    }
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isDebug() {
        return BooleanUtils.toBoolean(props.getProperty("debug"));
    }

    public String getVersion() {
        return props.getProperty("version");
    }
}
