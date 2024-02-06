package com.get.lib.logutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.get.logutils.util.Reference;

public class LogUtil {
	
	private String dirTarget;
	
	static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	
	public LogUtil(String dirTargetPath) {
		this.dirTarget = dirTargetPath + "\\logs";
	}
	
    public String getMain(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " Main]: " + string + "\n";
    }
    
    public String getInfo(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " INFO]: " + string + "\n";
    }
    
    public <T> String getError(Class<T> classname, String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " ERROR/" + classname.getSimpleName() + "]: " + string + "\n";
    }
    
    public String getCommand(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " COMMAND]: " + string + "\n";
    }
    
    public String getDiscord(String string){
        return "["+ Reference.timeFormat.format(Calendar.getInstance().getTime()) + " DISCORD]: " + string + "\n";
    }
    
    public <T> String getClassName(Class<T> c){
        return c.getSimpleName();
    }
    
    public void mkdir() {
    	
    	File file = new File(dirTarget);
    	
    	if(!file.mkdir()) {}
    }
    
    public void writeLog(String s) throws IOException {
    	FileWriter writer = new FileWriter(dirTarget + "\\" + date.format(Calendar.getInstance().getTime()) + ".log", true);
		writer.append(s);
		writer.close();
    }
}
