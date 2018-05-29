package com.solshire.service.impl;

import com.solshire.model.domain.ShowData;
import com.solshire.service.ShowDataService;
import org.springframework.stereotype.Service;

@Service("showDataService")
public class ShowDataServiceImpl extends BaseServiceImpl<ShowData, Integer> implements ShowDataService {
}