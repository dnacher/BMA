package com.bma.utils;

import com.bma.exception.BMAException;
import org.eclipse.jetty.http.HttpStatus;

public class Utils {

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

}
