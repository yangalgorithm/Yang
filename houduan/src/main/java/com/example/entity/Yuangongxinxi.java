package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("yuangongxinxi")
@Data
public class Yuangongxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "dengji")
	private String dengji;
	@TableField(value = "gonghao")
	private String gonghao;



    @TableField(value = "mima")
	private String mima;
	@TableField(value = "mingzi")
	private String mingzi;
	@TableField(value = "xingbie")
	private String xingbie;
	@TableField(value = "zhiwei")
	private String zhiwei;
	@TableField(value = "shanchang")
	private String shanchang;
	@TableField(value = "shoujihao")
	private String shoujihao;
    @TableField(value = "gongzi")
    private String gongzi;
	@TableField(value = "fuwufanwei")
	private String fuwufanwei;
	@TableField(value = "touxiang")
	private String touxiang;
	@TableField(exist = false)
	private String newPassword;


	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getGonghao() {
        return gonghao;
    }
    public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
    }
	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }
	public String getMingzi() {
        return mingzi;
    }
    public void setMingzi(String mingzi) {
		this.mingzi = mingzi;
    }

	public String getZhiwei() {
        return zhiwei;
    }
    public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
    }
	public String getShanchang() {
        return shanchang;
    }
    public void setShanchang(String shanchang) {
		this.shanchang = shanchang;
    }
	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
    }
	public String getFuwufanwei() {
        return fuwufanwei;
    }
    public void setFuwufanwei(String fuwufanwei) {
		this.fuwufanwei = fuwufanwei;
    }
	public String getTouxiang() {
        return touxiang;
    }
    public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
    }
	public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
    }
	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}