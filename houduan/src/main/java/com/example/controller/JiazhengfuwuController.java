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
import com.example.entity.Jiazhengfuwu;
import com.example.exception.CustomException;
import com.example.service.JiazhengfuwuService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.JiazhengfuwuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/jiazhengfuwu")
public class JiazhengfuwuController {

    @Resource
    private JiazhengfuwuService jiazhengfuwuService;

    @PostMapping
    public Result<Jiazhengfuwu> add(@RequestBody JiazhengfuwuVo jiazhengfuwu) {
		//yoxuxiaxnci
        jiazhengfuwuService.add(jiazhengfuwu);
        return Result.success(jiazhengfuwu);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("fuwumingcheng","服务名称");        row.put("leibie","类别");        row.put("fuwujiage","服务价格");        row.put("fuwushichang","服务时长");        row.put("fuwujianjie","服务简介");        row.put("gonghao","工号");        row.put("mingzi","名字");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = jiazhengfuwuService.daochuexcel();
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
    public Result<Jiazhengfuwu> deleteList(@RequestBody JiazhengfuwuVo jiazhengfuwu) {
        jiazhengfuwuService.deleteList(jiazhengfuwu.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        jiazhengfuwuService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody JiazhengfuwuVo jiazhengfuwu) {
        jiazhengfuwuService.update(jiazhengfuwu);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Jiazhengfuwu> detail(@PathVariable Integer id) {
        Jiazhengfuwu jiazhengfuwu = jiazhengfuwuService.findById(id);
        return Result.success(jiazhengfuwu);
    }

    @GetMapping
    public Result<List<Jiazhengfuwu>> all() {
        return Result.success(jiazhengfuwuService.list());
    }

    @PostMapping("/page")
    public Result<JiazhengfuwuVo> page(@RequestBody JiazhengfuwuVo jiazhengfuwuVo) {
        return Result.success(jiazhengfuwuService.findPage(jiazhengfuwuVo));
    }
	//youupdt2login
}
