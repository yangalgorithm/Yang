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
import com.example.entity.Yuyuejiazheng;
import com.example.exception.CustomException;
import com.example.service.YuyuejiazhengService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.YuyuejiazhengVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/yuyuejiazheng")
public class YuyuejiazhengController {

    @Resource
    private YuyuejiazhengService yuyuejiazhengService;

    @PostMapping
    public Result<Yuyuejiazheng> add(@RequestBody YuyuejiazhengVo yuyuejiazheng) {
		//yoxuxiaxnci
        yuyuejiazhengService.add(yuyuejiazheng);
        return Result.success(yuyuejiazheng);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("fuwumingcheng","服务名称");
        row.put("leibie","类别");
        row.put("fuwujiage","服务价格");
        row.put("fuwushichang","服务时长");
        row.put("gonghao","工号");
        row.put("mingzi","名字");
        row.put("yuyueshijian","预约时间");
        row.put("yonghuming","用户名");
        row.put("xingming","姓名");
        row.put("shouji","手机");
        row.put("dizhi","地址");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = yuyuejiazhengService.daochuexcel();
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
	
	@GetMapping("/yuyuejiazheng_tj_leibie")
    public Result yuyuejiazheng_tj_leibie() {
        return Result.success(yuyuejiazhengService.yuyuejiazheng_tj_leibie());
    }



    @PostMapping("/deleteList")
    public Result<Yuyuejiazheng> deleteList(@RequestBody YuyuejiazhengVo yuyuejiazheng) {
        yuyuejiazhengService.deleteList(yuyuejiazheng.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yuyuejiazhengService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YuyuejiazhengVo yuyuejiazheng) {
        yuyuejiazhengService.update(yuyuejiazheng);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Yuyuejiazheng> detail(@PathVariable Integer id) {
        Yuyuejiazheng yuyuejiazheng = yuyuejiazhengService.findById(id);
        return Result.success(yuyuejiazheng);
    }

    @GetMapping
    public Result<List<Yuyuejiazheng>> all() {
        return Result.success(yuyuejiazhengService.list());
    }

    @PostMapping("/page")
    public Result<YuyuejiazhengVo> page(@RequestBody YuyuejiazhengVo yuyuejiazhengVo) {
        return Result.success(yuyuejiazhengService.findPage(yuyuejiazhengVo));
    }
	//youupdt2login
}
