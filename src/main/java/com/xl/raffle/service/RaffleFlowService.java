package com.xl.raffle.service;

import com.xl.raffle.bean.entity.Present;

import java.util.List;

/**
 * created by XUAN on 2018/03/10
 */
public interface RaffleFlowService {
    Present queryById(Integer presentId);

    void updateAmount(Integer presentId, Integer num);

    void addOperateLog(Integer presentId, Integer num, List<Integer> nums);
}
