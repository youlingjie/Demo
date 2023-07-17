package com.example.page.pagehelper.mapper;


import com.example.page.pagehelper.entity.PageHelperEntity;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
* @author Y
* @description 针对表【page】的数据库操作Mapper
* @createDate 2023-07-15 21:59:57
* @Entity com.example.page.pagehelper.entity.PageHelperEntity
*/
public interface PageHelperMapper {
    @Select("select * from page")
    List<PageHelperEntity> page();
}




