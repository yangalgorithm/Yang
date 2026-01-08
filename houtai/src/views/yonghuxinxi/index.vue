<template>
  <div>
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="">
        <el-input size="small" v-model="formInline.yonghuming" placeholder="输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small" v-model="formInline.xingming" placeholder="输入姓名"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()">添加</el-button>
        <el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">导出
        </el-button>
        <el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">批量删除
        </el-button>

      </el-form-item>
      <el-form-item>
        <el-upload class="upload-demo" style="float: left; padding-right: 10px;"
                   action='http://localhost:9999/yonghuxinxi/upload' :headers='headers' :show-file-list='false'
                   :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload'>
          <el-button size="small" type="info" icon="el-icon-sell" @click="daoru()"
                     v-if="userInfo.roles[0] == 'guanliyuan'">导入
          </el-button>
        </el-upload>
      </el-form-item>
    </el-form>

    <el-table size="small" :data="listData" highlight-current-row v-loading="loading" border
              element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
      <el-table-column align="center" type="selection" width="60"></el-table-column>
      <el-table-column sortable prop="yonghuming" label="用户名"></el-table-column>
      <el-table-column sortable prop="xingming" label="姓名"></el-table-column>
      <el-table-column sortable prop="nicheng" label="昵称"></el-table-column>
      <el-table-column sortable prop="xingbie" label="性别"></el-table-column>
      <el-table-column sortable prop="shenfenzheng" label="身份证"></el-table-column>
      <el-table-column sortable prop="beizhu" label="备注"></el-table-column>
      <el-table-column align='center' prop='touxiang' label='头像' width='120'>
        <template slot-scope='scope'>
          <el-image :src='scope.row.touxiang' style='height:70px' v-if="scope.row.touxiang"/>
          <img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template>
      </el-table-column>

      <el-table-column sortable prop="addtime" label="添加时间" width="160">
        <template slot-scope="scope">
          <div>{{ scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss') }}</div>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" min-width="160">
        <template slot-scope="scope">

          <!--liangbuan-->
          <el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan' ">编辑
          </el-button>
          <el-button size="mini" type="danger" @click="deleteYonghuxinxi(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan' ">删除
          </el-button>
          <el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">详细</el-button>
          <!--zhixfuanniu-->

        </template>
      </el-table-column>
    </el-table>
    <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

    <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
      <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
        <el-form-item label="用户名" prop="yonghuming">
          <el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="xingming">
          <el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="请输入姓名"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="nicheng">
          <el-input size="small" v-model="editForm.nicheng" auto-complete="off" placeholder="请输入昵称"
                    style='width:50%'></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="xingbie">
          <el-input size="small" v-model="editForm.xingbie" auto-complete="off" placeholder="请输入性别"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label='头像' prop='touxiang'>
          <el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers'
                     :show-file-list='false' :on-success='handleTouxiangSuccess' :before-upload='beforeTouxiangUpload'>
            <img v-if='editForm.touxiang' :src='editForm.touxiang' class='avatar'><i v-else
                                                                                     class='el-icon-plus avatar-uploader-icon'></i>
          </el-upload>
        </el-form-item>

        <el-form-item label="手机" prop="shouji">
          <el-input size="small" v-model="editForm.shouji" auto-complete="off" placeholder="请输入手机"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="身份证" prop="shenfenzheng">
          <el-input size="small" v-model="editForm.shenfenzheng" auto-complete="off" placeholder="请输入身份证"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="备注" prop="beizhu">
          <el-input size="small" v-model="editForm.beizhu" auto-complete="off" placeholder="请输入备注"
                    style='width:50%'></el-input>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog">取消</el-button>
        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存
        </el-button>
      </div>
    </el-dialog>


    <el-dialog :title="title" :visible.sync="detailFormVisible" width="60%" @click="closeDialogdetail">
      <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1"
             class="table table-striped table-bordered table-hover">
        <tr>
          <td rowspan=7 align=center>
            <el-upload class='avatar-uploader' :headers='headers' :show-file-list='false'><img v-if='editForm.touxiang'
                                                                                               :src='editForm.touxiang'
                                                                                               class='avatar'><i v-else
                                                                                                                 class='el-icon-plus avatar-uploader-icon'></i>
            </el-upload>
          </td>
        </tr>
        <tr>
          <td width='11%' height='40px'>用户名：</td>
          <td width='39%'>{{ editForm.yonghuming }}</td>
          <td width='11%' height='40px'>姓名：</td>
          <td width='39%'>{{ editForm.xingming }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>昵称：</td>
          <td width='39%'>{{ editForm.nicheng }}</td>
          <td width='11%' height='40px'>性别：</td>
          <td width='39%'>{{ editForm.xingbie }}</td>
        </tr>
        <tr>

        </tr>
        <tr>
          <td width='11%' height='40px'>手机：</td>
          <td width='39%'>{{ editForm.shouji }}</td>
          <td width='11%' height='40px'>身份证：</td>
          <td width='39%'>{{ editForm.shenfenzheng }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>备注：</td>
          <td width='39%'>{{ editForm.beizhu }}</td>
        </tr>
      </table>


      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialogdetail">关闭</el-button>

      </div>
    </el-dialog>
    <!--zhixfudhk-->
  </div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import {
  yonghuxinxiList,
  yonghuxinxiSave,
  yonghuxinxiDelete,
  yonghuxinxiEdit,
  yonghuxinxiDeleteList
} from '@/api/yonghuxinxi/yonghuxinxiApi';


import {Session} from "@/utils/storage";
import axios from 'axios';

export default {
  name: 'user',
  data() {
    return {
      loading: false, //是显示加载
      title: '',

      editFormVisible: false, //控制编辑页面显示与隐藏
      payVisible: false,
      tempdingdanxinxi: '',
      id: '',
      radio: '',
      detailFormVisible: false,


      editForm: {},
      user: [],
      username: '',
      cx: '',

      rules: {
        yonghuming: [{required: true, message: '请输入用户名', trigger: 'blur'},
        ],
        xingming: [{required: true, message: '请输入姓名', trigger: 'blur'},
        ],
        shenfenzheng: [{
          pattern: /^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
          required: true,
          message: '请输入正确身份证号',
          trigger: 'blur'
        }
        ],

      },

      formInline: {
        page: 1,
        limit: 10,
      },


      listData: [],
      yonghuxinxis: [],

      checkmenu: [],
      pageparm: {
        currentPage: 1,
        pageSize: 10,
        total: 0
      }
    };
  },
  computed: {
    headers() {
      return {"token": Session.get("token")}
    }
  },
  watch: {
    '$route'(to, from) {
      // 路由发生变化页面刷新
      this.$router.go(0);
    }
  },
  components: {
    Pagination
  },
  created() {

    if (!Session.get('userInfo')) return false;
    this.userInfo = Session.get('userInfo');
    this.username = localStorage.getItem("username");
    this.cx = localStorage.getItem("cx");

    this.getdata(this.formInline)

  },
  methods: {

    handleTouxiangSuccess(res, file) {
      if (res.code == "0") {
        this.editForm.touxiang = "/files/download/" + res.data.id
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

    //zxhifuff
    handleShenheList() {
      const yonghuxinxis = this.yonghuxinxis;
      if (yonghuxinxis.length == 0) {
        this.$message({
          type: 'error',
          message: '请至少选择一项'
        })
      } else {
        this.$confirm('确定要批量审核吗?', '信息', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          yonghuxinxis.forEach(item => {
            let data = {...item, issh: 1}
            yonghuxinxiEdit(data).then(res => {
            })
          })
          this.getdata(this.formInline)
          this.$message({
            type: 'success',
            message: '批量审核成功！'
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消批量审核'
          })
        })
      }
    },
    getdata(parameter) {
      yonghuxinxiList(parameter)
          .then(res => {
            this.loading = false
            if (res.success == false) {
              this.$message({
                type: 'info',
                message: res.msg
              })
            } else {
              this.listData = res.data.list


              // 分页赋值
              this.pageparm.currentPage = this.formInline.current
              this.pageparm.pageSize = this.formInline.currentNum
              this.pageparm.total = res.data.total
            }
          })
          .catch(err => {
            this.loading = false
            this.$message.error('菜单加载失败，请稍后再试！')
          })
    },

    // 分页插件事件
    callFather(parm) {
      this.formInline.current = parm.currentPage
      this.getdata(this.formInline)
    },

    // 搜索事件
    search() {
      this.getdata(this.formInline)
    },
    //显示编辑界面
    handleEdit: function (index, row) {
      this.editFormVisible = true
      if (row != undefined && row != 'undefined') {
        this.title = '修改用户信息'
        this.editForm = row
      } else {
        this.title = '添加用户信息'
        this.editForm = {}


        //zixdonxgbianxhao1
      }
    },
    daochu() {
      axios.get('/yonghuxinxi/getExcel', {
        responseType: 'blob',
        headers: {token: Session.get("token"), 'Content-Type': 'application/x-download'}
      }).then((res) => {
        if (res.status === 200) {
          var a = document.createElement('a')
          var blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
          var href = window.URL.createObjectURL(blob)
          a.href = href
          a.download = '用户信息.xlsx'
          document.body.appendChild(a)
          a.click()
          document.body.removeChild(a)
          window.URL.revokeObjectURL(href)
        }
      }).catch((err) => {
        console.log(err)
      })
    },
    handleDaoruSuccess(res, file) {
      if (res.code == "0") {
        this.$message({
          type: 'success',
          message: '导入成功!'
        })
        this.getdata(this.formInline);
      }
    },
    beforeDaoruUpload(file) {
      const isJPG = file.type === 'application/vnd.ms-excel';
      if (!isJPG) {
        this.$message.error('上传只能是 excel 格式!');
      }
      return isJPG;
    },
    //zixdonxgbianxhao2

    handleDetail: function (index, row) {
      this.detailFormVisible = true
      if (row != undefined && row != 'undefined') {
        this.title = '用户信息详细'
        this.editForm = row
      }

    },
    closeDialogdetail() {
      this.getdata(this.formInline)
      this.detailFormVisible = false
    },
    //liangbuedit
    // 编辑、增加页面保存方法
    submitForm(editData) {

      this.$refs[editData].validate(valid => {
        if (valid) {
          if (this.editForm.id) {
            yonghuxinxiEdit(this.editForm).then(res => {
              this.editFormVisible = false

              this.loading = false
              if (res.code == '0') {
                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '用户信息修改成功！'
                })
              } else {
                this.$message({
                  type: 'info',
                  message: res.msg
                })
              }
            }).catch(err => {
              this.editFormVisible = false
              this.loading = false
              this.getdata(this.formInline)
              if (err) {
                this.$message.error(err)
              } else {
                this.$message.error('操作失败，请稍后再试！')
              }
            })
          } else {
            yonghuxinxiSave(this.editForm).then(res => {
              this.editFormVisible = false
              this.loading = false
              if (res.code == '0') {

                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '用户信息添加成功！'
                })
              } else {
                this.$message({
                  type: 'info',
                  message: res.msg
                })
              }
            }).catch(err => {
              this.editFormVisible = false
              this.loading = false
              if (err) {
                this.$message.error(err)
              } else {
                this.$message.error('操作失败，请稍后再试！')
              }
            })
          }
        } else {
          return false
        }
      })
    },
    // 删除公司
    deleteYonghuxinxi(index, row) {
      this.$confirm('确定要删除吗?', '信息', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        yonghuxinxiDelete(row.id).then(res => {
          if (res.code == '0') {
            this.$message({
              type: 'success',
              message: '用户信息已删除!'
            })
            this.getdata(this.formInline)
          } else {
            this.$message({
              type: 'info',
              message: res.msg
            })
          }
        }).catch(err => {
          this.loading = false
          this.$message.error('操作失败，请稍后再试')
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleSelectionChange(val) {
      this.yonghuxinxis = val;
    },
    handleDeleteList() {
      const yonghuxinxis = this.yonghuxinxis;
      if (yonghuxinxis.length == 0) {
        this.$message({
          type: 'error',
          message: '请至少选择一项进行删除'
        })
      } else {
        this.$confirm('确定要批量删除吗?', '信息', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          yonghuxinxiDeleteList(yonghuxinxis).then(res => {
            if (res.code == '0') {
              this.$message({
                type: 'success',
                message: '批量删除成功!'
              })
              this.getdata(this.formInline)
            } else {
              this.$message({
                type: 'info',
                message: res.msg
              })
            }
          }).catch(err => {
            this.loading = false
            this.$message.error('操作失败，请稍后再试')
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      }
    },
    editxingbie(index, row) {
      let data = {...row, xingbie: !row.xingbie}
      yonghuxinxiEdit(data).then(res => {
        this.editFormVisible = false
        this.loading = false
        if (res.code == '0') {
          this.getdata(this.formInline)
          this.$message({
            type: 'success',
            message: '性别修改成功！'
          })
        } else {
          this.$message({
            type: 'info',
            message: res.msg
          })
        }
      }).catch(err => {
        this.editFormVisible = false
        this.loading = false
        if (err) {
          this.$message.error(err)
        } else {
          this.$message.error('操作失败，请稍后再试！')
        }
      })
    },
    //xuaxnzeshxifou


    //youscwexnjiaxn
    // 关闭编辑、增加弹出框
    closeDialog() {
      this.getdata(this.formInline)
      this.editFormVisible = false
    }
  },
};
</script>

<style scoped lang="scss">
@import './index.scss';
</style>
