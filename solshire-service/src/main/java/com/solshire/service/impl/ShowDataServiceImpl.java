package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.solshire.mapper.ShowDataMapper;
import com.solshire.model.RichesEntity;
import com.solshire.model.ShowQuery;
import com.solshire.model.domain.ShowData;
import com.solshire.service.ShowDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("showDataService")
public class ShowDataServiceImpl extends BaseServiceImpl<ShowData, Integer> implements ShowDataService {

    @Autowired
    ShowDataMapper showDataMapper;

    @Override
    public void save(ShowData info) {
        if (info.getId()== null) {
            info.setAddtime(new Date());
            insertUnchecked(info);
        } else {
            update(info);
        }
    }

    @Override
    public PageInfo<ShowData> queryByPage(ShowQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ShowData> result = showDataMapper.queryByPage(query);
        //
        return new PageInfo<>(result);
    }
}