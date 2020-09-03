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
@TableName("ark_operator_talent")
public class ArkOperatorTalentPo extends Model<ArkOperatorTalentPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("operator_name")
    private String operatorName;

    @JsonProperty("operator_index")
    private String operatorIndex;

    /**
     * 获取条件
     */
    private String condition;

    @JsonProperty("talent_name")
    private String talentName;

    @JsonProperty("talent_position")
    private String talentPosition;

    @JsonProperty("talent_des")
    private String talentDes;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
