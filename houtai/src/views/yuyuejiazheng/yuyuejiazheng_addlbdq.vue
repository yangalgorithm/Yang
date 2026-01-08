<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="服务名称" prop="fuwumingcheng"><el-input size="small" v-model="editForm.fuwumingcheng" auto-complete="off" placeholder="请输入服务名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="类别" prop="leibie"><el-input size="small" v-model="editForm.leibie" auto-complete="off" placeholder="请输入类别" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="服务价格" prop="fuwujiage"><el-input size="small" v-model="editForm.fuwujiage" auto-complete="off" placeholder="请输入服务价格" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="服务时长" prop="fuwushichang"><el-input size="small" v-model="editForm.fuwushichang" auto-complete="off" placeholder="请输入服务时长" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="工号" prop="gonghao"><el-input size="small" v-model="editForm.gonghao" auto-complete="off" placeholder="请输入工号" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="名字" prop="mingzi"><el-input size="small" v-model="editForm.mingzi" auto-complete="off" placeholder="请输入名字" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="预约时间" prop="yuyueshijian"><el-date-picker type="datetime" value-format="yyyy-MM-dd hh:mm:ss" size="small" v-model="editForm.yuyueshijian" style='width:50%'/></el-form-item>
		<el-form-item  label="用户名" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="姓名" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="请输入姓名" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="手机" prop="shouji"><el-input size="small" v-model="editForm.shouji" auto-complete="off" placeholder="请输入手机" style='width:50%'></el-input></el-form-item>
		<el-form-item  label="备注" prop="beizhu"><el-input size="small" v-model="editForm.beizhu" auto-complete="off" placeholder="请输入备注" style='width:100%'></el-input></el-form-item>

		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {yuyuejiazhengEdit, yuyuejiazhengSave,yuyuejiazhengDetail} from "@/api/yuyuejiazheng/yuyuejiazhengApi";
	import {Session} from "@/utils/storage";
import {jiazhengfuwuDetail,jiazhengfuwuEdit} from "../../api/jiazhengfuwu/jiazhengfuwuApi";
//xiabiaoduan1
export default {
	name: 'personal',
	data() {
		return {
			rules: {
				//yztssssss1
			},
			editForm: {
				avater:'',
				fuwumingcheng:'',
				leibie:'',
				fuwujiage:'',
				fuwushichang:'',
				gonghao:'',
				mingzi:'',
				
			},
			username:'',
			cx:'',
			//xiabiaoduan2
		};
	},
	created() {
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		let id = this.$route.params.id;
		//xiabiaoduan3
		this.getUserInfo(id);
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getUserInfo(id){
			jiazhengfuwuDetail(id).then(res=>{
				if(res.code == '0'){
					this.jiazhengfuwu = res.data
					this.editForm.fuwumingcheng = this.jiazhengfuwu.fuwumingcheng;
					this.editForm.leibie = this.jiazhengfuwu.leibie;
					this.editForm.fuwujiage = this.jiazhengfuwu.fuwujiage;
					this.editForm.fuwushichang = this.jiazhengfuwu.fuwushichang;
					this.editForm.gonghao = this.jiazhengfuwu.gonghao;
					this.editForm.mingzi = this.jiazhengfuwu.mingzi;
				
					this.editForm.yonghuming= this.userInfo.yonghuming;
					
					this.editForm.xingming= this.userInfo.xingming;
				this.editForm.shouji= this.userInfo.shouji;
				
				}
			})
		},
		
		//qixuzhijixsuan3
		//xia2sui1
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						yuyuejiazhengSave(this.editForm).then(res => {
							if (res.code == '0') {
								
								this.$message({
									type: 'success',
									message: '添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}
				} else {
					return false
				}
			})
		},
		
		//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
