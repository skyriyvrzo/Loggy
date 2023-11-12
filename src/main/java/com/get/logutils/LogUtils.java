package com.get.logutils;

import com.get.logutils.util.Reference;

import java.util.Calendar;

public class LogUtils {
    public static String getMain(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " Main]: " + string + "\n";
    }
    public static String getInfo(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " INFO]: " + string + "\n";
    }
    public static String getError(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " ERROR]: " + string + "\n";
    }
    public static String getCommand(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " COMMAND]: " + string + "\n";
    }
    public static String getDiscord(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " DISCORD]: " + string + "\n";
    }
}
