package xyz.cuddlecloud.javax.logging.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Supplier;

public final class Reference {
	
    public static final String Version = "0.2";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public static final Supplier<String> time = () -> timeFormat.format(Calendar.getInstance().getTime());
    
}
