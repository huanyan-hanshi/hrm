package com.lin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.dao.HrDao;
import com.lin.dao.HrRoleDao;
import com.lin.entity.Hr;
import com.lin.entity.HrRole;
import com.lin.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrDao hrDao;
    @Autowired
    HrRoleDao hrRoleDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr= (Hr) hrDao.selectOne(new QueryWrapper<Hr>().select("*").eq("username",s));
        if (hr==null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        hr.setRoles(hrDao.getHrRolesById(hr.getId()));
        return hr;
    }
    public List<Hr> getAllHrs(String keywords) {
        return hrDao.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrDao.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleDao.delete(new QueryWrapper<HrRole>().eq("hrid",hrid));
        return hrRoleDao.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteHrById(Integer id) {
        return hrDao.deleteById(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
        return hrDao.selectList(new QueryWrapper<Hr>().select("*").ne("id",HrUtils.getCurrentHr().getId()));
    }

    public Integer updateHyById(Hr hr) {
        return hrDao.updateByPrimaryKeySelective(hr);
    }

    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
        Hr hr = hrDao.selectById(hrid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldpass, hr.getPassword())) {
            String encodePass = encoder.encode(pass);
            Integer result = hrDao.updatePasswd(hrid, encodePass);
            if (result == 1) {
                return true;
            }
        }
        return false;
    }

    public Integer updateUserface(String url, Integer id) {
        return hrDao.updateUserface(url, id);
    }
}
