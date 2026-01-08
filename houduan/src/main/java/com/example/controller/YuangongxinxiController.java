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
import com.example.entity.Yuangongxinxi;
import com.example.exception.CustomException;
import com.example.service.YuangongxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.YuangongxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/yuangongxinxi")
public class YuangongxinxiController {

    @Resource
    private YuangongxinxiService yuangongxinxiService;

    @PostMapping
    public Result<Yuangongxinxi> add(@RequestBody YuangongxinxiVo yuangongxinxi) {
		//yoxuxiaxnci
        yuangongxinxiService.add(yuangongxinxi);
        return Result.success(yuangongxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("dengji","等级");
        row.put("gonghao","工号");
        row.put("mingzi","名字");
        row.put("xingbie","性别");
        row.put("zhiwei","职位");
        row.put("shanchang","擅长");
        row.put("shoujihao","手机号");
        row.put("fuwufanwei","服务范围");
        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = yuangongxinxiService.daochuexcel();
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
    public Result<Yuangongxinxi> deleteList(@RequestBody YuangongxinxiVo yuangongxinxi) {
        yuangongxinxiService.deleteList(yuangongxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        yuangongxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody YuangongxinxiVo yuangongxinxi) {
        yuangongxinxiService.update(yuangongxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Yuangongxinxi> detail(@PathVariable Integer id) {
        Yuangongxinxi yuangongxinxi = yuangongxinxiService.findById(id);
        return Result.success(yuangongxinxi);
    }

    @GetMapping
    public Result<List<Yuangongxinxi>> all() {
        return Result.success(yuangongxinxiService.list());
    }

    @PostMapping("/page")
    public Result<YuangongxinxiVo> page(@RequestBody YuangongxinxiVo yuangongxinxiVo) {
        return Result.success(yuangongxinxiService.findPage(yuangongxinxiVo));
    }
	    @PostMapping("/login")
    public Result login(@RequestBody Yuangongxinxi yuangongxinxi, HttpServletRequest request) {
        if (StrUtil.isBlank(yuangongxinxi.getGonghao()) || StrUtil.isBlank(yuangongxinxi.getMima())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Yuangongxinxi login = yuangongxinxiService.login(yuangongxinxi);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID,yuangongxinxi.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Yuangongxinxi info, HttpServletRequest request) {
        Yuangongxinxi yuangongxinxi = yuangongxinxiService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getMima());
        if (!oldPassword.equals(yuangongxinxi.getMima())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewPassword()));
        Yuangongxinxi yuangongxinxi1 = new Yuangongxinxi();
        BeanUtils.copyProperties(info, yuangongxinxi1);
        yuangongxinxiService.update(yuangongxinxi1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Yuangongxinxi> register(@RequestBody YuangongxinxiVo yuangongxinxi) {
        yuangongxinxiService.add(yuangongxinxi);
        return Result.success(yuangongxinxi);
    }
}
