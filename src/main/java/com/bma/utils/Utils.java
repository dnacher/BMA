package com.bma.utils;

import com.bma.exception.BMAException;
import org.eclipse.jetty.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    public static final Integer GMT = -3;

    public static void validateIdNull(Integer id, String errorMsg){
        if (id != null) {
            throw new BMAException(HttpStatus.BAD_REQUEST_400, errorMsg);
        }
    }

    public static void validateUrlIdEqualsBodyId(int urlId, Integer bodyId, String errorMsg){
        if (bodyId == null || urlId != bodyId.intValue()) {
            throw new BMAException(HttpStatus.BAD_REQUEST_400, errorMsg);
        }
    }

    public static Date setDateToSave(Date date){
        //, Integer GMTTime
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, (GMT*-1));
        return cal.getTime();
    }

    public static Date setTodayDate(){
        Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);
        return today;
    }

}
