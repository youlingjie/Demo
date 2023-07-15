package com.example.excel.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;

@Data
@TableName(value = "tb_sku",autoResultMap = true)
public class SkuEntity extends AbstractEntity implements Serializable {
    @TableId(value = "sku_id",type = IdType.ASSIGN_ID)
    private Long skuId;//sku_id

    @ExcelProperty(index = 0)
    @TableField(value = "sku_name")
    private String skuName;//商品名称

    @ExcelProperty(index = 1)
    @TableField(value = "sku_image")
    private String skuImage;//商品图片

    @ExcelProperty(index = 2)
    @TableField(value = "price")
    private Integer price;//基础价格

    @ExcelProperty(index = 3)
    @TableField(value = "class_id")
    private Integer classId;//商品类别Id

    @ExcelProperty(index = 4)
    @TableField(value = "is_discount")
    private boolean discount;//是否打折促销

    @ExcelProperty(index = 5)
    @TableField(value = "unit")
    private String unit;//净含量

    @ExcelProperty(index = 6)
    @TableField(value = "brand_name")
    private String brandName;//商品品牌

}
