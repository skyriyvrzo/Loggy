package com.get.lib.Logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.get.lib.Logging.util.Reference;
import com.get.lib.colorlib.ANSIEscapeColorCode;

public final class Logger {

	private String path = "logs";
	private boolean println;
	private boolean reqColor;
	private boolean writeFile;
	
	private Logger(String path, boolean println, boolean reqColor, boolean writeFile) {
		
		if(path != null && path != "") {
			this.path = path;
		}
		
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
		
		String msg = message.toString() == null ? null : message.toString();
		
		if(level == Level.MAIN) {
			
			String noColor = String.format("[%s] [MAIN] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[MAIN] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.INFO) {

			String noColor = String.format("[%s] [INFO] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[INFO] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.WARNING) {

			String noColor = String.format("[%s] [WARN] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[WARN] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.yellow, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.ERROR) {

			String noColor = String.format("[%s] [ERROR] : %s \n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[ERROR] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.red, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}
		
		return null;
	}
	
	public String log(Level level, Object o1, Object o2, Object message) {
		
		String object1 = o1.toString() == null ? null : o1.toString();
		String object2 = o2.toString() == null ? null : o2.toString();
		String msg = message.toString() == null ? null : message.toString();
		
		if(level == Level.MAIN) {
			String noColor = String.format("[%s] [%s/MAIN] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/MAIN] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.green,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					System.out.print(noColor);
				}
				
				if(writeFile) writeFile(noColor);
				
				return noColor;
			} 
		}else if(level == Level.INFO) {
			String noColor = String.format("[%s] [%s/INFO] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/INFO] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.green,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					System.out.print(noColor);
				}
				
				if(writeFile) writeFile(noColor);
				
				return noColor;
			} 
		}else if(level == Level.WARNING) {
			String noColor = String.format("[%s] [%s/WARNING] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/WARNING] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.yellow,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					System.out.print(noColor);
				}
				
				if(writeFile) writeFile(noColor);
				
				return noColor;
			} 
		}else if(level == Level.ERROR) {
			String noColor = String.format("[%s] [%s/ERROR] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/ERROR] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.red,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					System.out.print(noColor);
				}
				
				if(writeFile) writeFile(noColor);
				
				return noColor;
			} 
		}
		return null;
	}
}
