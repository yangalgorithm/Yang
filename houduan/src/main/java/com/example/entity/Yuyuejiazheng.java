package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("yuyuejiazheng")
@Data
public class Yuyuejiazheng {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "fuwumingcheng")
	private String fuwumingcheng;
	@TableField(value = "leibie")
	private String leibie;
	@TableField(value = "fuwujiage")
	private String fuwujiage;
	@TableField(value = "fuwushichang")
	private String fuwushichang;
	@TableField(value = "gonghao")
	private String gonghao;
	@TableField(value = "mingzi")
	private String mingzi;
	@TableField(value = "yuyueshijian")
	private String yuyueshijian;
	@TableField(value = "yonghuming")
	private String yonghuming;
	@TableField(value = "xingming")
	private String xingming;
	@TableField(value = "shouji")
	private String shouji;
	@TableField(value = "dizhi")
	private String dizhi;
	@TableField(value = "iszf")
	private String iszf;
	@TableField(value = "issh")
	private String issh;
	@TableField(value = "shhf")
	private String shhf;
    @TableField(value = "beizhu")
    private String beizhu;
    
	
	
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
    }
	public String getLeibie() {
        return leibie;
    }
    public void setLeibie(String leibie) {
		this.leibie = leibie;
    }
	public String getFuwujiage() {
        return fuwujiage;
    }
    public void setFuwujiage(String fuwujiage) {
		this.fuwujiage = fuwujiage;
    }
	public String getFuwushichang() {
        return fuwushichang;
    }
    public void setFuwushichang(String fuwushichang) {
		this.fuwushichang = fuwushichang;
    }
	public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
    }
	public String getMingzi() {
        return mingzi;
    }
    public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
    }
	public String getYuyueshijian() {
        return yuyueshijian;
    }
    public void setYuyueshijian(String yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
    }
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
	public String getShouji() {
        return shouji;
    }
    public void setShouji(String shouji) {
		this.shouji = shouji;
    }
	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
    }
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}