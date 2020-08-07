package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Nation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NationDao extends BaseMapper<Nation> {
    int insertSelective(Nation record);

    int updateByPrimaryKeySelective(Nation record);
}
