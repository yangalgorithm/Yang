<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 预约汽车预约列表 >> 预约汽车预约添加 </p>
      </div>
    </div>
    <div class="main">
      <div class="content">
        <el-form label-width="150px" ref="editForm" :model="editForm" :rules="rules">
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
		<el-form-item  label="地址" prop="dizhi"><el-input size="small" v-model="editForm.dizhi" auto-complete="off" placeholder="请输入地址" style='width:100%'></el-input></el-form-item>
		<el-form-item  label="备注" prop="beizhu"><el-input size="small" v-model="editForm.beizhu" auto-complete="off" placeholder="请输入备注" style='width:100%'></el-input></el-form-item>


        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        dis: false, // 控制“加入购物车按钮是否可用”
		jiazhengfuwuID:'',
jiazhengfuwu:'',

        rules: {
          yuyueshijian: [{ required: true, message: '请输入预约时间', trigger: 'blur' },
				],
				dizhi: [{ required: true, message: '请输入地址', trigger: 'blur' },
				],

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
      };
    },
    watch: {
      '$route' (to, from) {
        // 路由发生变化页面刷新
        this.$router.go(0);
      }
    },
    created() {
     if (localStorage.getItem("user")) {
            // 如果已经登录，设置vuex登录状态
            //this.setUser(JSON.parse(localStorage.getItem("user")));
			this.userInfo=JSON.parse(localStorage.getItem("user"));
            this.username = localStorage.getItem("username");
            this.cx = localStorage.getItem("cx");
        }
	  this.editForm.xingming= this.userInfo.xingming;
				this.editForm.shouji= this.userInfo.shouji;


	  let id = this.$route.params.id;this.getDetails(id);
    },
    methods: {
      getProjectNum () {
        const projectTime = new Date() // 当前中国标准时间
        const Year = projectTime.getFullYear() // 获取当前年份 支持IE和火狐浏览器.
        const Month = projectTime.getMonth() + 1 // 获取中国区月份
        const Day = projectTime.getDate() // 获取几号
        var CurrentDate = Year
        if (Month >= 10) { // 判断月份和几号是否大于10或者小于10
          CurrentDate += Month
        } else {
          CurrentDate += '0' + Month
        }
        if (Day >= 10) {
          CurrentDate += Day
        } else {
          CurrentDate += '0' + Day
        }
        return CurrentDate
      },
	  //qixuzhijixsuan3
	  getDetails(id){
			this.$axios
                .get("/api/front/getjiazhengfuwudetail/"+id,)
                .then(res => {
                  this.jiazhengfuwu = res.data.data;
                  this.editForm.fuwumingcheng = this.jiazhengfuwu.fuwumingcheng;
					this.editForm.leibie = this.jiazhengfuwu.leibie;
					this.editForm.fuwujiage = this.jiazhengfuwu.fuwujiage;
					this.editForm.fuwushichang = this.jiazhengfuwu.fuwushichang;
					this.editForm.gonghao = this.jiazhengfuwu.gonghao;
					this.editForm.mingzi = this.jiazhengfuwu.mingzi;

                  this.editForm.yonghuming= this.username;
                })
                .catch(err => {
                  return Promise.reject(err);
                });

		},

      submitForm(editData) {
        this.$refs[editData].validate(valid => {
          if (valid) {
            if(this.editForm.id){
            }else {
              this.$axios
                      .post("/api/yuyuejiazheng",this.editForm)
                      .then(res => {
                        if (res.data.code == '0') {
						//kuabiaogaizhi1
                          this.$message({
                            type: 'success',
                            message: '添加成功！'
                          })
                        }

						else {
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
    }
  };
</script>
<style>
  @import "../assets/css/index.scss";
  /* 头部CSS */
  #details .page-header {
    height: 64px;
    margin-top: -20px;
    z-index: 4;
    background: #fff;
    border-bottom: 1px solid #e0e0e0;
    -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
  }
  #details .page-header .title {
    width: 1225px;
    height: 64px;
    line-height: 64px;
    font-size: 18px;
    font-weight: 400;
    color: #212121;
    margin: 0 auto;
  }
  #details .page-header .title p {
    float: left;
  }
  #details .page-header .title .list {
    height: 64px;
    float: right;
  }
  #details .page-header .title .list li {
    float: left;
    margin-left: 20px;
  }
  #details .page-header .title .list li a {
    font-size: 14px;
    color: #616161;
  }
  #details .page-header .title .list li a:hover {
    font-size: 14px;
    color: #ff6700;
  }
  /* 头部CSS END */

  /* 主要内容CSS */
  #details .main {
    width: 1225px;
    height: 560px;
    padding-top: 30px;
    margin: 0 auto;
  }
  #details .main .block {
    float: left;
    width: 560px;
    height: 560px;
  }
  #details .el-carousel .el-carousel__indicator .el-carousel__button {
    background-color: rgba(163, 163, 163, 0.8);
  }
  #details .main .content {
    float: left;
    margin-left: 25px;
    width: 640px;
  }
  #details .main .content .name {
    height: 30px;
    line-height: 30px;
    font-size: 24px;
    font-weight: normal;
    color: #212121;
  }
  #details .main .content .intro {
    color: #b0b0b0;
    padding-top: 10px;
  }
  #details .main .content .store {
    color: #ff6700;
    padding-top: 10px;
  }
  #details .main .content .price {
    display: block;
    font-size: 18px;
    color: #ff6700;
    border-bottom: 1px solid #e0e0e0;
    padding: 25px 0 25px;
  }
  #details .main .content .price .del {
    font-size: 14px;
    margin-left: 10px;
    color: #b0b0b0;
    text-decoration: line-through;
  }
  #details .main .content .pro-list {
    background: #f9f9fa;
    padding: 30px 60px;
    margin: 50px 0 50px;
  }
  #details .main .content .pro-list span {
    line-height: 30px;
    color: #616161;
  }
  #details .main .content .pro-list .pro-price {
    float: right;
  }
  #details .main .content .pro-list .pro-price .pro-del {
    margin-left: 10px;
    text-decoration: line-through;
  }
  #details .main .content .pro-list .price-sum {
    color: #ff6700;
    font-size: 24px;
    padding-top: 20px;
  }
  #details .main .content .button {
    height: 55px;
    margin: 10px 0 20px 0;
  }
  #details .main .content .button .el-button {

    float: left;
    height: 55px;
    font-size: 16px;
    color: #fff;
    border: none;
    text-align: center;
  }
  #details .main .content .button .shop-cart {
    width: 340px;
    background-color: #ff6700;
  }
  #details .main .content .button .shop-cart:hover {
    background-color: #f25807;
  }

  #details .main .content .button .like {
    width: 260px;
    margin-left: 40px;
    background-color: #b0b0b0;
  }
  #details .main .content .button .like:hover {
    background-color: #757575;
  }
  #details .main .content .pro-policy li {
    float: left;
    margin-right: 20px;
    color: #b0b0b0;
  }
  /* 主要内容CSS END */
</style>
