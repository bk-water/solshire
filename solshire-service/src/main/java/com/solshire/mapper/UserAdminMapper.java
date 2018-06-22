package com.solshire.mapper;

import com.solshire.model.UserAdminInfo;
import com.solshire.model.domain.UserAdmin;
import com.solshire.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserAdminMapper extends BaseMapper<UserAdmin> {
}