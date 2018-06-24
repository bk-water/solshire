package com.solshire.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.solshire.mapper.RichesMapper;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;
import com.solshire.service.RichesService;
import com.solshire.util.BeanCopierUtils;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("richesService")
public class RichesServiceImpl extends BaseServiceImpl<Riches, Integer> implements RichesService {

    @Autowired
    RichesMapper richesMapper;


    @Override
    public PageInfo<RichesEntity> queryByPage(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<RichesEntity> result = richesMapper.queryByPage(query);
        //
        return new PageInfo<>(result);
    }

    @Override
    public List<RichesEntity> queryChildren(Integer richeid) {
        RichesQuery query = new RichesQuery();
        query.setRicheid(richeid);
        //
        return richesMapper.queryChildren(query);
    }

    @Override
    public PageInfo<RichesEntity> queryChildrenByPage(RichesQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        //
        List<RichesEntity> result = richesMapper.queryChildren(query);
        return new PageInfo<>(result);
    }

    @Override
    public RichesEntity queryById(Integer richeId) {
        Riches info = selectByPk(richeId);
        // 获取级别
        // Integer level = richesMapper.queryLevel(richeId,1);
        RichesEntity result = BeanCopierUtils.copyProperties(info,RichesEntity.class);
        return result;
    }

    @Override
    public void save(Riches info) {
        if (info.getRicheid() == null) {
            info.setAddtime(new Date());
            insert(info);
        } else {
            update(info);
        }
    }
}