package com.example.page.pagehelper.controller;

import com.example.page.pagehelper.entity.PageResult;
import com.example.page.pagehelper.entity.Result;
import com.example.page.pagehelper.service.PageHelperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
@Slf4j
public class PageHelperController {
    @Autowired
    private PageHelperService pagehelperService;

    @GetMapping("/pagehelper")
    public Result<PageResult> page(@RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer paseSize) {
        PageResult pageResult= pagehelperService.pagehelper(pageIndex,paseSize);
        return Result.success(pageResult);
    }
}