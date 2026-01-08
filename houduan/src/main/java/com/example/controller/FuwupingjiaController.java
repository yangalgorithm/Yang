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
import com.example.entity.Fuwupingjia;
import com.example.exception.CustomException;
import com.example.service.FuwupingjiaService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.FuwupingjiaVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/fuwupingjia")
public class FuwupingjiaController {

    @Resource
    private FuwupingjiaService fuwupingjiaService;

    @PostMapping
    public Result<Fuwupingjia> add(@RequestBody FuwupingjiaVo fuwupingjia) {
		//yoxuxiaxnci
        fuwupingjiaService.add(fuwupingjia);
        return Result.success(fuwupingjia);
    }
	
	    @GetMapping("/fuwupingjia_tj_gonghao")
    public Result fuwupingjia_tj_gonghao() {
        return Result.success(fuwupingjiaService.fuwupingjia_tj_gonghao());
    }


    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("fuwumingcheng","服务名称");
        row.put("fuwujiage","服务价格");
        row.put("gonghao","工号");
        row.put("manyiqingkuang","满意情况");
        row.put("pingjianeirong","评价内容");
        row.put("yonghuming","用户名");
        row.put("xingming","姓名");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = fuwupingjiaService.daochuexcel();
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
    public Result<Fuwupingjia> deleteList(@RequestBody FuwupingjiaVo fuwupingjia) {
        fuwupingjiaService.deleteList(fuwupingjia.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        fuwupingjiaService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody FuwupingjiaVo fuwupingjia) {
        fuwupingjiaService.update(fuwupingjia);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Fuwupingjia> detail(@PathVariable Integer id) {
        Fuwupingjia fuwupingjia = fuwupingjiaService.findById(id);
        return Result.success(fuwupingjia);
    }

    @GetMapping
    public Result<List<Fuwupingjia>> all() {
        return Result.success(fuwupingjiaService.list());
    }

    @PostMapping("/page")
    public Result<FuwupingjiaVo> page(@RequestBody FuwupingjiaVo fuwupingjiaVo) {
        return Result.success(fuwupingjiaService.findPage(fuwupingjiaVo));
    }
	//youupdt2login
}
