package xyz.cuddlecloud.javax.logging;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import xyz.cuddlecloud.javax.colorlib.ANSIEscapeColorCode;
import xyz.cuddlecloud.javax.logging.util.Reference;

import javax.swing.*;

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

	public static class Utility {
		public static String getSimpleClassName(Object klass) {
			if(klass == null) {
				return "null";
			}

			if(klass instanceof Class) {
				return ((Class<?>)klass).getSimpleName();
			}

			return klass.getClass().getSimpleName();
		}
	}

	private static Loggy loggy;
	private String path = "logs";
	private final boolean println;
	private final boolean reqColor;
	private final boolean writeFile;
	
	private Loggy(String path, boolean println, boolean reqColor, boolean writeFile) {

		OutputInterceptor.a();

		if(path != null && !path.isEmpty()) {
			this.path = path;
		}
		
		this.println = println;
		this.reqColor = reqColor;
		this.writeFile = writeFile;
		
		if(writeFile) mkdir();
	}

	public static synchronized Loggy getLoggy() {
		if(loggy == null) {
			loggy = new Loggy("", true, false, false);
		}

		return loggy;
	}

	public static synchronized Loggy getLoggy(String path) {
		if(loggy == null) {
			loggy = new Loggy(path, false, false, false);
		}

		return loggy;
	}
	
	public static synchronized Loggy getLoggy(String path, boolean println) {
		if(loggy == null) {
			loggy = new Loggy(path, println, false, false);
		}

		return loggy;
	}
	
	public static synchronized Loggy getLoggy(String path, boolean println, boolean reqColor) {
		if(loggy == null) {
			loggy = new Loggy(path, println, reqColor, false);
		}

		return loggy;
	}
	
	public static synchronized Loggy getLoggy(String path, boolean println, boolean reqColor, boolean writeFile) {
		if(loggy == null) {
			loggy = new Loggy(path, println, reqColor, writeFile);
		}
		return loggy;
	}
	
	private void mkdir() {
		File file = new File(this.path);
		
		try {
			file.mkdirs();
		}catch (Exception e) {
			log(Level.ERROR, e);
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
				log(Level.ERROR, e);
			}
		}
	}
	
	public String log(Level level, Object message) {
		
		String msg = message == null ? "null" : message.toString();

		if(level == Level.ALL) {

			String noColor = String.format("[%s] [ALL] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[ALL]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.white, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.TRACE) {

			String noColor = String.format("[%s] [TRACE] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[TRACE]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.black, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.DEBUG) {

			String noColor = String.format("[%s] [DEBUG] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[DEBUG]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.light_magenta, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.INFO) {

			String noColor = String.format("[%s] [INFO] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[INFO]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.green, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.WARN) {

			String noColor = String.format("[%s] [WARN] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[WARN]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.yellow, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.ERROR) {

			String noColor = String.format("[%s] [ERROR] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[ERROR]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.light_red, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.FATAL) {

			String noColor = String.format("[%s] [FATAL] %s\n", Reference.time.get(), msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[FATAL]%s %s\n", ANSIEscapeColorCode.blue, Reference.time.get(), ANSIEscapeColorCode.red, ANSIEscapeColorCode.white, msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.OFF) {
			return level.getName();
		}
		return null;
	}

	public String log(Level level, Object o1, Object source, Object message) {

		String object1 = o1 == null ? "null" : o1.toString();
		String object2 = source == null ? "null" : source.toString();
		String msg = message == null ? "null" : message.toString();

		if(level == Level.ALL) {
			String noColor = String.format("[%s] [%s/ALL] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/ALL] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.white,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.TRACE) {
			String noColor = String.format("[%s] [%s/TRACE] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/TRACE] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.black,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}

			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.DEBUG) {
			String noColor = String.format("[%s] [%s/DEBUG] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/DEBUG] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.light_magenta,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}
			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.INFO) {
			String noColor = String.format("[%s] [%s/INFO] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/INFO] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.green,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}
			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.WARN) {
			String noColor = String.format("[%s] [%s/WARN] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/WARN] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.yellow,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}
			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.ERROR) {
			String noColor = String.format("[%s] [%s/ERROR] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/ERROR] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.light_red,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}
			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.FATAL) {
			String noColor = String.format("[%s] [%s/FATAL] (%s) %s\n", Reference.time.get(), object1, object2, msg);

			if(println) {
				if(reqColor) {
					OutputInterceptor.out.print(String.format("%s[%s] %s[%s/FATAL] %s(%s) %s%s\n",
							ANSIEscapeColorCode.blue,
							Reference.time.get(),
							ANSIEscapeColorCode.red,
							object1,
							ANSIEscapeColorCode.cyan,
							object2,
							ANSIEscapeColorCode.white,
							msg));
				}else {
					OutputInterceptor.out.print(noColor);
				}
			}
			if(writeFile) writeFile(noColor);

			return noColor;
		}else if(level == Level.OFF) {
			return level.getName();
		}
		return null;
	}

	String b(Object o) {
		String s = o == null ? "null" : String.format("[%s] [INFO] [STDOUT]: %s",
				Reference.time.get(),
                o);

		return s;
	}

	String brr(Object o) {
		String s = o == null ? "null" : String.format("[%s] [ERROR] [STDOUT]: %s",
				Reference.time.get(),
				o);

		return s;
	}

	public String getPath() {
		return path;
	}
}
