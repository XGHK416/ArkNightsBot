package com.project.xghk416.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.ArkPrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArkPrintServiceImpl implements ArkPrintService {
    @Autowired
    ArkOperatorBaseDao operatorBaseDao;
    @Override
    public List<Integer> getAllOp() {
        return operatorBaseDao.getAllOp();
    }

    @Override
    public ArkOperatorBasePo getBase(String index) {
        QueryWrapper<ArkOperatorBasePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*").eq("operator_sort_id",index);
        ArkOperatorBasePo result = operatorBaseDao.selectOne(queryWrapper);
        result.setOperatorRarity((result.getOperatorRarity()+1));
        return result;
    }
}
