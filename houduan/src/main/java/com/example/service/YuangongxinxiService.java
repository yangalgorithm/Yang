package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Yuangongxinxi;
import com.example.vo.YuangongxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface YuangongxinxiService extends IService<Yuangongxinxi> {
    Yuangongxinxi add(Yuangongxinxi yuangongxinxi);
    void delete(Long id);
    void update(Yuangongxinxi yuangongxinxi);
    Yuangongxinxi findById(Integer id);
    YuangongxinxiVo findPage(YuangongxinxiVo yuangongxinxiVo);
	Yuangongxinxi login(Yuangongxinxi yuangongxinxi);
    void deleteList(List<Yuangongxinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
