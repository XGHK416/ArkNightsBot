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
@TableName("ark_operator_potential")
public class ArkOperatorPotentialPo extends Model<ArkOperatorPotentialPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 潜能
     */
    @JsonProperty("potential_rank")
    private String potentialRank;

    /**
     * 干员编号
     */
    @JsonProperty("operator_id")
    private String operatorId;

    /**
     * 效果
     */
    private String effect;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
