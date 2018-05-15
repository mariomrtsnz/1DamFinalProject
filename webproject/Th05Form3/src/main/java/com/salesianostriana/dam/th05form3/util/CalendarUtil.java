package com.salesianostriana.dam.th05form3.util;

import java.util.Calendar;

public class CalendarUtil {

    public static Calendar calendarFor(final int year,  final int month, final int day) {
        
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        return cal;
        
    }
    
    private CalendarUtil() {
        super();
 }
	
}
