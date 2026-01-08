<template>
  <div>
    <el-form :inline="true" :model="formInline" class="user-search">
      <el-form-item label="">
        <el-input size="small" v-model="formInline.fuwumingcheng" placeholder="输入服务名称"></el-input>
      </el-form-item>
      <el-form-item label="">
        <el-input size="small" v-model="formInline.fuwujiage" placeholder="输入服务价格"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>

        <el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">导出
        </el-button>
        <el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()"
                   v-if="userInfo.roles[0] == 'guanliyuan'">批量删除
        </el-button>

      </el-form-item>
      <el-form-item>
        <el-upload class="upload-demo" style="float: left; padding-right: 10px;"
                   action='http://localhost:9999/fuwupingjia/upload' :headers='headers' :show-file-list='false'
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
      <el-table-column sortable prop="fuwujiage" label="服务价格"></el-table-column>
      <el-table-column sortable prop="gonghao" label="工号"></el-table-column>
      <el-table-column sortable prop="manyiqingkuang" label="满意情况"></el-table-column>
      <el-table-column sortable prop="yonghuming" label="用户名"></el-table-column>
      <el-table-column sortable prop="xingming" label="姓名"></el-table-column>

      <el-table-column sortable prop="addtime" label="添加时间" width="160">
        <template slot-scope="scope">
          <div>{{ scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss') }}</div>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" min-width="160">
        <template slot-scope="scope">

          <!--liangbuan-->
          <el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'yonghu'">编辑
          </el-button>
          <el-button size="mini" type="danger" @click="deleteFuwupingjia(scope.$index, scope.row)"
                     v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'yonghu'">删除
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
                    style='width:50%' disabled></el-input>
        </el-form-item>
        <el-form-item label="服务价格" prop="fuwujiage">
          <el-input size="small" v-model="editForm.fuwujiage" auto-complete="off" placeholder="请输入服务价格"
                    style='width:50%' disabled></el-input>
        </el-form-item>
        <el-form-item label="工号" prop="gonghao">
          <el-input size="small" v-model="editForm.gonghao" auto-complete="off" placeholder="请输入工号" style='width:50%'
                    disabled></el-input>
        </el-form-item>
        <el-form-item label='满意情况' prop="manyiqingkuang">
          <el-select size="small" v-model="editForm.manyiqingkuang" placeholder="请选择满意情况">
            <el-option selected label="请选择满意情况" value=""></el-option>
            <el-option label="满意" value="满意"></el-option>
            <el-option label="正常" value="正常"></el-option>
            <el-option label="不满意" value="不满意"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评价内容" prop="pingjianeirong">
          <el-input type="textarea" size="small" v-model="editForm.pingjianeirong" auto-complete="off"
                    placeholder="请输入评价内容" style='width:100%'></el-input>
        </el-form-item>
        <el-form-item label="用户名" prop="yonghuming">
          <el-input size="small" v-model="editForm.yonghuming" auto-complete="off" placeholder="请输入用户名"
                    style='width:50%' disabled></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="xingming">
          <el-input size="small" v-model="editForm.xingming" auto-complete="off" placeholder="请输入姓名"
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

        </tr>
        <tr>
          <td width='11%' height='40px'>用户名：</td>
          <td width='39%'>{{ editForm.yonghuming }}</td>
          <td width='11%' height='40px'>姓名：</td>
          <td width='39%'>{{ editForm.xingming }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>服务名称：</td>
          <td width='39%'>{{ editForm.fuwumingcheng }}</td>
          <td width='11%' height='40px'>服务价格：</td>
          <td width='39%'>{{ editForm.fuwujiage }}</td>
        </tr>
        <tr>

        </tr>
        <tr>
          <td width='11%' height='40px'>服务工号：</td>
          <td width='39%'>{{ editForm.gonghao }}</td>
          <td width='11%' height='40px'>满意情况：</td>
          <td width='39%'>{{ editForm.manyiqingkuang }}</td>
        </tr>
        <tr>
          <td width='11%' height='40px'>评价内容：</td>
          <td width='39%'>{{ editForm.pingjianeirong }}</td>

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
  fuwupingjiaList,
  fuwupingjiaSave,
  fuwupingjiaDelete,
  fuwupingjiaEdit,
  fuwupingjiaDeleteList
} from '@/api/fuwupingjia/fuwupingjiaApi';


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

      detailFormVisible: false,


      editForm: {},
      user: [],
      username: '',
      cx: '',

      rules: {},

      formInline: {
        page: 1,
        limit: 10,
      },


      listData: [],
      fuwupingjias: [],

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
    if (this.userInfo.roles[0] == 'yonghu') {
      this.formInline.yonghuming = this.username;
    }

    this.getdata(this.formInline)

  },
  methods: {

    //zxhifuff
    handleShenheList() {
      const fuwupingjias = this.fuwupingjias;
      if (fuwupingjias.length == 0) {
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
          fuwupingjias.forEach(item => {
            let data = {...item, issh: 1}
            fuwupingjiaEdit(data).then(res => {
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
      fuwupingjiaList(parameter)
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
        this.title = '修改服务评价'
        this.editForm = row
      } else {
        this.title = '添加服务评价'
        this.editForm = {}
        this.editForm.yonghuming = this.username;
        this.editForm.xingming = this.userInfo.xingming;

        //zixdonxgbianxhao1
      }
    },
    daochu() {
      axios.get('/fuwupingjia/getExcel', {
        responseType: 'blob',
        headers: {token: Session.get("token"), 'Content-Type': 'application/x-download'}
      }).then((res) => {
        if (res.status === 200) {
          var a = document.createElement('a')
          var blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
          var href = window.URL.createObjectURL(blob)
          a.href = href
          a.download = '服务评价.xlsx'
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
    //   w.location.href = 'http://localhost:8080/#/fuwupingjiadetail/' + row.id;
    // },
    handleDetail: function (index, row) {
      this.detailFormVisible = true
      if (row != undefined && row != 'undefined') {
        this.title = '服务评价详细'
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
            fuwupingjiaEdit(this.editForm).then(res => {
              this.editFormVisible = false

              this.loading = false
              if (res.code == '0') {
                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '服务评价修改成功！'
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
            fuwupingjiaSave(this.editForm).then(res => {
              this.editFormVisible = false
              this.loading = false
              if (res.code == '0') {

                this.getdata(this.formInline)
                this.$message({
                  type: 'success',
                  message: '服务评价添加成功！'
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
    deleteFuwupingjia(index, row) {
      this.$confirm('确定要删除吗?', '信息', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        fuwupingjiaDelete(row.id).then(res => {
          if (res.code == '0') {
            this.$message({
              type: 'success',
              message: '服务评价已删除!'
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
      this.fuwupingjias = val;
    },
    handleDeleteList() {
      const fuwupingjias = this.fuwupingjias;
      if (fuwupingjias.length == 0) {
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
          fuwupingjiaDeleteList(fuwupingjias).then(res => {
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
