package com.expanse.tracker.utils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateUtils {

    // Common date patterns
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    // Private constructor to prevent instantiation
    private DateUtils() {}

    // ✅ Convert String to LocalDate
    public static LocalDate toLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DEFAULT_FORMATTER);
    }

    // ✅ Convert String to LocalDate with custom pattern
    public static LocalDate toLocalDate(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateStr, formatter);
    }

    // ✅ Convert LocalDate to String
    public static String format(LocalDate date) {
        return date.format(DEFAULT_FORMATTER);
    }

    // ✅ Convert LocalDate to String with custom format
    public static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    // ✅ Convert java.util.Date to LocalDate
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // ✅ Convert LocalDateTime to String
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DATE_TIME_FORMATTER);
    }
}
