package com.lin.dao;

import com.lin.entity.Appraise;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppraiseDao {
    int insertSelective(Appraise record);

    int updateByPrimaryKeySelective(Appraise record);
}
