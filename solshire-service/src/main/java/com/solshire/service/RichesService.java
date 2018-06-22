package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;

import java.util.List;

public interface RichesService extends BaseService<Riches, Integer> {
    PageInfo<RichesEntity> queryByPage(RichesQuery query);

    /**
     * 查询子节点
     * @param richeid
     * @return
     */
    List<RichesEntity> queryChildren(Integer richeid);

    /**
     * 分页查询下级用户
     * @param query
     * @return
     */
    PageInfo<RichesEntity> queryChildrenByPage(RichesQuery query);
}