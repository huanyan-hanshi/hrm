package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.lin.entity.Position;

import java.util.List;
@Mapper
public interface PositionDao extends BaseMapper<Position> {
    int insertSelective(Position record);

    int updateByPrimaryKeySelective(Position record);
    Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}
