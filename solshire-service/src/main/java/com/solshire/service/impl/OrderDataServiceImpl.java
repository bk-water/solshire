package com.solshire.service.impl;

import com.solshire.model.domain.OrderData;
import com.solshire.service.OrderDataService;
import org.springframework.stereotype.Service;

@Service("orderDataService")
public class OrderDataServiceImpl extends BaseServiceImpl<OrderData, Integer> implements OrderDataService {
}