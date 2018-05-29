package com.solshire.mapper;

import com.solshire.model.domain.OrderProduct;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
}