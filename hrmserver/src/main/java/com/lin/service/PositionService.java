package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.PoliticsstatusDao;
import com.lin.dao.PositionDao;
import com.lin.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PositionService {
    @Autowired
    PositionDao positionDao;
    public List<Position> getAllPositions() {
        return positionDao.selectList(new QueryWrapper<Position>().select("*"));
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionDao.insertSelective(position);
    }

    public Integer updatePositions(Position position) {
        return positionDao.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        return positionDao.deleteById(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
        return positionDao.deletePositionsByIds(ids);
    }
}
