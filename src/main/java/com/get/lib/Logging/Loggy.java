package com.get.lib.Logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.get.lib.Logging.util.Reference;
import com.get.lib.colorlib.ANSIEscapeColorCode;

public final class Loggy {

	public enum Level {
		ALL(Integer.MIN_VALUE),
		TRACE(400),
		DEBUG(500),
		INFO(700),
		WARN(800),
		ERROR(900),
		FATAL(1000),
		OFF(Integer.MAX_VALUE);
		
		private final int severity;
		
		private Level(int severity) {
			this.severity = severity;
		}
		
		public final String getName() {
			return name();
		}
		
		public final int getSeverity() {
			return severity;
		}
	}
	
	private String path = "logs";
	private boolean println;
	private boolean reqColor;
	private boolean writeFile;
	
	private Loggy(String path, boolean println, boolean reqColor, boolean writeFile) {
		
		if(path != null && path != "") {
			this.path = path;
		}
		
		this.println = println;
		this.reqColor = reqColor;
		this.writeFile = writeFile;
		
		if(writeFile) mkdir();
	}
	
	public static final Loggy getLoggy(String path) {
		return new Loggy(path, false, false, false);
	}
	
	public static final Loggy getLoggy(String path, boolean println) {
		return new Loggy(path, println, false, false);
	}
	
	public static final Loggy getLoggy(String path, boolean println, boolean reqColor) {
		return new Loggy(path, println, reqColor, false);
	}
	
	public static final Loggy getLoggy(String path, boolean println, boolean reqColor, boolean writeFile) {
		return new Loggy(path, println, reqColor, writeFile);
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
		
		if(level == Level.ALL) {
			
			String noColor = String.format("[%s] [ALL] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[ALL] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.white, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.TRACE) {

			String noColor = String.format("[%s] [TRACE] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[TRACE] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.black, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.DEBUG) {

			String noColor = String.format("[%s] [DEBUG] : %s\n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[DEBUG] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.light_magenta, ANSIEscapeColorCode.white, msg));
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
		}else if(level == Level.WARN) {

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
					System.out.print(String.format("%s[%s] %s[ERROR] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.light_red, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.FATAL) {

			String noColor = String.format("[%s] [FATAL] : %s \n", Reference.time.get(), msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[FATAL] %s: %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.red, ANSIEscapeColorCode.white, msg));
				}else {
					System.out.print(noColor);
				}
			}
			
			if(writeFile) writeFile(noColor);
			
			return noColor;
		}else if(level == Level.OFF) {
			return level.getName();
		}
		return null;
	}
	
	public String log(Level level, Object o1, Object o2, Object message) {
		
		String object1 = o1.toString() == null ? null : o1.toString();
		String object2 = o2.toString() == null ? null : o2.toString();
		String msg = message.toString() == null ? null : message.toString();
		
		if(level == Level.ALL) {
			String noColor = String.format("[%s] [%s/ALL] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/ALL] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.white,
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
		}else if(level == Level.TRACE) {
			String noColor = String.format("[%s] [%s/TRACE] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/TRACE] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.black,
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
		}else if(level == Level.DEBUG) {
			String noColor = String.format("[%s] [%s/DEBUG] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/DEBUG] %s(%s) %s: %s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.light_magenta,
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
		}else if(level == Level.WARN) {
			String noColor = String.format("[%s] [%s/WARN] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/WARN] %s(%s) %s: %s\n",
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
							ANSIEscapeColorCode.light_red,
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
		}else if(level == Level.FATAL) {
			String noColor = String.format("[%s] [%s/FATAL] (%s) : %s\n", Reference.time.get(), object1, object2, msg);
			
			if(println) {
				if(reqColor) {
					System.out.print(String.format("%s[%s] %s[%s/FATAL] %s(%s) %s: %s\n",
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
		}else if(level == Level.OFF) {
			return level.getName();
		}
		return null;
	}
}
