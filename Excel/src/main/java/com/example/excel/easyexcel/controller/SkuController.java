package com.example.excel.easyexcel.controller;

import com.example.excel.easyexcel.service.SkuService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/excel")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @PostMapping("/sku/i")
    public void easyexcelImport(@RequestParam MultipartFile excel) throws IOException {
        log.info("{}", excel);
        skuService.read(excel);
    }



    @SneakyThrows
    @GetMapping("/sku/o")
    public void easyexcelExport(HttpServletResponse response) {
        skuService.write(response);
    }
}