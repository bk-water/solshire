package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.*;
import com.solshire.model.domain.OrderProduct;

public interface OrderProductService extends BaseService<OrderProduct, String> {

    /**
     * 獲取客戶列表
     * @param query
     * @return
     */
    PageInfo<ConsumerEntity> listConsumer(RichesQuery query);

    /**
     * 保单列表
     * @param query
     * @return
     */
    PageInfo<OrderProductEntity> queryPage(ProductQuery query);

    /**
     * 根据保单号获取保单详情
     * @param policyNo
     * @return
     */
    OrderProductDetailEntity queryDetailInfoByPolicyNo(String policyNo);

    /**
     * 根据保单号查询产品详情
     * @param policyNo
     * @return
     */
    OrderProductEntity queryByPolicyNo(String policyNo);
}