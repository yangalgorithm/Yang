package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Yuyuejiazheng;
import com.example.exception.CustomException;
import com.example.service.YuyuejiazhengService;
import com.example.vo.YuyuejiazhengVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("yuyuejiazhengService")
public class YuyuejiazhengServiceImpl extends ServiceImpl<YuyuejiazhengDao, Yuyuejiazheng> implements YuyuejiazhengService {

    @Resource
    private YuyuejiazhengDao yuyuejiazhengDao;

    public Yuyuejiazheng add(Yuyuejiazheng yuyuejiazheng) {
		
	   //youquchong1
        yuyuejiazheng.setAddtime(new Date());
        yuyuejiazhengDao.insert(yuyuejiazheng);
        return yuyuejiazheng;
    }
	
	@Override
    public List<Map<String,Object>> yuyuejiazheng_tj_leibie() {
    List<Map<String,Object>> returnMap = yuyuejiazhengDao.yuyuejiazheng_tj_leibie();
    return returnMap;
    }
    @Override
    public List<Map<String,Object>> yuyuejiazheng_tj_mingzi() {
    List<Map<String,Object>> returnMap = yuyuejiazhengDao.yuyuejiazheng_tj_mingzi();
    return returnMap;
    }
    
	
    public void delete(Long id) {
        yuyuejiazhengDao.deleteById(id);
    }
	

    public void update(Yuyuejiazheng yuyuejiazheng) {
        //youquchong2
        yuyuejiazhengDao.updateById(yuyuejiazheng);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return yuyuejiazhengDao.daochuexcel();
    }

    @Override
    public Yuyuejiazheng findById(Integer id) {
        return yuyuejiazhengDao.selectById(id);
    }

    public YuyuejiazhengVo findPage(YuyuejiazhengVo yuyuejiazhengVo) {
        LambdaQueryWrapper<Yuyuejiazheng> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getFuwumingcheng()), Yuyuejiazheng::getFuwumingcheng,yuyuejiazhengVo.getFuwumingcheng());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getLeibie()), Yuyuejiazheng::getLeibie,yuyuejiazhengVo.getLeibie());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getFuwujiage()), Yuyuejiazheng::getFuwujiage,yuyuejiazhengVo.getFuwujiage());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getFuwushichang()), Yuyuejiazheng::getFuwushichang,yuyuejiazhengVo.getFuwushichang());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getGonghao()), Yuyuejiazheng::getGonghao,yuyuejiazhengVo.getGonghao());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getMingzi()), Yuyuejiazheng::getMingzi,yuyuejiazhengVo.getMingzi());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getYuyueshijian()), Yuyuejiazheng::getYuyueshijian,yuyuejiazhengVo.getYuyueshijian());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getYonghuming()), Yuyuejiazheng::getYonghuming,yuyuejiazhengVo.getYonghuming());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getXingming()), Yuyuejiazheng::getXingming,yuyuejiazhengVo.getXingming());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getShouji()), Yuyuejiazheng::getShouji,yuyuejiazhengVo.getShouji());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getDizhi()), Yuyuejiazheng::getDizhi,yuyuejiazhengVo.getDizhi());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getIssh()), Yuyuejiazheng::getIssh,yuyuejiazhengVo.getIssh());
        wrapper.like(ObjectUtils.isNotEmpty(yuyuejiazhengVo.getBeizhu()), Yuyuejiazheng::getBeizhu,yuyuejiazhengVo.getBeizhu());

        Page<Yuyuejiazheng> page = new Page<>(yuyuejiazhengVo.getCurrent(),yuyuejiazhengVo.getCurrentNum());
        yuyuejiazhengDao.selectPage(page,wrapper);
        List<Yuyuejiazheng> yuyuejiazhengs = page.getRecords();
        yuyuejiazhengVo.setList(yuyuejiazhengs);
        yuyuejiazhengVo.setPages(page.getPages());
        yuyuejiazhengVo.setTotal(page.getTotal());
        yuyuejiazhengVo.setCurrent(page.getCurrent());
        yuyuejiazhengVo.setCurrentNum(page.getSize());
        return yuyuejiazhengVo;
    }

    @Override
    public void deleteList(List<Yuyuejiazheng> list) {
        List<Integer> ids =  list.stream().map(Yuyuejiazheng::getId).collect(Collectors.toList());
        yuyuejiazhengDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
