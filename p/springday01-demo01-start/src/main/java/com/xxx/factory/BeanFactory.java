package com.xxx.factory;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName BeanFactory
 * @Description
 * @Date 2022-08-01 11:01
 */
public class BeanFactory {

    private static Properties p = new Properties();
    private static Map<String, Object> map = new HashMap<>();

    static {
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);
            for (Object o : p.keySet()) {
                String classPath = p.get(o.toString()).toString();
                Object obj = Class.forName(classPath).newInstance();
                map.put(o.toString(), obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String key) {
        try {
            return map.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
