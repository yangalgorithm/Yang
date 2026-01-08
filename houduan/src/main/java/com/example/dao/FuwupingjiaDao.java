package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Fuwupingjia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FuwupingjiaDao extends BaseMapper<Fuwupingjia> {

@Select("select * from fuwupingjia")
List<Map<String, Object>> daochuexcel();

//youxxianxci
@Select({
    "SELECT gonghao, ",
    "SUM(CASE WHEN manyiqingkuang = '满意' THEN 1 ELSE 0 END) AS 满意_count, ",
    "SUM(CASE WHEN manyiqingkuang = '正常' THEN 1 ELSE 0 END) AS 正常_count, ",
    "SUM(CASE WHEN manyiqingkuang = '不满意' THEN 1 ELSE 0 END) AS 不满意_count ",
    "FROM fuwupingjia ",
    "GROUP BY gonghao ",
    "ORDER BY gonghao"
})
List<Map<String, Object>> fuwupingjia_tj_gonghao();

//tonxgji1

}
