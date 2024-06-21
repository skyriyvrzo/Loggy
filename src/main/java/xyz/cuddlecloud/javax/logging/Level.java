package xyz.cuddlecloud.javax.logging;

@Deprecated
public final class Level {

	private String level;
	
	public Level(String name) {
		this.level = name;
	}
	
	public static final Level MAIN = new Level("MAIN");
	public static final Level INFO = new Level("INFO");
	public static final Level WARNING = new Level("WARNING");
	public static final Level ERROR = new Level("ERROR");
	
	public String getName() {
		return level;
	}
	
}
