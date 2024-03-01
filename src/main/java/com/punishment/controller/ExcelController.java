package com.punishment.controller;

import com.alibaba.excel.EasyExcel;
import com.punishment.domain.vo.ExcelVo;
import com.punishment.listener.DataListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * excel 控制器
 */

@RestController
@RequestMapping("/excel")
public class ExcelController {

    /**
     * 导入excel
     * @param file
     * @throws IOException
     */
    @PostMapping("/import")
    public void importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelVo.class, new DataListener()).sheet("22学年-24学年").doRead();
    }

}
