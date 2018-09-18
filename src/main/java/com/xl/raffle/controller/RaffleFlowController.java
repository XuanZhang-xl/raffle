package com.xl.raffle.controller;

import com.xl.raffle.bean.BaseResponse;
import com.xl.raffle.bean.entity.Present;
import com.xl.raffle.enums.ResponseNutEnum;
import com.xl.raffle.service.RaffleFlowService;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * created by XUAN on 2018/03/09
 */
@RestController
public class RaffleFlowController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RaffleFlowController.class);

    @Autowired
    RaffleFlowService raffleFlowService;

    static List<Integer> existedNums = new ArrayList<Integer>();

    static List<Integer> allNums = new ArrayList<Integer>();

    /**
     * 所有的号码
     */
    static Integer[] allNumArr = new Integer[349];

    static {
        for (int i = 5209051; i <= 5209299; i++) {
            allNums.add(i);
        }
        for (int i = 5209501; i <= 5209600; i++) {
            allNums.add(i);
        }
        for (Integer i = 0; i < 349; i++) {
            allNumArr[i] = allNums.get(i);
        }
    }

    @GetMapping("begin")
    public BaseResponse begin(Integer presentId, Integer num) {
        logger.info("presentId: {}, num: {}", presentId, num);
        BaseResponse response = new BaseResponse();
        Present present = raffleFlowService.queryById(presentId);
        if (present == null) {
            return response.buildFailedResponse(ResponseNutEnum.GIFT_NOT_FIND);
        }
        if (present.getRemain() - num < 0) {
            return response.buildFailedResponse(ResponseNutEnum.GIFT_FINISHED);
        }
        raffleFlowService.updateAmount(presentId, num);
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            Integer newNum = allNumArr[new BigDecimal(Math.random() * allNumArr.length).intValue()];
            if (existedNums.size() == allNumArr.length) {
                // 所有号码全部抽完
                return response.buildFailedResponse(ResponseNutEnum.NO_GIFT_NUM_ANY_MORE);
            }
            if (existedNums.contains(newNum)) {
                i--;
                continue;
            } else {
                existedNums.add(newNum);
            }
            nums.add(newNum);
        }
        raffleFlowService.addOperateLog(presentId, num, nums);
        logger.info("返回的数字是: {}", nums);
        logger.info("已经抽到的数字是: {}", existedNums);
        response.setData(nums);
        return response;
    }

    public static void main(String[] args){
        int size = allNumArr.length;
        int i = 0;
        while (true) {
            i++;
            int index = new BigDecimal(Math.random() * size).intValue();
            allNums.remove(allNumArr[index]);
            if (allNums.size() == 0) {
                System.out.println("所有数字都可以遍历到, 共遍历了" + i + "次");
                return;
            }
            if (i > 100000) {
                System.out.println(allNums);
                System.out.println(allNums.size());
                return;
            }
        }
    }

    @GetMapping("fake_num")
    public BaseResponse fakeNum(Integer num) {
        logger.info("fakeNum的数量: {}", num);
        BaseResponse response = new BaseResponse();
        Integer basicNum = 5200000;
        Integer numberOfPeople = 330;
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            nums.add(basicNum + new BigDecimal(Math.random() * numberOfPeople).intValue());
        }
        logger.info("fakeNum的值为: {}", nums);
        response.setData(nums);
        return response;
    }

    @GetMapping("basic_page")
    public ModelAndView basicPage() {
        ModelAndView mv = new ModelAndView("BasicPage");
        return mv;
    }
}
