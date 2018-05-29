package com.solshire.service.impl;

import com.solshire.model.domain.OrderProduct;
import com.solshire.service.OrderProductService;
import org.springframework.stereotype.Service;

@Service("orderProductService")
public class OrderProductServiceImpl extends BaseServiceImpl<OrderProduct, String> implements OrderProductService {
}