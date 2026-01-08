package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.Fuwuleibie;
import com.example.exception.CustomException;
import com.example.service.FuwuleibieService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.FuwuleibieVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/fuwuleibie")
public class FuwuleibieController {

    @Resource
    private FuwuleibieService fuwuleibieService;

    @PostMapping
    public Result<Fuwuleibie> add(@RequestBody FuwuleibieVo fuwuleibie) {
		//yoxuxiaxnci
        fuwuleibieService.add(fuwuleibie);
        return Result.success(fuwuleibie);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("leibie","类别");        row.put("beizhu","备注");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = fuwuleibieService.daochuexcel();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=chaoba.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Fuwuleibie> deleteList(@RequestBody FuwuleibieVo fuwuleibie) {
        fuwuleibieService.deleteList(fuwuleibie.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        fuwuleibieService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody FuwuleibieVo fuwuleibie) {
        fuwuleibieService.update(fuwuleibie);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Fuwuleibie> detail(@PathVariable Integer id) {
        Fuwuleibie fuwuleibie = fuwuleibieService.findById(id);
        return Result.success(fuwuleibie);
    }

    @GetMapping
    public Result<List<Fuwuleibie>> all() {
        return Result.success(fuwuleibieService.list());
    }

    @PostMapping("/page")
    public Result<FuwuleibieVo> page(@RequestBody FuwuleibieVo fuwuleibieVo) {
        return Result.success(fuwuleibieService.findPage(fuwuleibieVo));
    }
	//youupdt2login
}
