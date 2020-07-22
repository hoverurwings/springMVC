package com.aa.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    private String pattern;

    public DateConverter(String pattern){
        //把客户端的参数传给pattern
        this.pattern = pattern;
    }
    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);
        //把参数调给simpleDateFormat处理
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }
}
