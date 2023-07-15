package com.example.excel.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AbstractEntity implements Serializable {

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ExcelProperty(index = 7)
    protected LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @ExcelProperty(index = 8)
    protected LocalDateTime updateTime;
}
