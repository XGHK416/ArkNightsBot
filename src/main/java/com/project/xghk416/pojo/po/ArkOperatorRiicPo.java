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
@TableName("ark_operator_riic")
public class ArkOperatorRiicPo extends Model<ArkOperatorRiicPo> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonProperty("operator_index")
    private String operatorIndex;

    @JsonProperty("riic_name")
    private String riicName;

    @JsonProperty("riic_pic")
    private String riicPic;

    @JsonProperty("riic_condition")
    private String riicCondition;

    @JsonProperty("riic_room")
    private String riicRoom;

    @JsonProperty("riic_des")
    private String riicDes;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
