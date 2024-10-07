package com.sevensolutions.digitalpoint.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.Objects;

public class Point implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private Date day;
    private LocalTime entry;
    private LocalTime exitLaunch;
    private LocalTime entryLaunch;
    private LocalTime exit;

    public Point() {

    }

    public Point(Integer id, String userName, Date day, LocalTime entry, LocalTime entryLaunch, LocalTime exitLaunch, LocalTime exit) {
        this.id = id;
        this.userName = userName;
        this.day = day;
        this.entry = entry;
        this.entryLaunch = entryLaunch;
        this.exitLaunch = exitLaunch;
        this.exit = exit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
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

    public LocalTime getExtraHour(){
        return LocalTime.now(); // Cálculo do metódo posteriormente
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Objects.equals(id, point.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
