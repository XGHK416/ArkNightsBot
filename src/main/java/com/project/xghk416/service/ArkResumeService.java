package com.project.xghk416.service;

import com.project.xghk416.pojo.po.*;
import com.project.xghk416.pojo.po.ArkEliteMaterialPo;

import java.util.List;
import java.util.Map;

public interface ArkResumeService {
    ArkOperatorBasePo getBase(String name);

    List<ArkOperatorRangePo> getRange(String name);

    Map<String,List<ArkEliteMaterialPo>> getEliteMaterial(String index);

    List<ArkOperatorTalentPo> getTalent(String index);

    List<ArkOperatorPotentialPo> getPotential(String index);

    List<ArkOperatorRiicPo> getRiic(String index);

    List<ArkOperatorSkillPo> getSkill(String index,String rank);
}
