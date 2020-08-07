package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.MenuRole;
@Mapper
public interface MenuRoleDao extends BaseMapper<MenuRole> {
    int insertSelective(MenuRole record);

    int updateByPrimaryKeySelective(MenuRole record);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
