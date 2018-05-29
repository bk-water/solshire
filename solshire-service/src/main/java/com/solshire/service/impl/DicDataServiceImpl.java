package com.solshire.service.impl;

import com.solshire.model.domain.DicData;
import com.solshire.service.DicDataService;
import org.springframework.stereotype.Service;

@Service("dicDataService")
public class DicDataServiceImpl extends BaseServiceImpl<DicData, String> implements DicDataService {
}