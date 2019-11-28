package com.bma.email;

public class EmailEvaluation {

    public String checkAttendance(String attendance){
        for(AttendanceConstant value: AttendanceConstant.values()){
            if(attendance.equals(value.getAttendance())){
                return value.getEmailType();
            }
        }
        return null;
    }



}
