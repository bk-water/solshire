package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.ShowQuery;
import com.solshire.model.domain.ShowData;

public interface ShowDataService extends BaseService<ShowData, Integer> {

    void save(ShowData info);

    PageInfo<ShowData> queryByPage(ShowQuery query);
}