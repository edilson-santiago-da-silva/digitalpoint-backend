package com.sevensolutions.digitalpoint.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sevensolutions.digitalpoint.domain.dtos.PointDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "tb_point")
public class Point implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;

    @Temporal(TemporalType.DATE)
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

    @ManyToOne
    @JoinColumn(name = "user_id" )
    private User user;

    public Point() {

    }

    public Point(Integer id, String userName, Date workDay, LocalTime entry, LocalTime entryLaunch, LocalTime exitLaunch, LocalTime exit, Long minExtra, User user) {
        this.id = id;
        this.workDay = workDay;
        this.userName = userName;
        this.entry = entry;
        this.entryLaunch = entryLaunch;
        this.exitLaunch = exitLaunch;
        this.exit = exit;
        this.minExtra = minExtra;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public long getExtraHour(LocalTime entry, LocalTime exitLaunch, LocalTime entryLaunch, LocalTime exit){
        long workload = 440L;
        long intervalPattern = 60L;
        long extraHours = 0L;
        long minTotal = Duration.between(entry, exit).toMinutes();

        if ((minTotal - intervalPattern) > workload){
            extraHours = minTotal - workload  - intervalPattern;
        }
        return extraHours;
    }
}
