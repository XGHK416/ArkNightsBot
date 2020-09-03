package com.project.xghk416.pojo.dao;

import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.pojo.po.ArkOperatorBasePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author XGHK416
 * @since 2020-07-15
 */
public interface ArkOperatorBaseDao extends BaseMapper<ArkOperatorBasePo> {
    ArkOperatorBasePo getBaseAttribute(@Param("name") String name);

    @Select("select operator_sort_id from ark_operator_base")
    List<Integer> getAllOp();

    @Select("<script>" +
            "select * from (" +
            "select * from (" +
            "select * from (" +
            "select * from ark_operator_base where operator_approach like '%公开招募%' " +
            "<if test='item.hasHeightElite'>" +
            "and operator_rarity=5 " +
            "</if>" +
            "<if test='!item.hasHeightElite'>" +
            "and operator_rarity &lt; 5 " +
            "</if>" +
            "<if test='item.hasElite'>" +
            "and operator_rarity=4 " +
            "</if>" +
            "<if test='item.hasNew'>" +
            "and operator_rarity=1 " +
            "</if>" +
            ") as a " +
//            position
            "Where 1=1 " +
            "<foreach collection='item.position' item='pitem'>" +
            "and operator_position = #{pitem} " +
            "</foreach> " +
            ") As b " +
//            tag
            "Where 1=1 " +
            "<foreach collection='item.tag' item='titem'>" +
            "and operator_tag like '%${titem}#%' " +
            "</foreach> " +
            ") As c " +
//            profession
            "Where 1=1 " +
            "<foreach collection='item.profession' item='citem'>" +
            "and operator_class = #{citem} " +
            "</foreach> " +
            "order by operator_rarity DESC"+
            "</script>")
    List<ArkOperatorBasePo> getPublicOffering(@Param("item") PublicOfferingEntity item);
}
