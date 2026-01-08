package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Jiazhengfuwu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JiazhengfuwuDao extends BaseMapper<Jiazhengfuwu> {

@Select("select * from jiazhengfuwu")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
