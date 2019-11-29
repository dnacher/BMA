package com.bma.email;

import java.util.ArrayList;
import java.util.List;

public class EmailObject {

    private List<EmailItem> downEmail;
    private List<EmailItem> upEmail;
    private List<EmailItem> z;
    private List<EmailItem> lastReminder;

    public EmailObject(){
        this.downEmail = new ArrayList<>();
        this.upEmail = new ArrayList<>();
        this.z = new ArrayList<>();
        this.lastReminder = new ArrayList<>();
    }

    public List<EmailItem> getDownEmail() {
        return downEmail;
    }

    public void setDownEmail(List<EmailItem> downEmail) {
        downEmail = downEmail;
    }

    public List<EmailItem> getUpEmail() {
        return upEmail;
    }

    public void setUpEmail(List<EmailItem> upEmail) {
        upEmail = upEmail;
    }

    public List<EmailItem> getZ() {
        return z;
    }

    public void setZ(List<String> z) {
        z = z;
    }

    public List<EmailItem> getLastReminder() {
        return lastReminder;
    }

    public void setLastReminder(List<EmailItem> lastReminder) {
        lastReminder = lastReminder;
    }
}
