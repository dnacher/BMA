package com.bma.email;

public enum AttendanceConstant{

    NXX01("XX01","UpEmail"),
    NX001("X001","UpEmail"),
    N0001("0001","UpEmail"),
    N1001("1001","UpEmail"),
    N1101("1101","UpEmail"),
    N1000("1000","LastReminder"),
    NX000("X000","LastReminder"),
    NX010("X010","Z"),
    NX101("X101","Z"),
    N1010("1010","Z"),
    N0101("0101","Z"),
    NXX00("XX00","DownEmail"),
    NXX10("XX10","DownEmail"),
    NX100("X100","DownEmail"),
    NX110("X110","DownEmail"),
    N0010("0010","DownEmail"),
    N0100("0100","DownEmail"),
    N0110("0110","DownEmail"),
    N1100("1100","DownEmail"),
    N1110("1110","DownEmail"),
    NNNNN("NNNN","NONE");


    private String attendance;
    private String emailType;

    AttendanceConstant(String attendance, String emailType){
        this.attendance = attendance;
        this.emailType = emailType;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getEmailType() {
        return emailType;
    }
}
