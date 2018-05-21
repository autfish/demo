package com.autfish._log4j2.step05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j2实战方案
 * Created by autfish on 2017/3/10.
 */
public class Log4jAction {

    public static void main(String[] args) {
        //system logger的全部信息记录在system.log中
        Logger systemLog = LogManager.getLogger("system");
        systemLog.info("system info");
        systemLog.debug("system debug");
        systemLog.warn("system warn");
        systemLog.error("system error");

        //其他按级别输出
        Logger logger = LogManager.getLogger(Log4jAction.class);
        logger.info("logger info"); //info.log
        logger.debug("logger debug"); //info.log
        logger.warn("logger warn"); //warn.log
        logger.error("logger error"); //error.log
    }
}
