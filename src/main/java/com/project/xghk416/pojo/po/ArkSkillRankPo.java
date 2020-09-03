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
@TableName("ark_skill_rank")
public class ArkSkillRankPo extends Model<ArkSkillRankPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("operator_index")
    private String operatorIndex;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("skill_rank")
    private String skillRank;

    @JsonProperty("skill_des")
    private String skillDes;

    /**
     * 初始
     */
    @JsonProperty("skill_ori")
    private String skillOri;

    /**
     * 消耗
     */
    @JsonProperty("skill_consume")
    private String skillConsume;

    /**
     * 持续
     */
    @JsonProperty("skill_keep")
    private String skillKeep;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
