<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="服务名称" prop="fuwumingcheng"><el-input size="small" v-model="editForm.fuwumingcheng" auto-complete="off" placeholder="请输入服务名称" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="服务价格" prop="fuwujiage"><el-input size="small" v-model="editForm.fuwujiage" auto-complete="off" placeholder="请输入服务价格" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="工号" prop="gonghao"><el-input size="small" v-model="editForm.gonghao" auto-complete="off" placeholder="请输入工号" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label='满意情况' prop="manyiqingkuang"><el-select size="small" v-model="editForm.manyiqingkuang" placeholder="请选择满意情况"><el-option selected label="请选择满意情况" value=""></el-option><el-option label="满意" value="满意"></el-option><el-option label="正常" value="正常"></el-option><el-option label="不满意" value="不满意"></el-option></el-select></el-form-item>		<el-form-item  label="评价内容" prop="pingjianeirong"><el-input type="textarea" size="small" v-model="editForm.pingjianeirong" auto-complete="off" placeholder="请输入评价内容" style='width:100%'></el-input></el-form-item>		<el-form-item  label="用户名" prop="yonghuming"><el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="姓名" prop="xingming"><el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="请输入姓名" style='width:50%'></el-input></el-form-item>		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {fuwupingjiaEdit, fuwupingjiaSave,fuwupingjiaDetail} from "@/api/fuwupingjia/fuwupingjiaApi";
	import {Session} from "@/utils/storage";
import {yuyuejiazhengDetail,yuyuejiazhengEdit} from "../../api/yuyuejiazheng/yuyuejiazhengApi";
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
				fuwumingcheng:'',				fuwujiage:'',				gonghao:'',				
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
			yuyuejiazhengDetail(id).then(res=>{
				if(res.code == '0'){
					this.yuyuejiazheng = res.data
					this.editForm.fuwumingcheng = this.yuyuejiazheng.fuwumingcheng;					this.editForm.fuwujiage = this.yuyuejiazheng.fuwujiage;					this.editForm.gonghao = this.yuyuejiazheng.gonghao;				
					this.editForm.yonghuming= this.userInfo.yonghuming;
					
					this.editForm.xingming= this.userInfo.xingming;				
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
						fuwupingjiaSave(this.editForm).then(res => {
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
