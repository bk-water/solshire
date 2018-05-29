package com.solshire.service.impl;

import com.solshire.model.domain.Insuranceplan;
import com.solshire.service.InsuranceplanService;
import org.springframework.stereotype.Service;

@Service("insuranceplanService")
public class InsuranceplanServiceImpl extends BaseServiceImpl<Insuranceplan, Integer> implements InsuranceplanService {
}