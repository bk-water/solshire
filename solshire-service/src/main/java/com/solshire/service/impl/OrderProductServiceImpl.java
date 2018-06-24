package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.solshire.mapper.OrderProductMapper;
import com.solshire.model.*;
import com.solshire.model.domain.OrderData;
import com.solshire.model.domain.OrderProduct;
import com.solshire.model.domain.Productfee;
import com.solshire.model.domain.Riches;
import com.solshire.service.OrderDataService;
import com.solshire.service.OrderProductService;
import com.solshire.service.ProductfeeService;
import com.solshire.service.RichesService;
import com.solshire.util.BeanCopierUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("orderProductService")
public class OrderProductServiceImpl extends BaseServiceImpl<OrderProduct, String> implements OrderProductService {

    @Autowired
    OrderProductMapper orderProductMapper;

    @Autowired
    RichesService richesService;

    @Autowired
    OrderDataService orderDataService;

    @Autowired
    ProductfeeService productfeeService;

    @Override
    public PageInfo<ConsumerEntity> listConsumer(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ConsumerEntity> result = orderProductMapper.listConsumer(query);
        List<String> certifyNos = new ArrayList<>();
        List<Integer> adviserIds = new ArrayList<>();
        for (ConsumerEntity entity: result) {
            certifyNos.add(entity.getCertifyno());
            adviserIds.add(entity.getAdviserId());
        }
        Map<String, Riches> certifyNoMap = richesService.queryCertifyNoMap(certifyNos);
        Map<Integer, Riches> adviserIdMap = richesService.queryIdMap(adviserIds);

        for (ConsumerEntity entity: result) {
            // 判空
            Riches adviser = adviserIdMap.get(entity.getAdviserId());
            if (adviser!=null)
            entity.setAdviserName(adviser.getName());
            Riches user = certifyNoMap.get(entity.getCertifyno());
            if (user!= null)
            entity.setRicheid(user.getRicheid());
        }

        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<OrderProductEntity> queryPage(ProductQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<OrderProductEntity> result = orderProductMapper.query(query);
        List<Integer> adviserIds = new ArrayList<>();
        for (OrderProductEntity entity: result) {
            adviserIds.add(entity.getRicheid());
        }
        Map<Integer, Riches> adviserIdMap = richesService.queryIdMap(adviserIds);

        for (OrderProductEntity entity: result) {
            Riches user = adviserIdMap.get(entity.getRicheid());
            if (user!= null)
                entity.setAdviserName(user.getName());
        }

        return new PageInfo<>(result);
    }

    @Override
    public OrderProductDetailEntity queryDetailInfoByPolicyNo(String policyNo) {
        OrderProductDetailEntity detailInfo = new OrderProductDetailEntity();
        OrderProductEntity productEntity = queryByPolicyNo(policyNo);
        detailInfo.setProductInfo(productEntity);
        RichesEntity adviserInfo = richesService.queryById(productEntity.getRicheid());
        detailInfo.setAdviserInfo(adviserInfo);
        OrderData query = new OrderData();
        query.setPolicyno(policyNo);
        query.setFlag((short) 2);
        OrderData holderInfo = orderDataService.selectOne(query);
        query.setFlag((short) 1);
        OrderData insurantInfo = orderDataService.selectOne(query);
        detailInfo.setHolderInfo(holderInfo);
        detailInfo.setInsurantInfo(insurantInfo);
        return detailInfo;
    }

    @Override
    public OrderProductEntity queryByPolicyNo(String policyNo) {
        OrderProduct orderProduct = selectByPk(policyNo);
        OrderProductEntity result = BeanCopierUtils.copyProperties(orderProduct,OrderProductEntity.class);

        Productfee fee = productfeeService.selectByPk(orderProduct.getFeeid());
        if (fee!= null) {
            if (fee.getPayage() == 0) {
                result.setExpiryDate("终身");
            } else {
                result.setExpiryDate(fee.getPayage() + "年");
            }
        }
        return result;
    }
}