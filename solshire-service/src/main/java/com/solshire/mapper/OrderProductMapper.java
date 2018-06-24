package com.solshire.mapper;

import com.solshire.model.ConsumerEntity;
import com.solshire.model.OrderProductEntity;
import com.solshire.model.ProductQuery;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.OrderProduct;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    /**
     * 查詢客戶信息
     * @param query
     * @return
     */
    List<ConsumerEntity> listConsumer(RichesQuery query);

    /**
     * 保单查询
     * @param query
     * @return
     */
    List<OrderProductEntity> query(ProductQuery query);
}