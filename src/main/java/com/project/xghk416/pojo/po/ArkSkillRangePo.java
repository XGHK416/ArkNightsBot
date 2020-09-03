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
@TableName("ark_skill_range")
public class ArkSkillRangePo extends Model<ArkSkillRangePo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("operator_index")
    private String operatorIndex;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("skill_range")
    private String skillRange;

    @JsonProperty("skill_limits")
    private String skillLimits;

    @JsonProperty("skill_range_url")
    private String skillRangeUrl;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
