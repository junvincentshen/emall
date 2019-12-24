/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.jun.emall.tiny.service.impl;

import com.jun.emall.tiny.common.api.CommonResult;
import com.jun.emall.tiny.component.CancelOrderSender;
import com.jun.emall.tiny.dto.OrderParam;
import com.jun.emall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单管理Service
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        LOGGER.info("process generateOrder");

        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null, "下单成功");
    }

    private void sendDelayMessageCancelOrder(long orderId) {
        long delayTimes = 30 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }


    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作，具体参考mall项目
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }
}
