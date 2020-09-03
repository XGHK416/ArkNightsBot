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
@TableName("ark_elite_material")
public class ArkEliteMaterialPo extends Model<ArkEliteMaterialPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String operatorIndex;

    @JsonProperty("elite_rank")
    private String eliteRank;

    @JsonProperty("material_pic")
    private String materialPic;

    @JsonProperty("material_name")
    private String materialName;

    @JsonProperty("material_num")
    private String materialNum;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
