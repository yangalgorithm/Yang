package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Fuwuleibie;
import com.example.exception.CustomException;
import com.example.service.FuwuleibieService;
import com.example.vo.FuwuleibieVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("fuwuleibieService")
public class FuwuleibieServiceImpl extends ServiceImpl<FuwuleibieDao, Fuwuleibie> implements FuwuleibieService {

    @Resource
    private FuwuleibieDao fuwuleibieDao;

    public Fuwuleibie add(Fuwuleibie fuwuleibie) {
		
	    LambdaQueryWrapper<Fuwuleibie> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Fuwuleibie::getLeibie,fuwuleibie.getLeibie());
        Fuwuleibie findFuwuleibie = fuwuleibieDao.selectOne(wrapper);
        if (findFuwuleibie != null) {
            throw new CustomException("1001", "" + fuwuleibie.getLeibie() + "\"已存在");
        }
        fuwuleibie.setAddtime(new Date());
        fuwuleibieDao.insert(fuwuleibie);
        return fuwuleibie;
    }
	
	
	
    public void delete(Long id) {
        fuwuleibieDao.deleteById(id);
    }
	

    public void update(Fuwuleibie fuwuleibie) {
         LambdaQueryWrapper<Fuwuleibie> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Fuwuleibie::getLeibie,fuwuleibie.getLeibie());
        Fuwuleibie findFuwuleibie = fuwuleibieDao.selectOne(wrapper);
		if (findFuwuleibie != null && fuwuleibie.getId() != findFuwuleibie.getId()) {
            throw new CustomException("1001", "" + fuwuleibie.getLeibie() + "\"已存在");
        }
        fuwuleibieDao.updateById(fuwuleibie);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return fuwuleibieDao.daochuexcel();
    }

    @Override
    public Fuwuleibie findById(Integer id) {
        return fuwuleibieDao.selectById(id);
    }

    public FuwuleibieVo findPage(FuwuleibieVo fuwuleibieVo) {
        LambdaQueryWrapper<Fuwuleibie> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(fuwuleibieVo.getLeibie()), Fuwuleibie::getLeibie,fuwuleibieVo.getLeibie());        wrapper.like(ObjectUtils.isNotEmpty(fuwuleibieVo.getBeizhu()), Fuwuleibie::getBeizhu,fuwuleibieVo.getBeizhu());        
        Page<Fuwuleibie> page = new Page<>(fuwuleibieVo.getCurrent(),fuwuleibieVo.getCurrentNum());
        fuwuleibieDao.selectPage(page,wrapper);
        List<Fuwuleibie> fuwuleibies = page.getRecords();
        fuwuleibieVo.setList(fuwuleibies);
        fuwuleibieVo.setPages(page.getPages());
        fuwuleibieVo.setTotal(page.getTotal());
        fuwuleibieVo.setCurrent(page.getCurrent());
        fuwuleibieVo.setCurrentNum(page.getSize());
        return fuwuleibieVo;
    }

    @Override
    public void deleteList(List<Fuwuleibie> list) {
        List<Integer> ids =  list.stream().map(Fuwuleibie::getId).collect(Collectors.toList());
        fuwuleibieDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
