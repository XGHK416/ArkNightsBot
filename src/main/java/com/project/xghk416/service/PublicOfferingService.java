package com.project.xghk416.service;

import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;

import java.util.List;

public interface PublicOfferingService {
    List<ArkOperatorBasePo> getPublicOffering(PublicOfferingEntity items);
}
