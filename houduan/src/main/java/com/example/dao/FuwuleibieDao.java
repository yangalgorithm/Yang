package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Fuwuleibie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FuwuleibieDao extends BaseMapper<Fuwuleibie> {

@Select("select * from fuwuleibie")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
