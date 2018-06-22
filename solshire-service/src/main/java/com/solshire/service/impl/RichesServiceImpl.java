package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.solshire.mapper.RichesMapper;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.service.RichesService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("richesService")
public class RichesServiceImpl extends BaseServiceImpl<Riches, Integer> implements RichesService {

    @Autowired
    RichesMapper richesMapper;


    @Override
    public PageInfo<RichesEntity> queryByPage(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<RichesEntity> result = richesMapper.queryByPage(query);
        return new PageInfo<>(result);
    }

    @Override
    public PageInfo<RichesEntity> queryChildren(Integer richeid) {
        return null;
    }

    @Override
    public PageInfo<RichesEntity> queryChildrenByPage(RichesQuery query) {
        return null;
    }
}