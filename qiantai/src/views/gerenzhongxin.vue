<template>
  <div class="goods" id="goods" name="goods">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
        <el-breadcrumb-item>个人中心</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="main">
      <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
        <el-tab-pane label="修改资料" name="first">
          <div v-if="!this.userinfoForm.id">
            <div>请登录</div>
          </div>
          <div v-else>
            <el-tabs v-model="activeNameUser" @tab-click="handleClickUser">
              <el-tab-pane label="修改资料" name="first">
                <el-form label-width="150px">


                  <el-form-item  label="用户名" prop="yonghuming"><el-input size="small" v-model="userinfoForm.yonghuming" auto-complete="off" placeholder="请输入用户名" style='width:25%'></el-input></el-form-item>

                  <el-form-item  label="姓名" prop="xingming"><el-input size="small" v-model="userinfoForm.xingming" auto-complete="off" placeholder="请输入姓名" style='width:25%'></el-input></el-form-item>
                  <el-form-item  label="性别" prop="xingbie"><el-radio v-model="userinfoForm.xingbie" :label=true>男</el-radio><el-radio v-model="userinfoForm.xingbie" :label=false>女</el-radio></el-form-item>
                  <el-form-item  label="手机" prop="shouji"><el-input size="small" v-model="userinfoForm.shouji" auto-complete="off" placeholder="请输入手机" style='width:25%'></el-input></el-form-item>
                  <el-form-item  label='头像' prop='touxiang'>
                    <el-upload class='avatar-uploader' action='/api/files/upload'
                               :show-file-list='false' :on-success='handleZhaopianSuccess'
                               :before-upload='beforeZhaopianUpload'><img v-if='userinfoForm.touxiang'  :src='`/api/`+userinfoForm.touxiang' class='avatar'  style="width: 220px; height: 240px"><i
                            v-else class='el-icon-plus avatar-uploader-icon'></i></el-upload>
                  </el-form-item>



                  <el-button style="margin-left: 50%;" type="primary" @click="userTijiao()" >提交</el-button>
                </el-form>
              </el-tab-pane>
              <el-tab-pane label="修改密码" name="second">
                <el-form label-width="150px" :model="editForm">
                  <el-form-item  label="原密码" prop="password">
                    <el-input placeholder="请输入密码" v-model="editForm.password" show-password style='width:50%'/>
                  </el-form-item>
                  <el-form-item  label="新密码" prop="newPassword">
                    <el-input placeholder="请输入新密码" v-model="editForm.newPassword" show-password style='width:50%'/>
                  </el-form-item>
                  <el-form-item  label="确认密码" prop="newPassword2">
                    <el-input placeholder="请输入确认密码" v-model="editForm.newPassword2" show-password style='width:50%'/>
                  </el-form-item>
                  <el-button size="small" style="margin-left: 50%;" type="primary" class="title" @click="submitForm()">修改</el-button>
                </el-form>
              </el-tab-pane>
            </el-tabs>
          </div>

        </el-tab-pane>


      </el-tabs>

    </div>
  </div>
</template>
<script>
  import user from "@/store/modules/user";

  export default {
    data() {
      return {
          username:'',
          cx:'',
        activeName: 'first',
        activeNameUser: 'first',
        userinfoForm:{},
        baomingxinxi:[],
          xianzhiziyuan:[],
        editForm: {},
        activeNamePingJ: 'first',
        //在线预定管理
        formQuery:{},//预定查询
        tableData: [],
        //修改预定弹窗





        zhifusyn: false,
        radio: '',
        zhifuitem: {},
        yonghupingjiaadd: false,
        yonghupingjFormAdd:{},

        yhpj:[],
        formInline:{},
        xgyhpingjia:false,
        xgyhpjForm:{},
        pjxxDetail: false,
        pjxxDetailForm:{}
      };
    },

    created() {
      let user = localStorage.getItem("user");
      if(!user){
        this.notifyError("请先登录");
      }
        if (localStorage.getItem("user")) {
            // 如果已经登录，设置vuex登录状态
            //this.setUser(JSON.parse(localStorage.getItem("user")));
            this.userInfo=JSON.parse(localStorage.getItem("user"));
            this.userinfoForm = JSON.parse(localStorage.getItem("user"))
            this.username = localStorage.getItem("username");
            this.cx = localStorage.getItem("cx");
        }
        this.formInline.faburen=this.username;
        this.formInline.zhanghao=this.username;

    },
    activated() {
    },
    methods: {
      handleClick(tab) {
        if(tab.index == 1){
          this.zaixianyudingList()
        }else if(tab.index == 2){
          this.zaixianyudingList()
        }
      },
      //修改资料和修改密码
      handleClickUser(tab, event) {
        let user = localStorage.getItem("user");
        if(!user){
          this.notifyError("请先登录");
        }
        this.userinfoForm = JSON.parse(localStorage.getItem("user"))
        if(tab.index == 0){
          console.log(tab, event);
        }else{
          console.log(tab, event);
        }
      },
      //修改用户提交
      userTijiao(){
        let user = localStorage.getItem("user");
        if(!user){
          this.notifyError("请先登录");
        }
        var userinfo = this.userinfoForm
        this.$axios.post('/api/front/updateYongHu', userinfo).then(res => {
          if (res.data.code === '0') {
            let user = JSON.stringify(res.data.data);
            localStorage.setItem("user", user);
            this.notifySucceed('成功')
          } else {
            alert(res.data.msg);
          }
        })
      },

      handleZhaopianSuccess(res, file) {
        if (res.code == "0") {
          this.userinfoForm.touxiang = "/files/download/" + res.data.id
            this.$forceUpdate()
        }
      },
      beforeZhaopianUpload(file) {
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




      //修改密码
      submitForm(){
        let user = localStorage.getItem("user");
        if(!user){
          this.notifyError("请先登录");
        }
        this.userinfoForm = JSON.parse(localStorage.getItem("user"))
        this.editForm.id = this.userinfoForm.id
        this.editForm.mima = this.editForm.password
        if(this.editForm.newPassword !== this.editForm.newPassword2){
          return this.notifyError('新密码输入不一致，请重新输入');
        }
        this.$axios.post('/api/front/updatePasswordNew', this.editForm).then(res => {
          if (res.data.code === '0') {
            this.editForm = {}
            this.notifySucceed('成功')
          } else {
            alert(res.data.msg);
          }
        })
      },





    },
  };
</script>
<style scoped>
  .goods {
    background-color: #f5f5f5;
  }
  .el-tabs--card .el-tabs__header {
    border-bottom: none;
  }
  .goods .breadcrumb {
    height: 50px;
    background-color: white;
  }
  .goods .breadcrumb .el-breadcrumb {
    width: 1225px;
    line-height: 30px;
    font-size: 16px;
    margin: 0 auto;
  }
  .goods .nav {
    background-color: white;
  }
  .goods .nav .product-nav {
    width: 1225px;
    height: 40px;
    line-height: 40px;
    margin: 0 auto;
  }
  .nav .product-nav .title {
    width: 50px;
    font-size: 16px;
    font-weight: 700;
    float: left;
  }
  .goods .main {
    margin: 0 auto;
    max-width: 1225px;
  }
  .goods .main .list {
    min-height: 650px;
    padding-top: 14.5px;
    margin-left: -13.7px;
    overflow: auto;
  }
  .goods .main .pagination {
    height: 50px;
    text-align: center;
  }
  .goods .main .none-product {
    color: #333;
    margin-left: 13.7px;
  }
</style>