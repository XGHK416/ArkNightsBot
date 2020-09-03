package com.project.xghk416.service;

import com.project.xghk416.pojo.po.ArkOperatorBasePo;

import java.util.List;

public interface ArkPrintService {
    List<Integer> getAllOp();

    ArkOperatorBasePo getBase(String index);
}
