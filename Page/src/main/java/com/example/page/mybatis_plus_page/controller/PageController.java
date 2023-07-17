package com.example.page.mybatis_plus_page.controller;


import com.example.page.mybatis_plus_page.entity.PageEntity;
import com.example.page.mybatis_plus_page.entity.Pager;
import com.example.page.mybatis_plus_page.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("page")
@Slf4j
public class PageController {
    @Autowired
    private PageService pageService;

    @GetMapping("/page_plus")
    public Pager<PageEntity> page(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") Long pageIndex,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "10") Long paseSize) {
        Pager<PageEntity> pager = pageService.page_plus(pageIndex,paseSize);
        return pager;
    }
}
