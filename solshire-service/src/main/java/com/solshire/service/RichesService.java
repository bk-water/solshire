package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;

public interface RichesService extends BaseService<Riches, Integer> {
    PageInfo<RichesEntity> queryByPage(RichesQuery query);
}