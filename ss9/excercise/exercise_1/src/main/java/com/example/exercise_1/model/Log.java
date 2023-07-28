package com.example.exercise_1.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String msg;
    @Column(name = "last_time")
    private Timestamp lastTime;
    @Column(name = "count")
    private Long count;
    public Log() {
    }

    public Log(Long id, String msg, Timestamp lastTime, Long count) {
        this.id = id;
        this.msg = msg;
        this.lastTime = lastTime;
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }
}
