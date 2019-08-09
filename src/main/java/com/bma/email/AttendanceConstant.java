package com.bma.email;

public enum AttendanceConstant{

    NXXX0("XXX0","DownEmail"),
    //NXXX1 ="XXX1";
    NXX00("XX00","DownEmail"),
    NXX01("NXX01","UpEmail"),
    NXX10("XX10","DownEmail"),
    //NXX11 ="XX11";
    NX000("X000","LastReminder"),
    NX001("X001","UpEmail"),
    NX010("X010","ZMail"),
    //NX011 ="X011";
    NX100("X100","DownEmail"),
    NX101("X101","ZMail"),
    NX110("X110","DownEmail"),
    //NX111 ="X111"
    //N0000 ="0000"
    N0001("0001","UpEmail"),
    N0010("0010","DownEmail"),
    //N0011 ="0011"
    N0100("0100","DownEmail"),
    //N0101 ="0101"
    N0110("0110","DownEmail"),
    //N0111 ="0111"
    N1000("1000","LastReminder"),
    N1001("1001","UpEmail"),
    N1010("1010","ZMail"),
    //N1011 ="1011"
    N1100("1100","DownEmail"),
    N1101("1101","IllEmail"),
    N1110("1110","IllEmail");
    //N1111 ="1111"

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
