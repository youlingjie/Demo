package com.example.excel.easyexcel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.excel.easyexcel.entity.SkuEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public interface SkuService extends IService<SkuEntity>{
    void read(MultipartFile excel) throws IOException;

    void write(HttpServletResponse response) throws IOException;
}
