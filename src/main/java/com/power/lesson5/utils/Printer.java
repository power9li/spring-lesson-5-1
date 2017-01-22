package com.power.lesson5.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shenli on 2017/1/21.
 */
public class Printer {

    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void print(String s){
        System.out.println(format.format(new Date()) + " " + s);
    }


}
