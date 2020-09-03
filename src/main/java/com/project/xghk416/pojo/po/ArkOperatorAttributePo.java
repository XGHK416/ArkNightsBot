package com.project.xghk416.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
@TableName("ark_operator_attribute")
public class ArkOperatorAttributePo extends Model<ArkOperatorAttributePo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 干员名称
     */
    @JsonProperty("operator_name")
    private String operatorName;

    /**
     * 干员编号
     */
    @JsonProperty("operator_index")
    private String operatorIndex;

    /**
     * 精英化
     */
    @JsonProperty("elite_rank")
    private String eliteRank;

    /**
     * 攻击
     */
    @JsonProperty("operator_atk")
    private String operatorAtk;

    /**
     * 防御
     */
    @JsonProperty("operator_def")
    private String operatorDef;

    /**
     * 法抗
     */
    @JsonProperty("operator_res")
    private String operatorRes;

    /**
     * 生命
     */
    @JsonProperty("operator_hp")
    private String operatorHp;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
