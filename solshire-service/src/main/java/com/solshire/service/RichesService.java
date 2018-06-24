package com.solshire.service;

import com.github.pagehelper.PageInfo;
import com.solshire.model.RichesEntity;
import com.solshire.model.RichesQuery;
import com.solshire.model.domain.Riches;

import java.util.List;
import java.util.Map;

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

    RichesEntity queryById(Integer richeId);

    void save(Riches info);

    /**
     * 獲取證件號與用戶對應map關係
     * @param certifyNos
     * @return
     */
    Map<String, Riches> queryCertifyNoMap(List<String> certifyNos);

    /**
     * 獲取用戶id 與詳情對應關係
     * @param ids
     * @return
     */
    Map<Integer, Riches> queryIdMap(List<Integer> ids);


}