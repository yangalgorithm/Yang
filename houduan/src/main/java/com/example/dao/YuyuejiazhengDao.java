package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Yuyuejiazheng;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface YuyuejiazhengDao extends BaseMapper<Yuyuejiazheng> {

@Select("select * from yuyuejiazheng")
List<Map<String, Object>> daochuexcel();

//youxxianxci

@Select("SELECT distinct(leibie) as aa,count(id) as bb FROM yuyuejiazheng group by leibie order by id")List<Map<String, Object>> yuyuejiazheng_tj_leibie();@Select("SELECT distinct(mingzi) as aa,count(id) as bb FROM yuyuejiazheng group by mingzi order by id")List<Map<String, Object>> yuyuejiazheng_tj_mingzi();//tonxgji1

}
