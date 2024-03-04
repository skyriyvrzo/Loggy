package com.get.lib.logutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.get.logutils.util.Reference;

public class LogUtil {
	
	private String dirTarget;
	private String os;
	
	static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	
	public LogUtil() {
			
	}
	
	public LogUtil(String dirTargetPath) {
		
		if(System.getProperty("os.name").contains("Windows")) {
			os = "windows";
			this.dirTarget = dirTargetPath + "\\logs";
		}
		else if(System.getProperty("os.name").equalsIgnoreCase("Linux")) {
			os = "linux";
			this.dirTarget = dirTargetPath + "/logs";
		}
		else if(System.getProperty("os.name").contains("mac")) {
			os = "mac";
			this.dirTarget = dirTargetPath + "/logs";
		}
		else {
			System.err.println(System.getProperty("os.name"));
		}
	}
	
    public static String main(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " MAIN]: " + string + "\n";
    }
    
    public static String info(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " INFO]: " + string + "\n";
    }
    
    public static String warning(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " WARNING]: " + string + "\n";
    }
    
    public static <T> String error(Class<T> classname, String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " ERROR/" + classname.getSimpleName() + "]: " + string + "\n";
    }
    
    public static <T> String error(Class<T> classname, Object x){
    	String s = String.valueOf(x);
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " ERROR/" + classname.getSimpleName() + "]: " + s + "\n";
    }
    
    public static String command(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " COMMAND]: " + string + "\n";
    }
    
    public static String discord(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " DISCORD]: " + string + "\n";
    }
    
    public static String event(String event, String string) {
    	return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " " + event + "]: " + string + "\n";
    }
    
    public static <T> String getClassName(Class<T> c){
        return c.getSimpleName();
    }
    
    public void mkdir() {
    	
    	File file = new File(dirTarget);
    	
    	if(!file.mkdir()) {}
    }
    
    public void writeLog(String s) {
    	
    	String dir = null;
    	
    	if(os.equalsIgnoreCase("windows")) dir = dirTarget + "\\";
    	else if(os.equalsIgnoreCase("linux")) dir = dirTarget + "/";
    	else if(os.equalsIgnoreCase("mac")) dir = dirTarget + "/";
    	
    	FileWriter writer;
		try {
			writer = new FileWriter(dir + date.format(Calendar.getInstance().getTime()) + ".log", true);
			writer.append(s);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
