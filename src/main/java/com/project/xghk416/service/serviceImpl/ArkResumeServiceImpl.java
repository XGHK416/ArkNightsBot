package com.project.xghk416.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.xghk416.pojo.dao.*;
import com.project.xghk416.pojo.po.*;
import com.project.xghk416.pojo.po.ArkEliteMaterialPo;
import com.project.xghk416.service.ArkResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArkResumeServiceImpl implements ArkResumeService {
    @Autowired
    ArkOperatorBaseDao baseDao;
    @Autowired
    ArkOperatorAttributeDao attributeDao;
    @Autowired
    ArkOperatorRangeDao rangeDao;
    @Autowired
    ArkEliteMaterialDao eliteMaterialDao;
    @Autowired
    ArkOperatorTalentDao talentDao;
    @Autowired
    ArkOperatorPotentialDao potentialDao;
    @Autowired
    ArkOperatorRiicDao riicDao;
    @Autowired
    ArkOperatorSkillDao operatorSkillDao;
    @Autowired
    ArkSkillMaterialDao skillMaterialDao;
    @Autowired
    ArkSkillRangeDao skillRangeDao;
    @Autowired
    ArkSkillRankDao skillRankDao;

    @Override
    public ArkOperatorBasePo getBase(String index) {
        QueryWrapper<ArkOperatorBasePo> baseQueryWrapper = new QueryWrapper<>();
        QueryWrapper<ArkOperatorAttributePo> attributeQueryWrapper = new QueryWrapper<>();
        baseQueryWrapper.select("*").eq("operator_sort_id",Integer.parseInt(index));
        attributeQueryWrapper.select("*").eq("operator_index",index);
        ArkOperatorBasePo baseResult = baseDao.selectOne(baseQueryWrapper);
        baseResult.setOperatorTag(baseResult.getOperatorTag().replace("#","  "));
        baseResult.setOperatorRarity((baseResult.getOperatorRarity()+1));
        List<ArkOperatorAttributePo> attributeResultList = attributeDao.selectList(attributeQueryWrapper);
        baseResult.setAttribute(attributeResultList);
        return baseResult;
    }

    @Override
    public List<ArkOperatorRangePo> getRange(String index) {
        QueryWrapper<ArkOperatorRangePo> rangeQueryWrapper = new QueryWrapper<>();
        rangeQueryWrapper.select("*").eq("operator_index",index);
        return rangeDao.selectList(rangeQueryWrapper);
    }

    @Override
    public Map<String, List<ArkEliteMaterialPo>> getEliteMaterial(String index) {
        QueryWrapper<ArkEliteMaterialPo> eliteMaterialQueryWrapper = new QueryWrapper<>();
        eliteMaterialQueryWrapper.select("*").eq("operator_index",index);
        List<ArkEliteMaterialPo> resultList = eliteMaterialDao.selectList(eliteMaterialQueryWrapper);
//        对数据进行进一步处理，按照精英化等级分类
        Map<String,List<ArkEliteMaterialPo>> eliteResultMap = new HashMap<>();
        for (ArkEliteMaterialPo list : resultList) {
            List<ArkEliteMaterialPo> eliteList = eliteResultMap.get(list.getEliteRank()); //如果取不到数据，new一个新数组
            if (null == eliteList) {
                eliteList = new ArrayList<ArkEliteMaterialPo>();
                eliteList.add(list);
                eliteResultMap.put(list.getEliteRank(), eliteList);
            } else {
                eliteList.add(list); //如果之前已经存放过，就直接追加到原来的List里面
            }
        }
        return eliteResultMap;
    }

    @Override
    public List<ArkOperatorTalentPo> getTalent(String index) {
        QueryWrapper<ArkOperatorTalentPo> talentQueryWrapper = new QueryWrapper<>();
        talentQueryWrapper.select("*").eq("operator_index",index);
        return talentDao.selectList(talentQueryWrapper);
    }

    @Override
    public List<ArkOperatorPotentialPo> getPotential(String index) {
        QueryWrapper<ArkOperatorPotentialPo> potentialQueryWrapper = new QueryWrapper<>();
        potentialQueryWrapper.select("*").eq("operator_id",index);
        return potentialDao.selectList(potentialQueryWrapper);
    }

    @Override
    public List<ArkOperatorRiicPo> getRiic(String index) {
        QueryWrapper<ArkOperatorRiicPo> riicQueryWrapper = new QueryWrapper<>();
        riicQueryWrapper.select("*").eq("operator_index",index);
        return riicDao.selectList(riicQueryWrapper);
    }

    @Override
    public List<ArkOperatorSkillPo> getSkill(String index,String rank) {
        QueryWrapper<ArkOperatorSkillPo> opSkillQueryWrapper = new QueryWrapper<>();

        opSkillQueryWrapper.select("*").eq("operator_index",index);
        List<ArkOperatorSkillPo> skillResult = operatorSkillDao.selectList(opSkillQueryWrapper);
        for (ArkOperatorSkillPo item :
                skillResult) {
            String skill_index = item.getSkillId();
            item.setSkill_material(writeInSkillMaterial(skill_index));
            item.setSkill_ranges(writeInSkillRanges(skill_index));
            item.setSkill_ranks(writeInSkillRanks(skill_index,rank));
        }
        return skillResult;
    }

    private List<ArkSkillRankPo> writeInSkillRanks(String skill_index,String rank) {
        QueryWrapper<ArkSkillRankPo> skillRankQueryWrapper = new QueryWrapper<>();
        if (!"default".equals(rank)){
            skillRankQueryWrapper.select("*").eq("skill_id",skill_index).eq("skill_rank",rank);
        }else{
            skillRankQueryWrapper.select("*").eq("skill_id",skill_index);
        }
        return skillRankDao.selectList(skillRankQueryWrapper);
    }

    private List<ArkSkillRangePo> writeInSkillRanges(String skill_index) {
        QueryWrapper<ArkSkillRangePo> skillRangeQueryWrapper = new QueryWrapper<>();
        skillRangeQueryWrapper.select("*").eq("skill_id",skill_index);
        return skillRangeDao.selectList(skillRangeQueryWrapper);
    }

    private Map<String, List<ArkSkillMaterialPo>> writeInSkillMaterial(String skill_index) {
        QueryWrapper<ArkSkillMaterialPo> skillMaterialQueryWrapper = new QueryWrapper<>();
        skillMaterialQueryWrapper.select("*").eq("skill_id",skill_index);
        List<ArkSkillMaterialPo> materialList = skillMaterialDao.selectList(skillMaterialQueryWrapper);
        Map<String, List<ArkSkillMaterialPo>> result = new HashMap<>();
        for (ArkSkillMaterialPo list : materialList) {
            List<ArkSkillMaterialPo> materialUnit = result.get(list.getSkillRank()); //如果取不到数据，new一个新数组
            if (null == materialUnit) {
                materialUnit = new ArrayList<ArkSkillMaterialPo>();
                materialUnit.add(list);
                result.put(list.getSkillRank(), materialUnit);
            } else {
                materialUnit.add(list); //如果之前已经存放过，就直接追加到原来的List里面
            }
        }
        return result;
    }


}
