package com.get.lib.logutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.get.lib.colorlib.ANSIEscapeColorCode;
import com.get.lib.logutils.util.Reference;

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
	
    public static String main(Object method, Object o, String message, boolean println, boolean reqcolor){
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[%s/MAIN] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") : 
    		String.format("[%s] [%s/MAIN] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n"));
        
    	return String.format("[%s] [%s/MAIN] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    public static String main(String message, boolean println, boolean reqcolor){        
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[MAIN] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [MAIN] : %s%s", Reference.time.get(), message, "\n"));
    	
    	return String.format("[%s] [MAIN] : %s%s", Reference.time.get(), message, "\n");
    }
    
    public static String info(Object method, Object o, String message, boolean println, boolean reqcolor){
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[%s/INFO] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") :
    		String.format("[%s] [%s/INFO] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n"));
    	
    	return String.format("[%s] [%s/INFO] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    public static String info(String message, boolean println, boolean reqcolor){        
    	 if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[INFO] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [INFO] : %s%s", Reference.time.get(), message, "\n"));
    	 
    	 return String.format("[%s] [INFO] : %s%s", Reference.time.get(), message, "\n");
    }
    
    public static String warn(Object method, Object o, String message, boolean println, boolean reqcolor){
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[%s/WARN] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.yellow, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") :
    		String.format("[%s] [%s/WARN] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n"));
    	
    	return String.format("[%s] [%s/WARN] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    public static String warn(String message, boolean println, boolean reqcolor){
    	if(println) System.out.print(String.format("%s[%s] %s[WARN] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n"));
        
    	return reqcolor ? String.format("%s[%s] %s[WARN] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [WARN] : %s%s", Reference.time.get(), message, "\n");
    }
    
    public static String error(Object method, Object o, Object message, boolean println, boolean reqcolor){
    	String s = String.valueOf(message);
    	
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[%s/ERROR] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.red, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, s, "\n") :
    		String.format("[%s] [%s/ERROR] (%s) : %s%s", Reference.time.get(), method, o.toString(), s, "\n"));
    	
    	return String.format("[%s] [%s/ERROR] (%s) : %s%s", Reference.time.get(), method, o.toString(), s, "\n");
    }
    
    public static String error(Object o, boolean println, boolean reqcolor){
    	String s = String.valueOf(o);
    	        
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[ERROR] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, s, "\n") : 
        	String.format("[%s] [ERROR] : %s%s", Reference.time.get(), s, "\n"));
    	
    	return String.format("[%s] [ERROR] : %s%s", Reference.time.get(), s, "\n");
    }
    
    public static String command(Object method, Object o, String message, boolean println, boolean reqcolor){
    	if(println) System.out.print(reqcolor ? String.format("%s[%s] %s[%s/Command] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") : 
    		String.format("[%s] [%s/Command] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n"));
    	
    	return String.format("[%s] [%s/Command] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    /*
    public static String command(String message, boolean println, boolean reqcolor){
    	if (println) System.out.print(String.format("%s[%s] %s[Command] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n"));
        
    	return reqcolor ? String.format("%s[%s] %s[Command] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [Command] : %s%s", Reference.time.get(), message, "\n");
    }
    
    public static String discord(Object method, Object o, String message, boolean println, boolean reqcolor){
    	if (println) System.out.print(String.format("%s[%s] %s[%s/Discord] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n"));
    	
    	return reqcolor ? String.format("%s[%s] %s[%s/Discord] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") :
    		String.format("[%s] [%s/Discord] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    public static String discord(String message, boolean println, boolean reqcolor){
    	if (println) System.out.print(String.format("%s[%s] %s[Discord] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n"));
        
    	return reqcolor ? String.format("%s[%s] %s[Discord] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [Discord] : %s%s", Reference.time.get(), message, "\n");
    }
    
    public static String event(Object method, Object o, String message, boolean println, boolean reqcolor) {
    	if (println) System.out.print(String.format("%s[%s] %s[%s/Event] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n"));

    	return reqcolor ? String.format("%s[%s] %s[%s/Event] %s(%s) %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, method, ANSIEscapeColorCode.cyan, o.toString(), ANSIEscapeColorCode.white, message, "\n") :
    		String.format("[%s] [%s/Event] (%s) : %s%s", Reference.time.get(), method, o.toString(), message, "\n");
    }
    
    public static String event(String message, boolean println, boolean reqcolor){
    	if (println) System.out.print(String.format("%s[%s] %s[Event] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n"));
        
    	return reqcolor ? String.format("%s[%s] %s[Event] %s: %s%s", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, message, "\n") : 
        	String.format("[%s] [Event] : %s%s", Reference.time.get(), message, "\n");
    }*/
    
    public static <T> String getClassName(Class<T> c){
        return c.getSimpleName();
    }
    
    public static String getEnclosingMethod(Object o) {
    	try {
    		return o.getClass().getEnclosingMethod().getName();
    	}catch(NullPointerException e) {
    		return null;
    	}
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
