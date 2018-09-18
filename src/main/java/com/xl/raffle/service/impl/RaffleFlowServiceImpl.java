package com.xl.raffle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xl.raffle.bean.entity.OperateLog;
import com.xl.raffle.bean.entity.Present;
import com.xl.raffle.mapper.RaffleFlowMapper;
import com.xl.raffle.mapper.RaffleOperateMapper;
import com.xl.raffle.service.RaffleFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * created by XUAN on 2018/03/10
 */
@Service("raffleFlowServiceImpl")
public class RaffleFlowServiceImpl implements RaffleFlowService {

    @Autowired
    RaffleFlowMapper raffleFlowMapper;

    @Autowired
    RaffleOperateMapper raffleOperateMapper;

    @Override
    public Present queryById(Integer presentId) {
        return raffleFlowMapper.getOne(presentId);
    }

    @Override
    public void updateAmount(Integer presentId, Integer num) {
        Present present = raffleFlowMapper.getOne(presentId);
        present.setRemain(present.getRemain() - num);
        raffleFlowMapper.save(present);
    }

    @Override
    public void addOperateLog(Integer presentId, Integer num, List<Integer> nums) {
        OperateLog log = new OperateLog();
        log.setAmount(num);
        log.setPresentId(presentId);
        log.setLuckyDogs(JSONObject.toJSONString(nums));
        log.setCreateTime(new Date());
        log.setUpdateTime(new Date());
        raffleOperateMapper.save(log);
    }
}
