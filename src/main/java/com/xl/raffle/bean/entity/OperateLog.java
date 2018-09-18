package com.xl.raffle.bean.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * created by XUAN on 2018/03/10
 */
@DynamicUpdate
@Entity
@Table(name = "t_raffle_operate_log")
public class OperateLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer presentId;

    private Integer amount;

    private String luckyDogs;

    private Date createTime;

    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPresentId() {
        return presentId;
    }

    public void setPresentId(Integer presentId) {
        this.presentId = presentId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getLuckyDogs() {
        return luckyDogs;
    }

    public void setLuckyDogs(String luckyDogs) {
        this.luckyDogs = luckyDogs;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
