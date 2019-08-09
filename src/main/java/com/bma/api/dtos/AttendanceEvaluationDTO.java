package com.bma.api.dtos;

import java.io.Serializable;
import java.util.Date;

public class AttendanceEvaluationDTO implements Serializable {

    private Integer id;
    private Integer attended1;
    private Integer attended2;
    private Integer attended3;
    private Integer attended4;
    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttended1() {
        return attended1;
    }

    public void setAttended1(Integer attended1) {
        this.attended1 = attended1;
    }

    public Integer getAttended2() {
        return attended2;
    }

    public void setAttended2(Integer attended2) {
        this.attended2 = attended2;
    }

    public Integer getAttended3() {
        return attended3;
    }

    public void setAttended3(Integer attended3) {
        this.attended3 = attended3;
    }

    public Integer getAttended4() {
        return attended4;
    }

    public void setAttended4(Integer attended4) {
        this.attended4 = attended4;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
