<template>
	<div class="personal">
		<el-form label-width="80px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="工号" prop="gonghao"><el-input size="small" v-model="editForm.gonghao" auto-complete="off" placeholder="请输入工号" style='width:25%'></el-input></el-form-item>
					<el-form-item  label="等级" prop="dengji"><el-input size="small" v-model="editForm.dengji" auto-complete="off" placeholder="请输入等级" style='width:25%'></el-input></el-form-item>

		<el-form-item  label="名字" prop="mingzi"><el-input size="small" v-model="editForm.mingzi" auto-complete="off" placeholder="请输入名字" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="性别" prop="xingbie"><el-radio v-model="editForm.xingbie" :label=true>男</el-radio><el-radio v-model="editForm.xingbie" :label=false>女</el-radio></el-form-item>
		<el-form-item  label="职位" prop="zhiwei"><el-input size="small" v-model="editForm.zhiwei" auto-complete="off" placeholder="请输入职位" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="擅长" prop="shanchang"><el-input size="small" v-model="editForm.shanchang" auto-complete="off" placeholder="请输入擅长" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="手机号" prop="shoujihao"><el-input size="small" v-model="editForm.shoujihao" auto-complete="off" placeholder="请输入手机号" style='width:25%'></el-input></el-form-item>
		<el-form-item  label="服务范围" prop="fuwufanwei"><el-input type="textarea" size="small" v-model="editForm.fuwufanwei" auto-complete="off" placeholder="请输入服务范围" style='width:50%'></el-input></el-form-item>
		<el-form-item  label='头像' prop='touxiang'><el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers' :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'><img v-if='editForm.touxiang' :src='editForm.touxiang' class='avatar'><i v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">更新</el-button>
		</div>
	</div>
</template>

<script>
	import {yuangongxinxiEdit, yuangongxinxiSave,yuangongxinxiDetail} from "@/api/yuangongxinxi/yuangongxinxiApi";
	import {Session} from "@/utils/storage";

export default {
	name: 'personal',
	data() {
		return {
			rules: {
				zhiwei: [{ required: true, message: '请输入职位', trigger: 'blur' },
				],
				
			},
			editForm: {
				avater:''
			},
		};
	},
	created() {
		this.getDetail()
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getDetail(){
			if (!Session.get('userInfo')) return false;
			this.userInfo = Session.get('userInfo');
			console.log(this.userInfo);
			yuangongxinxiDetail(this.userInfo.id).then(res=>{
				if (res.code == '0') {
					this.editForm = res.data;
				}
			}).catch(err => {
				if(err){
					this.$message.error(err)
				}else {
					this.$message.error('操作失败，请稍后再试！')
				}
			})
		},
		
		// 编辑、增加页面保存方法
		submitForm(editData) {
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						yuangongxinxiEdit(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: '个人信息修改成功！'
								})
								this.$store.dispatch('userInfos/setUserInfos',this.editForm);
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
					}else {
						yuangongxinxiSave(this.editForm).then(res => {
							if (res.code == '0') {
								this.getDetail()
								this.$message({
									type: 'success',
									message: '个人信息添加成功！'
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
		handleTouxiangSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.touxiang = "/files/download/"+res.data.id
				}
			},
			beforeTouxiangUpload(file) {
				const isJPG = file.type === 'image/jpeg';
				const isLt2M = file.size / 1024 / 1024 < 2;

				if (!isJPG) {
					this.$message.error('上传图片只能是 JPG 格式!');
				}
				if (!isLt2M) {
					this.$message.error('上传图片大小不能超过 2MB!');
				}
				return isJPG && isLt2M;
			},
				
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
