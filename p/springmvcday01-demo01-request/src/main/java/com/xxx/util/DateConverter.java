package com.xxx.util;

import org.springframework.cglib.core.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName DateConverter
 * @Description
 * @Date 2022-08-08 15:20
 */
public class DateConverter implements Converter {

    public Object convert(String str) {
        try {
            //定义一个时间转换工具对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //将字符串转Date并返回
            return sdf.parse(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object convert(Object o, Class aClass, Object o1) {
        return null;
    }
}
