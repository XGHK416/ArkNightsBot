package com.project.xghk416.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.ArkRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ArkRobotServiceImpl")
public class ArkRobotServiceImpl implements ArkRobotService {
    @Autowired
    ArkOperatorBaseDao baseDao;

    @Override
    public Boolean judgeHasOperator(String op){
        QueryWrapper<ArkOperatorBasePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*").eq("operator_cn",op);
        ArkOperatorBasePo arkOperatorBasePo = baseDao.selectOne(queryWrapper);
//        System.out.println(arkOperatorBasePo);
        return arkOperatorBasePo==null;
    }
}
