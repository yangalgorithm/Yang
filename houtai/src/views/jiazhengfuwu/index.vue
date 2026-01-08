<template>
  <div>
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="">
        <el-input size="small" v-model="formInline.fuwumingcheng" placeholder="输入服务名称"></el-input>
      </el-form-item>
      <el-form-item prop="leibie">
        <el-select size="small" v-model="formInline.leibie" placeholder="请选择">
          <el-option selected label="请选择" value=""></el-option>
          <el-option v-for="item in fuwuleibies" :key="item.leibie" :label="item.leibie"
                     :value="item.leibie"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small" v-model="formInline.fuwujiage" placeholder="输入服务价格"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>
        <el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()"
                   v-if="userInfo.roles[0] == 'yuangong'">添加
        </el-button>
        <el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">导出
        </el-button>
        <el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">批量删除
        </el-button>

      </el-form-item>
      <el-form-item>
        <el-upload class="upload-demo" style="float: left; padding-right: 10px;"
                   action='http://localhost:9999/jiazhengfuwu/upload' :headers='headers' :show-file-list='false'
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
      <el-table-column sortable prop="fuwumingcheng" label="服务名称"></el-table-column>
      <el-table-column sortable prop="leibie" label="类别"></el-table-column>
      <el-table-column sortable prop="fuwujiage" label="服务价格"></el-table-column>
      <el-table-column sortable prop="fuwushichang" label="服务时长"></el-table-column>
      <el-table-column align='center' prop='tupian' label='图片' width='120'>
        <template slot-scope='scope'>
          <el-image :src='scope.row.tupian' style='height:70px' v-if="scope.row.tupian"/>
          <img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template>
      </el-table-column>
      <el-table-column sortable prop="gonghao" label="工号"></el-table-column>
      <el-table-column sortable prop="mingzi" label="名字"></el-table-column>


      <el-table-column align="center" label="操作" min-width="160">
        <template slot-scope="scope">

          <!--liangbuan-->
          <el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'yuangong'">编辑
          </el-button>
          <el-button size="mini" type="danger" @click="deleteJiazhengfuwu(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'yuangong'">删除
          </el-button>
          <el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">详细</el-button>
          <!--zhixfuanniu-->

        </template>
      </el-table-column>
    </el-table>
    <Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>

    <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
      <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
        <el-form-item label="服务名称" prop="fuwumingcheng">
          <el-input size="small" v-model="editForm.fuwumingcheng" auto-complete="off" placeholder="请输入服务名称"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label='类别' prop="leibie">
          <el-select size="small" v-model="editForm.leibie" placeholder="请选择">
            <el-option selected label="请选择" value=""></el-option>
            <el-option v-for="item in fuwuleibies" :key="item.leibie" :label="item.leibie"
                       :value="item.leibie"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="服务价格" prop="fuwujiage">
          <el-input size="small" v-model="editForm.fuwujiage" auto-complete="off" placeholder="请输入服务价格"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label="服务时长" prop="fuwushichang">
          <el-input size="small" v-model="editForm.fuwushichang" auto-complete="off" placeholder="请输入服务时长"
                    style='width:50%'></el-input>
        </el-form-item>
        <el-form-item label='图片' prop='tupian'>
          <el-upload class='avatar-uploader' action='http://localhost:9999/files/upload' :headers='headers'
                     :show-file-list='false' :on-success='handleTupianSuccess' :before-upload='beforeTupianUpload'><img
              v-if='editForm.tupian' :src='editForm.tupian' class='avatar'><i v-else
                                                                              class='el-icon-plus avatar-uploader-icon'></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="服务简介" prop="fuwujianjie">
          <el-input type="textarea" size="small" v-model="editForm.fuwujianjie" auto-complete="off"
                    placeholder="请输入服务简介" style='width:100%'></el-input>
        </el-form-item>
        <el-form-item label="工号" prop="gonghao">
          <el-input size="small" v-model="editForm.gonghao" auto-complete="off" placeholder="请输入工号" style='width:50%'
                    disabled></el-input>
        </el-form-item>
        <el-form-item label="名字" prop="mingzi">
          <el-input size="small" v-model="editForm.mingzi" auto-complete="off" placeholder="请输入名字"
                    style='width:50%'></el-input>
        </el-form-item>


      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click="closeDialog">取消</el-button>
        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存
        </el-button>
      </div>
    </el-dialog>


    <!--xiangxidhk-->
    <el-dialog :title="title" :visible.sync="detailFormVisible" width="60%" @click="closeDialogdetail">
      <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1"
             class="table table-striped table-bordered table-hover">
        <tr>
          <td rowspan=7 align=center>
            <el-upload class='avatar-uploader' :headers='headers' :show-file-list='false'><img v-if='editForm.tupian'
                                                                                               :src='editForm.tupian'
                                                                                               class='avatar'><i v-else
                                                                                                                 class='el-icon-plus avatar-uploader-icon'></i>
            </el-upload>
          </td>
        </tr>
        <tr>
          <td width='11%' height='40px'>服务名称：</td>
          <td width='39%'>{{ editForm.fuwumingcheng }}</td>
          <td width='11%' height='40px'>服务价格：</td>
          <td width='39%'>{{ editForm.fuwujiage }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>服务时长：</td>
          <td width='39%'>{{ editForm.fuwushichang }}</td>
          <td width='11%' height='40px'>类别：</td>
          <td width='39%'>{{ editForm.leibie }}</td>
        </tr>
        <tr>

        </tr>
        <tr>
          <td width='11%' height='40px'>服务简介：</td>
          <td width='39%'>{{ editForm.fuwujianjie }}</td>
          <td width='11%' height='40px'>服务工号：</td>
          <td width='39%'>{{ editForm.gonghao }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>员工姓名：</td>
          <td width='39%'>{{ editForm.mingzi }}</td>
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
  jiazhengfuwuList,
  jiazhengfuwuSave,
  jiazhengfuwuDelete,
  jiazhengfuwuEdit,
  jiazhengfuwuDeleteList
} from '@/api/jiazhengfuwu/jiazhengfuwuApi';
import {fuwuleibieAllList} from "@/api/fuwuleibie/fuwuleibieApi";


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
      //detaitFormVsisisble


      editForm: {},
      user: [],
      username: '',
      cx: '',
      fuwuleibies: [],

      rules: {
        fuwumingcheng: [{required: true, message: '请输入服务名称', trigger: 'blur'},
        ],
        leibie: [{required: true, message: '请输入类别', trigger: 'blur'},
        ],

      },

      formInline: {
        page: 1,
        limit: 10,
      },


      listData: [],
      jiazhengfuwus: [],
      detailFormVisible: false,
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
    if (this.userInfo.roles[0] == 'yuangong') {
      this.formInline.gonghao = this.username;
    }

    this.getdata(this.formInline)
    this.getAllfuwuleibie();

  },
  methods: {
    closeDialogdetail() {
      this.getdata(this.formInline)
      this.detailFormVisible = false
    },
    //zxhifuff
    handleShenheList() {
      const jiazhengfuwus = this.jiazhengfuwus;
      if (jiazhengfuwus.length == 0) {
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
          jiazhengfuwus.forEach(item => {
            let data = {...item, issh: 1}
            jiazhengfuwuEdit(data).then(res => {
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
      jiazhengfuwuList(parameter)
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
        this.title = '修改服务项目'
        this.editForm = row
      } else {
        this.title = '添加服务项目'
        this.editForm = {}
        this.editForm.gonghao = this.username;
        this.editForm.mingzi = this.userInfo.mingzi;

        //zixdonxgbianxhao1
      }
    },
    daochu() {
      axios.get('/jiazhengfuwu/getExcel', {
        responseType: 'blob',
        headers: {token: Session.get("token"), 'Content-Type': 'application/x-download'}
      }).then((res) => {
        if (res.status === 200) {
          var a = document.createElement('a')
          var blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
          var href = window.URL.createObjectURL(blob)
          a.href = href
          a.download = '服务项目.xlsx'
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

    // handleDetail(index, row) {
    //   const w = window.open("about:blank");
    //   w.location.href = 'http://localhost:8080/#/jiazhengfuwudetail/' + row.id;
    // },
    handleDetail(index, row) {
      this.detailFormVisible = true
      if (row != undefined && row != 'undefined') {
        this.title = '家政信息详细'
        this.editForm = row
      }
    },
    //liangbuedit
    // 编辑、增加页面保存方法
    submitForm(editData) {

      this.$refs[editData].validate(valid => {
        if (valid) {
          if (this.editForm.id) {
            jiazhengfuwuEdit(this.editForm).then(res => {
              this.editFormVisible = false

              this.loading = false
              if (res.code == '0') {
                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '服务项目修改成功！'
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
            jiazhengfuwuSave(this.editForm).then(res => {
              this.editFormVisible = false
              this.loading = false
              if (res.code == '0') {

                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '服务项目添加成功！'
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
    deleteJiazhengfuwu(index, row) {
      this.$confirm('确定要删除吗?', '信息', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        jiazhengfuwuDelete(row.id).then(res => {
          if (res.code == '0') {
            this.$message({
              type: 'success',
              message: '服务项目已删除!'
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
      this.jiazhengfuwus = val;
    },
    handleDeleteList() {
      const jiazhengfuwus = this.jiazhengfuwus;
      if (jiazhengfuwus.length == 0) {
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
          jiazhengfuwuDeleteList(jiazhengfuwus).then(res => {
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
    //xuaxnzeshxifou


    getAllfuwuleibie() {
      fuwuleibieAllList().then(res => {
        if (res.code == '0') {
          this.fuwuleibies = res.data
        }
      })
    },

    handleTupianSuccess(res, file) {
      if (res.code == "0") {
        this.editForm.tupian = "/files/download/" + res.data.id
      }
    },
    beforeTupianUpload(file) {
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
