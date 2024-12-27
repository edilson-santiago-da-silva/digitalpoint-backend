package com.sevensolutions.digitalpoint.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevensolutions.digitalpoint.domain.Point;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

public class PointDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;
    private String userName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date workDay;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entry;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime exitLaunch;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime entryLaunch;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime exit;

    private Long minExtra;


    public PointDTO() {
    }

    public PointDTO(Point obj) {
        this.id = obj.getId();
        this.userId = obj.getUser().getId();
        this.userName = obj.getUser().getName();
        this.workDay = obj.getWorkDay();
        this.entry = obj.getEntry();
        this.exitLaunch = obj.getExitLaunch();
        this.entryLaunch = obj.getEntryLaunch();
        this.exit = obj.getExit();
        this.minExtra = obj.getMinExtra();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public LocalTime getEntry() {
        return entry;
    }

    public void setEntry(LocalTime entry) {
        this.entry = entry;
    }

    public LocalTime getExitLaunch() {
        return exitLaunch;
    }

    public void setExitLaunch(LocalTime exitLaunch) {
        this.exitLaunch = exitLaunch;
    }

    public LocalTime getEntryLaunch() {
        return entryLaunch;
    }

    public void setEntryLaunch(LocalTime entryLaunch) {
        this.entryLaunch = entryLaunch;
    }

    public LocalTime getExit() {
        return exit;
    }

    public void setExit(LocalTime exit) {
        this.exit = exit;
    }

    public Long getMinExtra() {
        return minExtra;
    }

    public void setMinExtra(Long minExtra) {
        this.minExtra = minExtra;
    }
}