package com.xxx.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName HelloLog2
 * @Description
 * @Date 2022-08-11 10:16
 */
public class HelloLog2 {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(HelloLog2.class);

        System.out.println(log.getClass());
//        log.trace("hello trace");
        log.debug("hello debug");
//        log.info("hello info");
//        log.warn("hello warn");
//        log.error("hello error");
        // 注意，logback中没有fatal日志
    }
}
