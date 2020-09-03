package com.project.xghk416.service.serviceImpl;

import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.pojo.dao.ArkOperatorBaseDao;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.project.xghk416.service.PublicOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicOfferingServiceImpl implements PublicOfferingService {
    @Autowired
    ArkOperatorBaseDao baseDao;

    @Override
    public List<ArkOperatorBasePo> getPublicOffering(PublicOfferingEntity items) {

        List<ArkOperatorBasePo> baseResult = baseDao.getPublicOffering(items);
        return baseResult;
    }
}
