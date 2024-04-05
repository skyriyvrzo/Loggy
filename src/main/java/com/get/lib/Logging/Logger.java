package com.get.lib.Logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.get.lib.colorlib.ANSIEscapeColorCode;

public final class Logger {

	private String path;
	private boolean println;
	private boolean reqColor;
	private boolean writeFile;
	
	private Logger(String path, boolean println, boolean reqColor, boolean writeFile) {
		this.path = path;
		this.println = println;
		this.reqColor = reqColor;
		this.writeFile = writeFile;
		
		if(writeFile) mkdir();
	}
	
	public static Logger getLogger(String path, boolean println, boolean reqColor, boolean writeFile) {
		return new Logger(path, println, reqColor, writeFile);
	}
	
	private void mkdir() {
		File file = new File(this.path);
		
		try {
			file.mkdir();
		}catch (Exception e) {
			log(Level.ERROR, e.getMessage());
		}
	}
	
	private void writeFile(Object object) {
		boolean writeSuccessful = false;
		String fileName = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".log";
		String filePath = path + "/" + fileName;
		
		while(!writeSuccessful) {
			try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath, true))) {
				wr.write(object.toString());
				writeSuccessful = true;
			} catch(IOException e) {
				log(Level.ERROR, e.getMessage());
			}
		}
	}
	
	public String log(Level level, Object message) {
		String msg = message.toString();
		
		if(level == Level.MAIN) {
			
			String time = LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String noColor = String.format("[%s] [MAIN] : %s", time, msg);
			
			if(println) {
				if(reqColor) {
					System.out.println(String.format("%s[%s] %s[MAIN] %s: %s", ANSIEscapeColorCode.blue, time, ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.println(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.INFO) {
			String time = LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String noColor = String.format("[%s] [INFO] : %s", time, msg);
			
			if(println) {
				if(reqColor) {
					System.out.println(String.format("%s[%s] %s[INFO] %s: %s", ANSIEscapeColorCode.blue, time, ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.println(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.WARNING) {
			String time = LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String noColor = String.format("[%s] [WARN] : %s", time, msg);
			
			if(println) {
				if(reqColor) {
					System.out.println(String.format("%s[%s] %s[WARN] %s: %s", ANSIEscapeColorCode.yellow, time, ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.println(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.ERROR) {
			String time = LocalDate.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			String noColor = String.format("[%s] [ERROR] : %s", time, msg);
			
			if(println) {
				if(reqColor) {
					System.out.println(String.format("%s[%s] %s[ERROR] %s: %s", ANSIEscapeColorCode.red, time, ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.println(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}
		
		return null;
	}
	
	public static String log(Level level, Object o1, Object o2, Object message) {
		return null;
	}
}
