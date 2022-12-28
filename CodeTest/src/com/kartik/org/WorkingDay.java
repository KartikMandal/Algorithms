package com.kartik.org;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WorkingDay {
	
	/**
	 * subtract days to date in java
	 * 
	 * @param date
	 *            date
	 * @param days
	 *            days
	 * @return Date
	 */
	private static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		setTimeToBeginningOfDay(cal);
		return cal.getTime();
	}
	
	/**
	 * 
	 * @param calendar
	 */
	private static void setTimeToBeginningOfDay(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
	    Calendar startCal = Calendar.getInstance();
	    startDate=subtractDays(startDate, 1);    
	    startCal.setTime(startDate);        

	    Calendar endCal = Calendar.getInstance();
	    
	    
	    endCal.setTime(endDate);

	    int workDays = 0;

	    //Return 0 if start and end are the same
	    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
	        return 0;
	    }

	    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
	        startCal.setTime(endDate);
	        endCal.setTime(startDate);
	    }

	    do {
	       //excluding start date
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	        
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++workDays;
	        }
	    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

	    return workDays;
	}
	/**
	 * 
	 * @param dateInString
	 * @return
	 */
	public static Date conevrtDate(String dateInString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
        try {
             date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Date startDate=conevrtDate("01/04/2018");
		Date endDate=conevrtDate("1/05/2018");
		System.out.println(getWorkingDaysBetweenTwoDates(startDate, endDate));
		
		 startDate=conevrtDate("02/04/2018");
		 endDate=conevrtDate("29/04/2018");
		System.out.println(getWorkingDaysBetweenTwoDates(startDate, endDate));

	}

}
