package com.example.page.pagehelper.service;

import com.example.page.pagehelper.entity.PageResult;
import org.springframework.stereotype.Service;

/**
* @author Y
* @description 针对表【page】的数据库操作Service
* @createDate 2023-07-15 21:59:57
*/
@Service
public interface PageHelperService {

    PageResult pagehelper(Integer pageIndex, Integer paseSize);
}
