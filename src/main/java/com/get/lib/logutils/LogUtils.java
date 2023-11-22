package com.get.lib.logutils;

import com.get.logutils.util.Reference;

import java.util.Calendar;

public class LogUtils {
    public static String getMain(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " Main]: " + string + "\n";
    }
    public static String getInfo(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " INFO]: " + string + "\n";
    }
    public static <T> String getError(Class<T> classname, String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " ERROR/" + classname.getSimpleName() + "]: " + string + "\n";
    }
    public static String getCommand(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " COMMAND]: " + string + "\n";
    }
    public static String getDiscord(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " DISCORD]: " + string + "\n";
    }
    public static <T> String getClassName(Class<T> c){
        return c.getSimpleName();
    }
}
