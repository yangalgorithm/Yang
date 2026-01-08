package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Jiazhengfuwu;
import com.example.exception.CustomException;
import com.example.service.JiazhengfuwuService;
import com.example.vo.JiazhengfuwuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("jiazhengfuwuService")
public class JiazhengfuwuServiceImpl extends ServiceImpl<JiazhengfuwuDao, Jiazhengfuwu> implements JiazhengfuwuService {

    @Resource
    private JiazhengfuwuDao jiazhengfuwuDao;

    public Jiazhengfuwu add(Jiazhengfuwu jiazhengfuwu) {
		
	   //youquchong1
        jiazhengfuwu.setAddtime(new Date());
        jiazhengfuwuDao.insert(jiazhengfuwu);
        return jiazhengfuwu;
    }
	
	
	
    public void delete(Long id) {
        jiazhengfuwuDao.deleteById(id);
    }
	

    public void update(Jiazhengfuwu jiazhengfuwu) {
        //youquchong2
        jiazhengfuwuDao.updateById(jiazhengfuwu);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return jiazhengfuwuDao.daochuexcel();
    }

    @Override
    public Jiazhengfuwu findById(Integer id) {
        return jiazhengfuwuDao.selectById(id);
    }

    public JiazhengfuwuVo findPage(JiazhengfuwuVo jiazhengfuwuVo) {
        LambdaQueryWrapper<Jiazhengfuwu> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getFuwumingcheng()), Jiazhengfuwu::getFuwumingcheng,jiazhengfuwuVo.getFuwumingcheng());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getLeibie()), Jiazhengfuwu::getLeibie,jiazhengfuwuVo.getLeibie());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getFuwujiage()), Jiazhengfuwu::getFuwujiage,jiazhengfuwuVo.getFuwujiage());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getFuwushichang()), Jiazhengfuwu::getFuwushichang,jiazhengfuwuVo.getFuwushichang());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getTupian()), Jiazhengfuwu::getTupian,jiazhengfuwuVo.getTupian());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getFuwujianjie()), Jiazhengfuwu::getFuwujianjie,jiazhengfuwuVo.getFuwujianjie());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getGonghao()), Jiazhengfuwu::getGonghao,jiazhengfuwuVo.getGonghao());        wrapper.like(ObjectUtils.isNotEmpty(jiazhengfuwuVo.getMingzi()), Jiazhengfuwu::getMingzi,jiazhengfuwuVo.getMingzi());        
        Page<Jiazhengfuwu> page = new Page<>(jiazhengfuwuVo.getCurrent(),jiazhengfuwuVo.getCurrentNum());
        jiazhengfuwuDao.selectPage(page,wrapper);
        List<Jiazhengfuwu> jiazhengfuwus = page.getRecords();
        jiazhengfuwuVo.setList(jiazhengfuwus);
        jiazhengfuwuVo.setPages(page.getPages());
        jiazhengfuwuVo.setTotal(page.getTotal());
        jiazhengfuwuVo.setCurrent(page.getCurrent());
        jiazhengfuwuVo.setCurrentNum(page.getSize());
        return jiazhengfuwuVo;
    }

    @Override
    public void deleteList(List<Jiazhengfuwu> list) {
        List<Integer> ids =  list.stream().map(Jiazhengfuwu::getId).collect(Collectors.toList());
        jiazhengfuwuDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
