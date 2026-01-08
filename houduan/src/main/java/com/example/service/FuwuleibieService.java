package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Fuwuleibie;
import com.example.vo.FuwuleibieVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface FuwuleibieService extends IService<Fuwuleibie> {
    Fuwuleibie add(Fuwuleibie fuwuleibie);
    void delete(Long id);
    void update(Fuwuleibie fuwuleibie);
    Fuwuleibie findById(Integer id);
    FuwuleibieVo findPage(FuwuleibieVo fuwuleibieVo);
	
    void deleteList(List<Fuwuleibie> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
