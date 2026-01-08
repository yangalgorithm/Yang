package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Yuyuejiazheng;
import com.example.vo.YuyuejiazhengVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface YuyuejiazhengService extends IService<Yuyuejiazheng> {
    Yuyuejiazheng add(Yuyuejiazheng yuyuejiazheng);
    void delete(Long id);
    void update(Yuyuejiazheng yuyuejiazheng);
    Yuyuejiazheng findById(Integer id);
    YuyuejiazhengVo findPage(YuyuejiazhengVo yuyuejiazhengVo);
	
    void deleteList(List<Yuyuejiazheng> list);
	List<Map<String,Object>> yuyuejiazheng_tj_leibie();    List<Map<String,Object>> yuyuejiazheng_tj_mingzi();    
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
