package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Yuangongxinxi;
import com.example.exception.CustomException;
import com.example.service.YuangongxinxiService;
import com.example.vo.YuangongxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("yuangongxinxiService")
public class YuangongxinxiServiceImpl extends ServiceImpl<YuangongxinxiDao, Yuangongxinxi> implements YuangongxinxiService {

    @Resource
    private YuangongxinxiDao yuangongxinxiDao;

    public Yuangongxinxi add(Yuangongxinxi yuangongxinxi) {
		if(yuangongxinxi.getMima()==null) {yuangongxinxi.setMima(SecureUtil.md5("001"));}else {yuangongxinxi.setMima(SecureUtil.md5(yuangongxinxi.getMima())); }
	   //youquchong1
        yuangongxinxi.setAddtime(new Date());
        yuangongxinxiDao.insert(yuangongxinxi);
        return yuangongxinxi;
    }
	
	
	
    public void delete(Long id) {
        yuangongxinxiDao.deleteById(id);
    }
	

    public void update(Yuangongxinxi yuangongxinxi) {
        //youquchong2
        yuangongxinxiDao.updateById(yuangongxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return yuangongxinxiDao.daochuexcel();
    }

    @Override
    public Yuangongxinxi findById(Integer id) {
        return yuangongxinxiDao.selectById(id);
    }

    public YuangongxinxiVo findPage(YuangongxinxiVo yuangongxinxiVo) {
        LambdaQueryWrapper<Yuangongxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getGonghao()), Yuangongxinxi::getGonghao,yuangongxinxiVo.getGonghao());
		wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getDengji()), Yuangongxinxi::getDengji,yuangongxinxiVo.getDengji());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getMima()), Yuangongxinxi::getMima,yuangongxinxiVo.getMima());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getMingzi()), Yuangongxinxi::getMingzi,yuangongxinxiVo.getMingzi());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getXingbie()), Yuangongxinxi::getXingbie,yuangongxinxiVo.getXingbie());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getZhiwei()), Yuangongxinxi::getZhiwei,yuangongxinxiVo.getZhiwei());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getGongzi()), Yuangongxinxi::getGongzi,yuangongxinxiVo.getGongzi());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getShanchang()), Yuangongxinxi::getShanchang,yuangongxinxiVo.getShanchang());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getShoujihao()), Yuangongxinxi::getShoujihao,yuangongxinxiVo.getShoujihao());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getFuwufanwei()), Yuangongxinxi::getFuwufanwei,yuangongxinxiVo.getFuwufanwei());
        wrapper.like(ObjectUtils.isNotEmpty(yuangongxinxiVo.getTouxiang()), Yuangongxinxi::getTouxiang,yuangongxinxiVo.getTouxiang());
        
        Page<Yuangongxinxi> page = new Page<>(yuangongxinxiVo.getCurrent(),yuangongxinxiVo.getCurrentNum());
        yuangongxinxiDao.selectPage(page,wrapper);
        List<Yuangongxinxi> yuangongxinxis = page.getRecords();
        yuangongxinxiVo.setList(yuangongxinxis);
        yuangongxinxiVo.setPages(page.getPages());
        yuangongxinxiVo.setTotal(page.getTotal());
        yuangongxinxiVo.setCurrent(page.getCurrent());
        yuangongxinxiVo.setCurrentNum(page.getSize());
        return yuangongxinxiVo;
    }

    @Override
    public void deleteList(List<Yuangongxinxi> list) {
        List<Integer> ids =  list.stream().map(Yuangongxinxi::getId).collect(Collectors.toList());
        yuangongxinxiDao.deleteBatchIds(ids);
    }
	
	@Override
    public Yuangongxinxi login(Yuangongxinxi yuangongxinxi) {
        LambdaQueryWrapper<Yuangongxinxi> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(yuangongxinxi.getGonghao()), Yuangongxinxi::getGonghao,yuangongxinxi.getGonghao());
        Yuangongxinxi yuangongxinxiInfo = yuangongxinxiDao.selectOne(wrapper);
        if (yuangongxinxiInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(yuangongxinxi.getMima()).equalsIgnoreCase(yuangongxinxiInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return yuangongxinxiInfo;
    }
	
	
	
	//youxxianxci
}
