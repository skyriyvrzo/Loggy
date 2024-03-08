package com.get.lib.logutils.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Supplier;

public class Reference {
	
    public static final String Version = "1.6.2-beta21";
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public static final Supplier<String> time = () -> timeFormat.format(Calendar.getInstance().getTime());
    
}
