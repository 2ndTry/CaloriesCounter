package com.alexeymiroshnikov.caloriescounter.util;

import java.time.LocalTime;

public class TimeUtil {

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTine) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTine) < 0;
    }
}
