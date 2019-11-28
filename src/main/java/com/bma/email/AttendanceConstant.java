package com.bma.email;

public enum AttendanceConstant{

    N0111("0111","DownEmail"),
    N0XXX("0XXX","DownEmail"),
    N00XX("00XX","DownEmail"),
    N01XX("01XX","DownEmail"),
    N011X("011X","DownEmail"),
    N001X("001X","DownEmail"),
    N0100("0100","DownEmail"),
    N0010("0010","DownEmail"),
    N0110("0110","DownEmail"),
    N0011("0011","DownEmail"),
    N1011("1011","UpEmail"),
    N10XX("10XX","UpEmail"),
    N100X("100X","UpEmail"),
    N1000("1000","UpEmail"),
    N1001("1001","UpEmail"),
    N010X("010X","Z"),
    N101X("101X","Z"),
    N0101("0101","Z"),
    N0001("0001","LastReminder"),
    N000X("000X","LastReminder");

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
