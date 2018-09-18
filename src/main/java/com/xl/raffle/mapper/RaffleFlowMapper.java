package com.xl.raffle.mapper;

import com.xl.raffle.bean.entity.Present;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by XUAN on 2018/03/10
 */
public interface RaffleFlowMapper extends JpaRepository<Present, Integer> {
}
