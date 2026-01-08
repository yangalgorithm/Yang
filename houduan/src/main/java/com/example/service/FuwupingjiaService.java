package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Fuwupingjia;
import com.example.vo.FuwupingjiaVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface FuwupingjiaService extends IService<Fuwupingjia> {
    Fuwupingjia add(Fuwupingjia fuwupingjia);
    void delete(Long id);
    void update(Fuwupingjia fuwupingjia);
    Fuwupingjia findById(Integer id);
    FuwupingjiaVo findPage(FuwupingjiaVo fuwupingjiaVo);
	
    void deleteList(List<Fuwupingjia> list);

	    List<Map<String,Object>> fuwupingjia_tj_gonghao();
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
