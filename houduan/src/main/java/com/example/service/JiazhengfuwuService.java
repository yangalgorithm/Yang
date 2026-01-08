package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Jiazhengfuwu;
import com.example.vo.JiazhengfuwuVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface JiazhengfuwuService extends IService<Jiazhengfuwu> {
    Jiazhengfuwu add(Jiazhengfuwu jiazhengfuwu);
    void delete(Long id);
    void update(Jiazhengfuwu jiazhengfuwu);
    Jiazhengfuwu findById(Integer id);
    JiazhengfuwuVo findPage(JiazhengfuwuVo jiazhengfuwuVo);
	
    void deleteList(List<Jiazhengfuwu> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
