package com.project.xghk416.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author XGHK416
 * @since 2020-07-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ark_operator_base")
public class ArkOperatorBasePo extends Model<ArkOperatorBasePo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 中文名
     */
    @JsonProperty("operator_cn")
    private String operatorCn;

    /**
     * 定位
     */
    @JsonProperty("operator_position")
    private String operatorPosition;

    /**
     * 英文名
     */
    private String operatorEn;

    /**
     * 性别
     */
    @JsonProperty("operator_sex")
    private String operatorSex;

    /**
     * 标签
     */
    @JsonProperty("operator_tag")
    private String operatorTag;

    /**
     * 种族
     */
    @JsonProperty("operator_race")
    private String operatorRace;

    /**
     * 稀有度
     */
    @JsonProperty("operator_rarity")
    private Integer operatorRarity;

    /**
     * 职业
     */
    @JsonProperty("operator_class")
    private String operatorClass;

    /**
     * 来源
     */
    private String operatorApproach;

    /**
     * 标签
     */
    @JsonProperty("operator_camp")
    private String operatorCamp;

    /**
     * 队伍
     */
    private String operatorTeam;

    /**
     * 描述
     */
    @JsonProperty("operator_des")
    private String operatorDes;

    /**
     * 特性
     */
    @JsonProperty("operator_feature")
    private String operatorFeature;

    /**
     * 力量
     */
    private String operatorStr;

    /**
     * 机动
     */
    private String operatorFlex;

    /**
     * 忍受
     */
    private String operatorTolerance;

    /**
     * 指挥力
     */
    private String operatorPlan;

    /**
     * 技巧
     */
    private String operatorSkill;

    /**
     * 源石技艺
     */
    private String operatorAdapt;

    /**
     * 合同评价
     */
    private String operatorMoredes;

    /**
     * 头像
     */
    @JsonProperty("operator_icon")
    private String operatorIcon;

    /**
     * 半身像
     */
    @JsonProperty("operator_half")
    private String operatorHalf;

    /**
     * 初始hp
     */
    @TableField("operator_oriHp")
    private Integer operatorOrihp;

    /**
     * 初始攻击
     */
    @TableField("operator_oriAtk")
    private Integer operatorOriatk;

    /**
     * 初始防御
     */
    @TableField("operator_oriDef")
    private Integer operatorOridef;

    /**
     * 初始法抗
     */
    @TableField("operator_oriRes")
    private Integer operatorOrires;

    /**
     * 再部署
     */
    @JsonProperty("operator_oriDt")
    @TableField("operator_oriDt")
    private String operatorOridt;

    /**
     * 费用
     */
    @JsonProperty("operator_oriDc")
    @TableField("operator_oriDc")
    private String operatorOridc;

    /**
     * 阻挡数
     */
    @JsonProperty("operator_oriBlock")
    @TableField("operator_oriBlock")
    private String operatorOriblock;

    /**
     * 攻速
     */
    @JsonProperty("operator_oriCd")
    @TableField("operator_oriCd")
    private String operatorOricd;

    /**
     * 编号
     */
    private String operatorIndex;

    /**
     * index
     */
    @JsonProperty("operator_sortId")
    private Integer operatorSortId;

    /**
     * 日文名
     */
    private String operatorJp;

    /**
     * 出生地
     */
    private String operatorBirthplace;

    /**
     * 属性
     */
    private List<ArkOperatorAttributePo> attribute;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
