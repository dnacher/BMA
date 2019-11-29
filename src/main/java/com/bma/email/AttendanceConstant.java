package com.bma.email;

public enum AttendanceConstant{

    N0111("0111","DownEmail",1),
    N0XXX("0XXX","DownEmail",1),
    N00XX("00XX","DownEmail",1),
    N01XX("01XX","DownEmail",1),
    N011X("011X","DownEmail",1),
    N001X("001X","DownEmail",1),
    N0100("0100","DownEmail",1),
    N0010("0010","DownEmail",1),
    N0110("0110","DownEmail",1),
    N0011("0011","DownEmail",1),
    N1011("1011","UpEmail",2),
    N10XX("10XX","UpEmail",2),
    N100X("100X","UpEmail",2),
    N1000("1000","UpEmail",2),
    N1001("1001","UpEmail",2),
    N010X("010X","Z",3),
    N101X("101X","Z",3),
    N0101("0101","Z",3),
    N1010("1010","Z",3),
    N0001("0001","LastReminder",4),
    N000X("000X","LastReminder",4),
    NNNNN("NNNN","NONE",-1);


    private String attendance;
    private String emailType;

    AttendanceConstant(String attendance, String emailType, Integer numberTyp){
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
