package com.example.excel.easyexcel.service;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.excel.easyexcel.entity.SkuEntity;
import com.example.excel.easyexcel.listener.SkuListener;
import com.example.excel.easyexcel.mapper.SkuDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Slf4j
public class SkuServiceImpl extends ServiceImpl<SkuDao, SkuEntity> implements SkuService{
    @Autowired
    private SkuListener skuListener;

    @Autowired
    private SkuDao skuDao;
    @Override
    public void read(MultipartFile excel) throws IOException {
        InputStream inputStream = excel.getInputStream();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(inputStream, SkuEntity.class,skuListener).sheet().doRead();
    }

    @Override
    public void write(HttpServletResponse response) throws IOException {

        String fileName = new String("导出excel.xlsx".getBytes(), StandardCharsets.ISO_8859_1);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        List<SkuEntity> list = skuDao.selectList(null);
        ServletOutputStream outputStream = response.getOutputStream();
        EasyExcel.write(outputStream, SkuEntity.class)
                .sheet("sheet1")
                .doWrite(list);
    }
}
