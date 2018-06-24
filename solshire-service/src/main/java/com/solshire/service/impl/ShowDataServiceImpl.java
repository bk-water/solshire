package com.solshire.service.impl;

import com.solshire.model.domain.ShowData;
import com.solshire.service.ShowDataService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("showDataService")
public class ShowDataServiceImpl extends BaseServiceImpl<ShowData, Integer> implements ShowDataService {
    @Override
    public void save(ShowData info) {
        if (info.getId()== null) {
            info.setAddtime(new Date());
            insertUnchecked(info);
        } else {
            update(info);
        }
    }
}