package com.xxx.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName HelloLog
 * @Description
 * @Date 2022-08-11 9:56
 */
public class HelloLog {


    public static void main(String[] args) {
        // 需要输出日志的类，可以创建一个log属性
        Log log = LogFactory.getLog(HelloLog.class);

//        log.trace("hello trace");
        log.debug("hello debug");
//        log.info("hello info");
//        log.warn("hello warn");
//        log.error("hello error");
//        log.fatal("hello fatal");
    }
}
