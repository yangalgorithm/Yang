package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("fuwupingjia")
@Data
public class Fuwupingjia {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "fuwumingcheng")	private String fuwumingcheng;	@TableField(value = "fuwujiage")	private String fuwujiage;	@TableField(value = "gonghao")	private String gonghao;	@TableField(value = "manyiqingkuang")	private String manyiqingkuang;	@TableField(value = "pingjianeirong")	private String pingjianeirong;	@TableField(value = "yonghuming")	private String yonghuming;	@TableField(value = "xingming")	private String xingming;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getFuwumingcheng() {
        return fuwumingcheng;
    }
    public void setFuwumingcheng(String fuwumingcheng) {
		this.fuwumingcheng = fuwumingcheng;
    }	public String getFuwujiage() {
        return fuwujiage;
    }
    public void setFuwujiage(String fuwujiage) {
		this.fuwujiage = fuwujiage;
    }	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
    }	public String getManyiqingkuang() {
        return manyiqingkuang;
    }
    public void setManyiqingkuang(String manyiqingkuang) {
		this.manyiqingkuang = manyiqingkuang;
    }	public String getPingjianeirong() {
        return pingjianeirong;
    }
    public void setPingjianeirong(String pingjianeirong) {
		this.pingjianeirong = pingjianeirong;
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}