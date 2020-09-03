package com.project.xghk416.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;

public interface ArkRobotService {
    Boolean judgeHasOperator(String op);
}
