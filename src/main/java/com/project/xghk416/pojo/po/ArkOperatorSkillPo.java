package com.project.xghk416.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@TableName("ark_operator_skill")
public class ArkOperatorSkillPo extends Model<ArkOperatorSkillPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("operator_index")
    private String operatorIndex;

    @JsonProperty("skill_position")
    private String skillPosition;

    @JsonProperty("skill_name")
    private String skillName;

    @JsonProperty("skill_pic")
    private String skillPic;

    @JsonProperty("recover_type")
    private String recoverType;

    @JsonProperty("release_type")
    private String releaseType;

    @JsonProperty("is_passive")
    private Integer isPassive;

    private List<ArkSkillRankPo> skill_ranks;

    private Map<String,List<ArkSkillMaterialPo>> skill_material;

    private List<ArkSkillRangePo> skill_ranges;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
