package com.project.xghk416.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.ArkSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArkSelectServiceImpl implements ArkSelectService {
    @Autowired
    ArkOperatorBaseDao baseDao;

    @Override
    public List<ArkOperatorBasePo> getAll() {
        QueryWrapper<ArkOperatorBasePo> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        return baseDao.selectList(wrapper);
    }
}
