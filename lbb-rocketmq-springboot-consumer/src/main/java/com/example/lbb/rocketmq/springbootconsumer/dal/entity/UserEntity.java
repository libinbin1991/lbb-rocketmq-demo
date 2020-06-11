/*
package com.example.lbb.rocketmq.springbootconsumer.dal.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

*/
/**
 * <p>
 *
 * </p>
 *
 * @author lizhuo
 * @since 2019-02-23
 *//*

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserEntity extends Model<UserEntity> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private Integer age;


    */
/**
     * 主键值
     *//*

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
*/
