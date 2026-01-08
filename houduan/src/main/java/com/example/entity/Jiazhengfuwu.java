package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("jiazhengfuwu")
@Data
public class Jiazhengfuwu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "fuwumingcheng")	private String fuwumingcheng;	@TableField(value = "leibie")	private String leibie;	@TableField(value = "fuwujiage")	private String fuwujiage;	@TableField(value = "fuwushichang")	private String fuwushichang;	@TableField(value = "tupian")	private String tupian;	@TableField(value = "fuwujianjie")	private String fuwujianjie;	@TableField(value = "gonghao")	private String gonghao;	@TableField(value = "mingzi")	private String mingzi;	
    
	
	
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
    }	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
		this.leibie = leibie;
    }	public String getFuwujiage() {
        return fuwujiage;
    }
    public void setFuwujiage(String fuwujiage) {
		this.fuwujiage = fuwujiage;
    }	public String getFuwushichang() {
        return fuwushichang;
    }
    public void setFuwushichang(String fuwushichang) {
		this.fuwushichang = fuwushichang;
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
    }	public String getFuwujianjie() {
        return fuwujianjie;
    }
    public void setFuwujianjie(String fuwujianjie) {
		this.fuwujianjie = fuwujianjie;
    }	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
    }	public String getMingzi() {
        return mingzi;
    }
    public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}