package com.lin.dao;

import com.lin.entity.SysMsg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMsgDao {
    int insertSelective(SysMsg record);

    int updateByPrimaryKeySelective(SysMsg record);
}
