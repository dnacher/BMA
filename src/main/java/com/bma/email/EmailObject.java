package com.bma.email;

import java.util.ArrayList;
import java.util.List;

public class EmailObject {

    private List<String> downEmail;
    private List<String> upEmail;
    private List<String> z;
    private List<String> lastReminder;

    public EmailObject(){
        this.downEmail = new ArrayList<>();
        this.upEmail = new ArrayList<>();
        this.z = new ArrayList<>();
        this.lastReminder = new ArrayList<>();
    }

    public List<String> getDownEmail() {
        return downEmail;
    }

    public void setDownEmail(List<String> downEmail) {
        downEmail = downEmail;
    }

    public List<String> getUpEmail() {
        return upEmail;
    }

    public void setUpEmail(List<String> upEmail) {
        upEmail = upEmail;
    }

    public List<String> getZ() {
        return z;
    }

    public void setZ(List<String> z) {
        z = z;
    }

    public List<String> getLastReminder() {
        return lastReminder;
    }

    public void setLastReminder(List<String> lastReminder) {
        lastReminder = lastReminder;
    }
}
