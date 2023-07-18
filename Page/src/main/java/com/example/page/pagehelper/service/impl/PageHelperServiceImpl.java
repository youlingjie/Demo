package com.example.page.pagehelper.service.impl;


import com.example.page.pagehelper.entity.PageHelperEntity;
import com.example.page.pagehelper.entity.PageResult;
import com.example.page.pagehelper.mapper.PageHelperMapper;
import com.example.page.pagehelper.service.PageHelperService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Y
 * @description 针对表【page】的数据库操作Service实现
 * @createDate 2023-07-15 21:59:57
 */
@Service
public class PageHelperServiceImpl implements PageHelperService {

    @Autowired
    private PageHelperMapper pageHelperMapper;
    @Override
    public PageResult pagehelper(Integer pageIndex, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(pageIndex, pageSize);
        //执行条件分页查询
        List<PageHelperEntity> empList = pageHelperMapper.page();
        //获取查询结果
        Page<PageHelperEntity> p = (Page<PageHelperEntity>) empList;
        //封装Page
        PageResult pageResult = new PageResult(p.getTotal(), p.getResult());
        return pageResult;
    }
}




