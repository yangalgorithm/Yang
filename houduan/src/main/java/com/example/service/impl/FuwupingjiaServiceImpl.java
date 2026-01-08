package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Fuwupingjia;
import com.example.exception.CustomException;
import com.example.service.FuwupingjiaService;
import com.example.vo.FuwupingjiaVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("fuwupingjiaService")
public class FuwupingjiaServiceImpl extends ServiceImpl<FuwupingjiaDao, Fuwupingjia> implements FuwupingjiaService {

    @Resource
    private FuwupingjiaDao fuwupingjiaDao;

    public Fuwupingjia add(Fuwupingjia fuwupingjia) {
		
	   //youquchong1
        fuwupingjia.setAddtime(new Date());
        fuwupingjiaDao.insert(fuwupingjia);
        return fuwupingjia;
    }
	
	
	
    public void delete(Long id) {
        fuwupingjiaDao.deleteById(id);
    }
	

    public void update(Fuwupingjia fuwupingjia) {
        //youquchong2
        fuwupingjiaDao.updateById(fuwupingjia);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return fuwupingjiaDao.daochuexcel();
    }

    @Override
    public Fuwupingjia findById(Integer id) {
        return fuwupingjiaDao.selectById(id);
    }

    public FuwupingjiaVo findPage(FuwupingjiaVo fuwupingjiaVo) {
        LambdaQueryWrapper<Fuwupingjia> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getFuwumingcheng()), Fuwupingjia::getFuwumingcheng,fuwupingjiaVo.getFuwumingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getFuwujiage()), Fuwupingjia::getFuwujiage,fuwupingjiaVo.getFuwujiage());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getGonghao()), Fuwupingjia::getGonghao,fuwupingjiaVo.getGonghao());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getManyiqingkuang()), Fuwupingjia::getManyiqingkuang,fuwupingjiaVo.getManyiqingkuang());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getPingjianeirong()), Fuwupingjia::getPingjianeirong,fuwupingjiaVo.getPingjianeirong());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getYonghuming()), Fuwupingjia::getYonghuming,fuwupingjiaVo.getYonghuming());
        wrapper.like(ObjectUtils.isNotEmpty(fuwupingjiaVo.getXingming()), Fuwupingjia::getXingming,fuwupingjiaVo.getXingming());
        
        Page<Fuwupingjia> page = new Page<>(fuwupingjiaVo.getCurrent(),fuwupingjiaVo.getCurrentNum());
        fuwupingjiaDao.selectPage(page,wrapper);
        List<Fuwupingjia> fuwupingjias = page.getRecords();
        fuwupingjiaVo.setList(fuwupingjias);
        fuwupingjiaVo.setPages(page.getPages());
        fuwupingjiaVo.setTotal(page.getTotal());
        fuwupingjiaVo.setCurrent(page.getCurrent());
        fuwupingjiaVo.setCurrentNum(page.getSize());
        return fuwupingjiaVo;
    }

    @Override
    public void deleteList(List<Fuwupingjia> list) {
        List<Integer> ids =  list.stream().map(Fuwupingjia::getId).collect(Collectors.toList());
        fuwupingjiaDao.deleteBatchIds(ids);
    }
	
	
	    @Override
    public List<Map<String,Object>> fuwupingjia_tj_gonghao() {
    List<Map<String,Object>> returnMap = fuwupingjiaDao.fuwupingjia_tj_gonghao();
    return returnMap;
    }
	
	
	//youxxianxci
}
