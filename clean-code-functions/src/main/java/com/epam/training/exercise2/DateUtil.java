package com.epam.training.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil.
 */
public final class DateUtil {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DateUtil.class);

    private DateUtil() {
    }

    /**
     * increment date.
     *
     * @param date      Date
     * @param increment int
     */
    public static void incrementDay(final Date date, int increment) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, increment);
        date.setTime(calendar.getTime().getTime());
    }

    /**
     * Set Time.
     *
     * @param date    date
     * @param hours   hours
     * @param minutes min
     * @param seconds sec
     */
    public static void setTime(final Date date, int hours, int minutes, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, hours);
        calendar.set(Calendar.MINUTE, minutes);
        calendar.set(Calendar.SECOND, seconds);
        //calendar.set(Calendar.MILLISECOND, millis);
        date.setTime(calendar.getTime().getTime());
    }

    /**
     * create date.
     *
     * @param year  int
     * @param month int
     * @param day   int
     * @return Date obj
     */
    public static Date create(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * entry point.
     *
     * @param args arguments
     */
    public static void main(String[] args) {

        Date date = new Date();
        incrementDay(date, -1);
        setTime(date, 0, 0, 0);
        LOGGER.debug(String.valueOf(date));
        LOGGER.debug(String.valueOf(DateUtil.create(2014, 10, 10)));
    }

}
