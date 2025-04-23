package com.wj.jscucc.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtil {
	
	//获取系统当前时间
	public static String getTimeNow() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = ldt.format(dtf);
        System.out.println(str);
		return str;
	}

    public static void main(String[] args) {
        getTimeNow();
    }
}
