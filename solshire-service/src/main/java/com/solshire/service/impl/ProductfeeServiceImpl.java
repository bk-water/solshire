package com.solshire.service.impl;

import com.solshire.model.domain.Productfee;
import com.solshire.service.ProductfeeService;
import org.springframework.stereotype.Service;

@Service("productfeeService")
public class ProductfeeServiceImpl extends BaseServiceImpl<Productfee, Integer> implements ProductfeeService {
}