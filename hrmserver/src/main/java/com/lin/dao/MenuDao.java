package com.lin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuDao extends BaseMapper<Menu> {
    int insertSelective(Menu record);

    int updateByPrimaryKeySelective(Menu record);

    List<Menu> getMenusByHrId(Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);
}
