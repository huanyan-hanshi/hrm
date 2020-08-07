package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.MenuDao;
import com.lin.dao.MenuRoleDao;
import com.lin.entity.Hr;
import com.lin.entity.Menu;
import com.lin.entity.MenuRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuDao menuDao;
    @Autowired
    MenuRoleDao menuRoleDao;
    public List<Menu> getMenusByHrId() {
        return menuDao.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuDao.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuDao.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuDao.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleDao.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleDao.insertRecord(rid, mids);
        return result==mids.length;
    }
}
