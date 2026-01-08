package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Yuangongxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface YuangongxinxiDao extends BaseMapper<Yuangongxinxi> {

@Select("select * from yuangongxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
