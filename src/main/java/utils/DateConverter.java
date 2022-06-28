package utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static LocalDate convertStringToLocalDate(String date) {
        String[] array = date.split("-");
        return LocalDate.of(Integer.parseInt(array[0]), Integer.parseInt(array[1]),
                Integer.parseInt(array[2]));
    }

    public static String convertIsoToDmyString(String date) {
        String[] array = date.split("-");
        return array[2] + "."  + array[1] + "." + array[0];
    }

    public static LocalDate convertDmyStringToIso(String date) {
        String[] array = date.split("\\.");
        return LocalDate.of(Integer.parseInt(array[2]), Integer.parseInt(array[1]),
                Integer.parseInt(array[0]));
    }

    public static LocalTime convertStringToLocalTime(String time) {
        String[] array = time.split(":");
        return LocalTime.of(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
    }

    /**
     * Completes a time value when not in HH:MM:SS format
     * @param time time value
     * @return LocalTime in HH:MM:SS
     */
    public static LocalTime autoCompleteTime(String time) {
        if (time.length() < 3) {
            time += ":00:00";
        } else if (time.length() < 6) {
            time += ":00";
        }
        String[] array = time.split(":");
        return LocalTime.of(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
    }
}
