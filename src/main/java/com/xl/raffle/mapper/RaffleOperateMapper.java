package com.xl.raffle.mapper;

import com.xl.raffle.bean.entity.OperateLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by XUAN on 2018/03/10
 */
public interface RaffleOperateMapper extends JpaRepository<OperateLog, Integer> {
}
