<template>
<!--  <div id="app" name="app">-->
<!--    <el-container>-->
<!--      &lt;!&ndash; 顶部导航栏 &ndash;&gt;-->
<!--      <div>-->
<!--        <table width="100%" border="0" align="center" style="background-color:#666699">-->
<!--          <tr>-->
<!--            <td width="10%">&nbsp;</td>-->
<!--            <td align="left">-->
<!--              <li v-if="!this.$store.getters.getUser" style="float:left">-->
<!--                <el-button type="text" @click="login" style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--    background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;">登录-->
<!--                </el-button>-->
<!--                <span class="sep">|</span>-->
<!--                <el-button type="text" @click="register = true" style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--   background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;">注册-->
<!--                </el-button>-->
<!--              </li>-->
<!--              <li v-else>-->
<!--                <font color="white"> 欢迎 {{ username }} [{{ cx }}]</font>&nbsp;-->
<!--                <el-button type="text" @click="logout" style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--   background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;">退出-->
<!--                </el-button>-->
<!--                <router-link :to="`/Collect/`" class="el-button el-button&#45;&#45;text" style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--     background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;">-->
<!--                  我的收藏-->
<!--                </router-link>-->
<!--                <router-link :to="`/gerenzhongxin/`" class="el-button el-button&#45;&#45;text" style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--     background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;">-->
<!--                  个人中心-->
<!--                </router-link>-->
<!--                <el-popover placement="top" width="180" v-model="visible">-->
<!--                  <p>确定退出登录吗？</p>-->
<!--                  <div style="text-align: right; margin: 10px 0 0">-->
<!--                    <el-button size="mini" type="text" @click="visible = false">取消</el-button>-->
<!--                    <el-button type="primary" size="mini" @click="logout">确定</el-button>-->
<!--                  </div>-->
<!--                  <el-button type="text" slot="reference">{{ this.$store.getters.getUser.userName }}</el-button>-->
<!--                </el-popover>-->
<!--              </li>-->
<!--              <li v-if="!this.$store.getters.getUser"><span class="sep">|</span>-->
<!--                <el-button type='text' style="color: #fff;-->
<!--    display: inline-block;-->
<!--    text-transform: uppercase;-->
<!--    text-decoration: none;-->
<!--    background: rgb(102 216 86);-->
<!--    text-align: center;-->
<!--    padding: 6px 30px;-->
<!--    font-weight: bold;" @click="hsghoutai()">跳转后台-->
<!--                </el-button>-->
<!--              </li>-->
<!--            </td>-->
<!--          </tr>-->
<!--        </table>-->


        <div>
          <div class="header">
            <div class="header-left">
              <img src="./assets/15.png" alt="" style="width: 50px;height: 50px">
              <div class="title">
                汽车养护电商平台</div>
            </div>

            <div class="header-center">
              <div class="header-nav">
                <el-menu :default-active="$route.path" mode="horizontal" router>
                  <el-menu-item index="/">首页</el-menu-item>
                  <el-menu-item index="/yuangongxinxilisttp" >员工信息</el-menu-item>
                  <el-menu-item index="/jiazhengfuwulisttp" >汽车预约服务</el-menu-item>
                  <el-menu-item index="/fuwupingjia" >服务评价</el-menu-item>
                  <el-submenu index="2">
                    <template slot="title">站内新闻</template>
                    <el-menu-item index="/xinwentongzhi/站内新闻">站内新闻</el-menu-item>
                  </el-submenu>
                  <el-menu-item index="/liuyan" >在线留言</el-menu-item>

                  <el-menu-item index="/Collect/" v-if="this.$store.getters.getUser">我的收藏</el-menu-item>
<!--                  <el-menu-item index="/gerenzhongxin/" v-if="this.$store.getters.getUser">个人中心</el-menu-item>-->
                </el-menu>
              </div>
            </div>



           <div class="header-right">
             <div v-if="!this.$store.getters.getUser.yonghuming" style="display: flex; align-items: center; cursor: pointer;" @click="login">
               <div style="width: 130px; margin-right: 30px;"></div>
               <div style="width: 50px; height: 50px; border-radius: 50%; border: 1px solid #c8c9cb; display: flex; justify-content: center; align-items: center;">
                 <i class="el-icon-user" style="font-size: 24px;"></i>
               </div>
             </div>

             <div v-else>

                <el-dropdown>
                  <div class="header-dropdown" style="display: flex;align-items: center">

                    <div style="margin-left: 10px">
                      <span style="color: #4c5a73;font-weight: bold;font-size: 14px;margin-right: 20px">欢迎您，{{this.$store.getters.getUser.yonghuming}}</span>
                      <i class="el-icon-arrow-down" style="margin-left: 5px"></i>
                      <!-- el-icon-setting   el-icon-arrow-down-->
                    </div>
                    <img :src="'/api'+this.$store.getters.getUser.touxiang" alt="" style="width:40px;height:40px;border-radius: 50%"  v-if="this.$store.getters.getUser.touxiang" >
                    <img src="@/assets/avtar.jpeg" alt="" v-else>
                  </div>
                  <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>
                      <div>
                        <RouterLink to="/gerenzhongxin/">个人中心</RouterLink>
                      </div>
                    </el-dropdown-item>
                    <el-dropdown-item>
                      <div style="text-decoration: none" @click="logout">退出</div>
                    </el-dropdown-item>
                  </el-dropdown-menu>
                </el-dropdown>
              </div>
            </div>

          </div>

          <!--    轮播图-->
          <div class="main-line" style="width: 90%;margin: 20px auto">
            <div class="main-line-1">
              <div class="main-img">
                <el-carousel height="40vh"  :interval="2000">
                  <el-carousel-item v-for="(item,index) in carouselItems" :key="index">
                    <img :src="'/api/'+item.tupian" alt=""  style="height: 100%;width: 100%;">
                  </el-carousel-item>
                </el-carousel>
              </div>
            </div>
          </div>

<!--          &lt;!&ndash; 登录模块 &ndash;&gt;-->
          <MyLogin  @fromChild="handleRegister"></MyLogin>
<!--          &lt;!&ndash; 注册模块 &ndash;&gt;-->
<!--          <MyRegister :register="register" @fromChild="isRegister"></MyRegister>-->






<!--        <div class="w1200 clearfix">-->
<!--          <div class="logo">-->
<!--            <a href="#" style="font-size:18px; color:#993300"><img src="./assets/20191209094251_803.png"/>汽车预约服务</a>-->
<!--          </div>-->

<!--        </div>-->
<!--      </div>-->
<!--      <div style=" margin: 0 auto;-->
<!--      max-width: 100%;-->
<!--      width: 100%;">-->
<!--        <el-carousel height="480px" indicator-position="outside">-->
<!--          <el-carousel-item v-for="item in carouselItems" :key="item.id">-->
<!--            <img :src="'/api/'+item.tupian" style="height: 480px; width: 100%"/>-->
<!--          </el-carousel-item>-->
<!--        </el-carousel>-->
<!--      </div>-->
<!--      <MyLogin></MyLogin>-->
<!--      <MyRegister :register="register" @fromChild="isRegister"></MyRegister>-->

      <!-- 主要区域容器 -->
      <el-main>
        <keep-alive>
          <router-view></router-view>
        </keep-alive>
      </el-main>
      <!-- 主要区域容器END -->
      <el-footer>
        <div class="footer">
          <div class="d_jjaj">
            <div class="w1200 clearfix">
              <div class="f_link fl" style="color: white">友情链接：</div>
              <div class="k1 fr">
                <a href="http://www.163.com">网易</a> |
                <a href="http://www.qq.com">QQ</a> |
                <a href="http://www.sina.com">新浪</a> |
                <a href="http://www.google.cn">谷歌</a> |
                <a href="http://www.baidu.com">百度</a> |
              </div>
            </div>
          </div>
          <div class="foot_bj">
            <div class="foot1">
              <div class="w1200 clearfix">
                <div class="fo_at1 fl">
                  <div class="d_nav"><p><a href="#" target="_self">首页</a><a href="#" target="_self">关于我们</a><a href="#"
                                                                                                               target="_self">产品中心</a><a
                      href="#" target="_self">资质荣誉</a><a href="#" target="_self">新闻资讯</a><a href="#"
                                                                                            target="_self">阿里巴巴</a><a
                      href="#" target="_self">联系我们</a></p></div>
                  <div class="d_lanxi"><p>联系电话：xxxxxxx</p>
                    <p>公司网址：www.xxxxxxx.com.cn</p>
                    <p>公司地址：xxxxxxxx</p></div>
                </div>
                <div class="fo_at2 clearfix fr">
                  <div class="d_ewrm fr"><p></p></div>
                  <div class="fr d_ahjhj">
                    <a href="#" class="msg_more fr">在线留言</a>
                    <div class="clearboth"></div>
                    <h2>全国销售咨询热线<span>400-xxx-xxxx</span></h2>
                  </div>
                </div>
              </div>
            </div>
            <div class="foot2">
              <div class="w1200 clearfix">
                <div class="d_banq fl">
                  版权所有： All Rights Reservedssss. 技术支持：<a rel='nofollow' href='#' target='_blank'>汽车养护电商平台</a>
                </div>
                <div class="d_ruu fr">
                  <div><a href="#" title="热推信息">热推信息</a>&nbsp;&nbsp;|&nbsp;&nbsp;主营区域：
                    <span><a href="#">河北</a></span>
                    <span><a href="#">济宁</a></span>
                    <span><a href="#">辽宁</a></span>
                    <span><a href="#">四川</a></span>
                    <span><a href="#">安徽</a></span>
                    <span><a href="#">山东</a></span>
                    <span><a href="#">济南</a></span>
                    <span><a href="#">山西</a></span>
                    <span><a href="#">湖北</a></span>
                    <span><a href="#">聊城</a></span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </el-footer>
<!--    </el-container>-->
  </div>

</template>
<script>
import {mapActions} from "vuex";
import {mapGetters} from "vuex";

export default {
  beforeUpdate() {
    this.activeIndex = this.$route.path;
  },
  data() {
    return {
      carouselItems: [], // 存储轮播图数据
      activeIndex: "", // 头部导航栏选中的标签
      search: "", // 搜索条件
      register: false, // 是否显示注册组件
      visible: false, // 是否退出登录
      username: '',
      cx: '',
    };
  },
  created() {
    // 获取浏览器localStorage，判断用户是否已经登录
    if (localStorage.getItem("user")) {
      // 如果已经登录，设置vuex登录状态
      this.setUser(JSON.parse(localStorage.getItem("user")));
      this.username = localStorage.getItem("username");
      this.cx = localStorage.getItem("cx");
    }
    this.fetchCarouselData();
  },
  computed: {
    ...mapGetters(["getUser", "getNum"])
  },
  watch: {},
  methods: {
    fetchCarouselData() {
      this.$axios
          .get("/api/front/bianhuantu", {})
          .then(res => {
            let data = res.data.data;
            let filteredData = [];
            data.forEach(item => {
              filteredData.push(item);
            });
            this.carouselItems = filteredData;
          })
          .catch(err => {
            return Promise.reject(err);
          });
    },
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    login() {
      // 点击登录按钮, 通过更改vuex的showLogin值显示登录组件
      this.setShowLogin(true);
    },
    goToPerson() {
      // const w = window.open("about:blank");
      // w.location.href = 'http://localhost:9999/#/';

    },
    hsghoutai() {
      const w = window.open("about:blank");
      w.location.href = 'http://localhost:9999/#/';
    },
    // 退出登录
    logout() {
      this.visible = false;
      // 清空本地登录信息
      localStorage.setItem("user", "");
      // 清空vuex登录信息
      this.setUser("");
      this.notifySucceed("成功退出登录");
    },
    // 接收注册子组件传过来的数据
    isRegister(val) {
      this.register = val;
    },
  }
};
</script>

<style>
/* 全局CSS */
.newsline TD {
  LINE-HEIGHT: 25px;
  BORDER-BOTTOM: #c9c9c9 1px dashed;
  text-align: left;
}

.newsline TD A:link {
  COLOR: #000
}

.newsline TD A:visited {
  COLOR: #000
}

.newsline TD A:hover {
  COLOR: #000
}

.newsline TD A:active {
  COLOR: #000
}

html {
  margin: 0;
  padding: 0;
  border: 0;
}

body, div, span, object, iframe, h1, h2, h3, h4, p, blockquote, pre, a, address, code, b, em, img,
dl, dt, dd, ol, ul, li, fieldset, form, label, footer,
header, hgroup, nav, section {
  margin: 0;
  padding: 0;
  border: 0;
}

body {
  background: #fff;
  color: #666;
  position: relative;
  font: 12px/1.5 Microsoft YaHei, arial, 宋体, sans-serif;
  vertical-align: baseline;
  width: 100%;
  overflow-x: hidden;
}

a {
  text-decoration: none;
  outline: none;
}

a:link {
  color: #666;
}

a:visited {
  color: #666;
}

a:hover, a:active, a:focus {
  color: #3cb98c;
  text-decoration: none;
  outline: none;
}

input {
  padding: 0;
  margin: 0;
  font-family: 'Microsoft YaHei';
}

img {
  border: none;
  background: none;
  vertical-align: middle;
}

ul, ol, li {
  list-style-type: none;
}

select, input, img, select {
  vertical-align: middle;
}

table {
  border-collapse: collapse;
  border-spacing: 0
}

table, th, td {
  vertical-align: middle
}

.clearfix:after {
  content: ".";
  display: block;
  height: 0;
  clear: both;
  overflow: hidden;
  visibility: hidden;
}

.clearfix {
  zoom: 1
}

.clearboth {
  height: 0px;
  line-height: 0px;
  overflow: hidden;
  clear: both;
  font-size: 0px;
}

h1, h2, h3, h4 {
  font-size: 12px;
  font-weight: bold;
}

hr {
  border: 0;
  border-top: 1px solid #ccc;
  height: 0;
}


.key_tag {
  text-decoration: underline;
}

/*导航栏样式*/
.nav {
  height: 54px;
  width: auto;
  margin: 0 auto;
}

.nav li {
  line-height: 54px;
  height: 54px;
  text-align: center;
  width: auto;
  float: left;
  position: relative;
  z-index: 999;
}

.nav li a {
  display: block;
  line-height: 54px;
  color: #555555;
  height: 54px;
  font-size: 16px;
}

.nav li > a {
  padding: 0 25px;
}

.nav li a:hover {
  color: #3cb98c;
}

/*.nav li.lxff a{color: #3cb98c;}
  .nav li.lxff a:hover{color: #3cb98c;}*/


.nav .sec {
  height: 0;
  background: #3cb98c;
  color: #fff;
  overflow: hidden;
  z-index: 9999;
  position: absolute;
  top: 54px;
  left: 0px;
  width: 100%;
}

.nav .sec a {
  background: #3cb98c;
  color: #fff;
  height: 38px;
  line-height: 38px;
  font-size: 14px;
}

.nav .sec a:hover {
  background: #fff;
  text-decoration: none;
}

/*首页banner*/
.topbanner {
  position: relative;
  height: 700px;
}

.banner {
  width: 1920px;
  margin: 0 auto;
  position: absolute;
  height: 700px;
  left: 50%;
  margin-left: -960px;
  overflow: hidden
}

.banner ul.bb {
  position: relative;
  padding: 0px;
  margin: 0px;
  z-index: 5;
}

.banner ul.bb li {
  position: absolute;
  display: none;
}

.banner .num {
  position: absolute;
  bottom: 45px;
  z-index: 100;
  width: 100%;
  text-align: center
}

.banner .num li {
  width: 12px;
  height: 12px;
  display: inline-block;
  *display: inline;
  *zoom: 1;
  margin: 0 10px;
  background: #fff;
  line-height: 12px;
  text-indent: -100px;
  overflow: hidden;
  border-radius: 10px;
}

.banner .num li.num_hover {
  background-color: #3cb98c;
}

.banner .num li.num_hover a {
  color: #fff;
}

.banner .num li a {
  float: left;
  display: inline;
  text-align: center;
  color: #666;
  text-decoration: none;
  cursor: pointer;
  width: 18px;
  height: 18px;
  line-height: 18px;
}

/*幻灯片样式2*/
#focus {
  width: 255px;
  height: 188px;
  overflow: hidden;
  position: relative;
}

#focus ul {
  height: 188px;
  position: absolute;
}

#focus ul li {
  float: left;
  width: 255px;
  height: 188px;
  overflow: hidden;
  position: relative;
  background: #000;
}

#focus ul li a img {
  height: 188px;
  width: 255px;
}

#focus ul li div {
  position: absolute;
  overflow: hidden;
}

#focus .btnBg {
  position: absolute;
  width: 255px;
  height: 20px;
  left: 0;
  bottom: 0;
  background: #000;
}

#focus .btn {
  position: absolute;
  width: 255px;
  height: 10px;
  padding: 5px 10px;
  right: 0;
  bottom: 0;
  text-align: right;
}

#focus .btn span {
  display: inline-block;
  _display: inline;
  _zoom: 1;
  width: 25px;
  height: 10px;
  _font-size: 0;
  margin-left: 5px;
  cursor: pointer;
  background: #fff;
}

#focus .btn span.on {
  background: #fff;
}


/*产品分类*/
.cate {
  border: 1px solid #e0e1dc;
  padding: 10px;
  background-color: #f7f7f7;
}

.cate li {
  line-height: 28px;
  border-bottom: 1px dashed #d7d7d7;
  line-height: 28px;
}

.cate li a:hover {
  background-color: #ececec;
  text-decoration: none;
}

/*详细介绍分页样式*/
.total {
  border-bottom: 1px dashed #e0e1dc;
  padding-bottom: 10px;
}

.paging_num {
  padding: 10px 0px;
  overflow: hidden;
  text-align: right;
}

.paging_num a {
  width: 25px;
  height: 20px;
  line-height: 20px;
  text-align: center;
  display: inline-block;
  border: 1px dashed #e0e1dc;
  color: #666;
  margin-left: 15px;
}

.paging_num a:hover {
  text-decoration: none;
  color: #005a98;
  border: 1px dashed #005a98;
}

.paging_num .paging_hover {
  text-decoration: none;
  color: #005a98;
  border: 1px dashed #005a98;
}

/*新闻列表*/
.news_list {
}

.news_list li {
  line-height: 27px;
  position: relative;
  padding-left: 10px;
}

.news_list li a {
  line-height: 27px;
  color: #666;
}

.news_list li a:hover {
  text-decoration: none;
  color: #3cb98c;
}

.news_list li span {
  color: #999;
  z-index: 0;
  line-height: 27px;
  position: absolute;
  right: 0px;
  top: 0px;
}

.news_list li h3 {
  font-size: 14px;
}

.news_list li div {
  line-height: 24px;
}

/*热门关键词*/
.words {
  overflow: hidden; /* margin-right:-1.3%; *//* padding-top:5px; *//* background: #fafafa; */
  padding: 0 2%;
}

.new1 {
  padding: 0 10px;
}

.words li {
  width: 46%;
  float: left;
  border: 1px dashed #d0d0d0;
  background: #fcfcfc;
  padding-left: 0px;
  margin-bottom: 10px;
  text-align: center;
}

.new1 li:hover {

}

.new1 li {
  line-height: 30px;
  position: relative;
  padding-left: 17px;
}

.new1 li a {
  line-height: 30px;
  color: #666;
}

.new1 li:hover a {
  text-decoration: none;
  color: #3cb98c;
}

.right_word {
  margin-left: 6%;
}

.words a {
  color: #646464;
  background: #f7f7f7;
  line-height: 28px;
  white-space: nowrap;
  text-overflow: ellipsis;
  overflow: hidden;
}

.words a:hover {
  color: #3cb98c;
}

/*案例列表*/
.case_list {
}

.case_list li {
  float: left;
  margin-left: 15px;
  margin-right: 15px;
  padding-bottom: 15px;
  _display: inline;
}

.case_list li a.img {
  padding: 1px;
  border: 1px solid #e0e1dc;
}

.case_list li a.img img {
  width: 192px;
  height: 165px;
}

.case_list li h3 {
  text-align: center;
  padding-top: 5px;
}

.case_list li h3 a {
  font-weight: normal;
}

.case_list li a.img {
  display: block;
}

.case_list li a.img:hover {
  border-color: #3cb98c;
}

/*Tag列表*/
.tag_list_product {
  margin-top: 10px;
}

.tag_list_product li {
  float: left;
  margin-left: 15px;
  margin-right: 15px;
  padding-bottom: 15px;
  _display: inline;
}

.tag_list_product li a.img {
  padding: 1px;
  border: 1px solid #e0e1dc;
}

.tag_list_product li a.img img {
  width: 192px;
  height: 165px;
}

.tag_list_product li h3 {
  text-align: center;
  padding-top: 5px;
}

.tag_list_product li h3 a {
  font-weight: normal;
}

.tag_list_product li a.img {
  display: block;
}

.tag_list_product li a.img:hover {
  border-color: #3cb98c;
}

.tag_list_news {
}

.tag_list_news li {
  line-height: 27px;
  position: relative;
  padding-left: 10px;
}

.tag_list_news li a {
  line-height: 27px;
}

.tag_list_news li span {
  color: #999;
  z-index: 0;
  line-height: 27px;
}

.tag_list_news li h3 {
  font-size: 14px;
}

.tag_list_news li div {
  line-height: 24px;
}

.tag_total {
  height: 36px;
  line-height: 36px;
  text-align: left;
  padding-left: 20px;
  background-color: #edf1f5;
  border: 1px solid #b6c7db;
}

/*产品里列表*/

/*滚动*/
#demo {
  overflow: hidden;
  width: 100%;
  margin: 0 auto;
}

#indemo {
  float: left;
  width: 800%
}

#demo1 {
  float: left;
}

#demo2 {
  float: left;
}

#m_demo {
  overflow: hidden;
  width: 100%;
  margin: 0 auto;
}

#m_indemo {
  float: left;
  width: 800%
}

#m_demo1 {
  float: left;
}

#m_demo2 {
  float: left;
}


.product_list {
}

.product_list li {
  float: left;
  margin-left: 15px;
  margin-right: 15px;
  padding-bottom: 15px;
  _display: inline;
}

.product_list li a.img {
  padding: 1px;
  border: 1px solid #e0e1dc;
}

.product_list li a.img img {
  width: 242px;
  height: 208px;
}

.product_list li h3 {
  text-align: center;
  padding-top: 5px;
}

.product_list li h3 a {
  font-weight: normal;
}

.product_list li a.img {
  display: block;
}

.product_list li a.img:hover {
  border-color: #3cb98c;
}

.roll_product {
  float: left;
}

.product_list_a1 {
}

.product_list_a1 li {
  float: left;
  margin-right: 20px;
  padding-bottom: 15px;
  _display: inline;
}

.product_list_a1 li:nth-child(3n) {
  margin-right: 0;
}

.product_list_a1 li a.img {
  border: 1px solid #eaeaea;
}

.product_list_a1 li a.img img {
  width: 286px;
  height: 223px;
}

.product_list_a1 li h3 {
  text-align: center;
}

.product_list_a1 li h3 a {
  font-weight: normal;
  color: #555555;
  font-size: 15px;
  line-height: 60px;
}

.product_list_a1 li a.img {
  display: block;
}

.product_list_a1 li a.img:hover {
  border-color: #3cb98c;
}

.roll_product {
  float: left;
}


.product_list1 li {
  float: left;
  margin-left: 26px;
  margin-right: 26px;
  _display: inline;
  border: 1px solid #eaeaea;
  margin-bottom: 42px;
}

.product_list1 li:hover {
  border-color: #3cb98c
}

.product_list1 li a.img {
}

.product_list1 li a.img img {
  width: 229px;
  height: 198px;
}

.product_list1 li h3 {
  text-align: center;
  background: #96a1a6;
  line-height: 32px;
}

.product_list1 li:hover h3 {
  background: #3cb98c
}

.product_list1 li h3 a {
  color: #fff;
  font: 400 14px/32px "微软雅黑";
  display: block;
}

.product_list1 li a.img {
  display: block;
}


.product_list2 li {
  float: left;
  margin-left: 8px;
  margin-right: 8px;
  _display: inline;
}

.product_list2 li a.img img {
  width: 253px;
  height: 218px;
}

.product_list2 li h3 {
  text-align: center;
  line-height: 35px;
}

.product_list2 li h3 a {
  font-weight: normal;
  color: #333;
  font-size: 14px;
}

.product_list2 li a.img {
  display: block;
}

.product_list2 li h3 a:hover {
  color: #3cb98c;
}


.sort_a {
  overflow: hidden;
}

.sort_a .layer1 {
  padding: 15px 0px;
  border-bottom: 1px dashed #a7b8d4;
  position: relative;
  height: 133px;
  z-index: 1;
}

.sort_a .layer1 .img {
  float: left;
  padding: 5px;
  border: 1px solid #dddddd;
}

.sort_a .layer1 .img img {
  width: 150px;
  height: 120px;
}

.sort_a .layer1 .img_right {
  width: 560px;
  float: right;
}

.sort_a .layer1 .img_right h3 {
  font: bold 14px/36px "微软雅黑";
}

.sort_a .layer1 .img_right span {
  line-height: 25px;
  display: block;
}

.sort_a .layer1 .pro_more {
  position: absolute;
  right: 0px;
  bottom: 15px;
  width: 110px;
  padding-left: 10px;
  height: 28px;
  line-height: 28px;
  background: #666666;
  color: #fff;
  font: bold 24px/24px "微软雅黑";
}

.sort_a .layer1 .pro_more span {
  float: left;
}

.sort_a .layer1 .pro_more a {
  font: normal 12px/28px "宋体";
  color: #fff;
  float: right;
  padding-right: 15px;
  display: inline-block;
}

.sort_a .layer1 .pro_more a:hover {
  text-decoration: none;
  color: #faf104;
}

.sort_a .abb_product {
  padding-top: 15px;
  border: 1px dashed #a7b8d4;
  border-top: none;
}


.productcates {
  padding-top: 10px;
}

.catemore {
  color: #0080d9;
  margin-top: 6px;
  overflow: hidden;
  position: relative;
}

.catemore h2 {
  width: 360px;
  float: left;
  font: bold 15px/36px "微软雅黑";
}

.catemore a {
  float: right;
  font: normal 14px/36px "微软雅黑";
  color: #444444;
  padding-right: 28px;
}

.catemore a:hover {
  text-decoration: none;
  color: #0080d9;
}

/*下载列表*/
.down_list {
}

.down_list li a {
}

/*招聘列表*/
.job_list {
}

.job_list li a {
}

.job_list li span {
  position: absolute;
  color: #999;
  right: 0;
  z-index: 0;
}

/*招聘列表*/
.download_list {
}

.download_list li a {
}

.download_list li span {
  position: absolute;
  color: #999;
  right: 0;
  z-index: 0;
}


/*详细页面公共样式*/
h3.title_bar {
  margin-left: 40px;
  width: 420px;
  float: left;
}

.share {
  padding-left: 5px;
  padding-bottom: 8px;
  float: left;
  width: 240px;
  height: 26px;
}

.info_title {
  border-bottom: 1px solid #e1e4e6;
}

.case_title {
  border-bottom: 1px solid #e1e4e6;
}

/*产品详细*/
.product_detail {
  padding: 5px;
}

.product_detail h1.title {
  text-align: center;
  line-height: 30px;
  font-size: 14px;
  font-family: "Microsoft YaHei";
  border-bottom: 1px solid #e0e1dc;
  margin-bottom: 15px;
  padding-bottom: 5px;
}

.product_detail .img {
  width: 232px;
  height: 200px;
  float: left;
  padding: 2px;
  border: 1px solid #e0e1dc;
}

.product_detail .img img {
}

.product_detail .small {
  width: 232px;
  height: 200px;
}

.jqzoom {
  text-decoration: none;
  float: left;
}

.product_detail .list {
  width: 300px;
  float: left;
  margin-left: 30px;
  display: inline;
  padding-top: 8px;
}

.list_p {
}

.list_p li {
  height: 26px;
  font-size: 12px;
  border-bottom: 1px dashed #e0e1dc;
  padding-bottom: 5px;
  padding-top: 5px;
  font-family: "Microsoft YaHei"
}

.list_p li h2 {
  font-size: 12px;
  font-weight: normal;
  font-family: "Microsoft YaHei"
}

.product_detail .inquiry {
  line-height: 32px;
  border: none;
  margin-top: 6px;
}


.list_p li h2 a {
  font-size: 12px;
  font-family: "Microsoft YaHei"
}

.p_detail span.title {
  line-height: 28px;
  height: 28px;
  text-align: left;
  margin-top: 10px;

  display: block;
  padding-left: 10px;
  font-size: 12px;
  border-bottom: 1px solid #3cb98c;
}

.p_detail p.dd {
  padding-top: 5px;
  padding-bottom: 5px;
}

h3.tag {
  line-height: 32px;
  border-top: 1px dashed #e0e1dc;
  margin-top: 10px;
  color: #999;
  font-weight: normal;
}

h3.tag a {
  color: #005a98;
}

h3.tag a:hover {
  color: #3cb98c;
}

.page {
  line-height: 26px;
  border-top: 1px dashed #e0e1dc;
  margin-top: 6px;
  padding-top: 5px;
  font-size: 12px;
}

.page a {
  color: #005a98;
}

.page a:hover {
  color: #3cb98c;
}

.page span {
  color: #005a98;
}

/*新闻详细*/
.news_detail {
}

.news_detail h1.title {
  text-align: center;
  font-family: "Microsoft YaHei";
  font-size: 18px;
  border-bottom: 1px solid #e0e1dc;
  margin-bottom: 5px;
  padding-bottom: 10px;
}

.news_detail h3.title_bar {
  line-height: 26px;
  text-align: center;
  font-weight: normal;
  color: #808080;
  float: left;
  height: 26px;
  overflow: hidden;
}

.news_detail h3.title_bar span {
  padding-right: 10px;
}

/*招聘详细*/
.job_detail {
}

.job_detail h1.title {
  text-align: center;
  font-family: "Microsoft YaHei";
  font-size: 18px;
  border-bottom: 1px solid #e0e1dc;
  margin-bottom: 5px;
  padding-bottom: 10px;
}

.job_detail h3.title_bar {
  line-height: 26px;
  text-align: center;
  font-weight: normal;
  color: #808080;
}

.job_detail h3.title_bar span {
  padding-right: 10px;
}

.job_detail .content h4 {
  background-color: #f1f1f1;
  height: 26px;
  line-height: 26px;
  text-align: left;
  padding-left: 15px;
}

.job_detail .content div.text {
  padding-top: 10px;
  padding-left: 22px;
  padding-right: 8px;
}

/*下载详细*/
.down_info {
  padding: 10px;
  margin-top: 15px;
}

.down_info table {
  width: 100%;
}

.down_info table thead {
  line-height: 26px;
  background-color: #f2f2f2;
}

.down_info table th {
  border: 1px solid #b6d5f1;
}

.down_info table td {
  padding: 3px;
  padding-left: 10px;
  padding-right: 5px;
  border: 1px solid #b6d5f1;
  text-align: center;
  line-height: 28px;
  height: 28px;
}



/*内页左侧分类通用样式*/


.sort {
  border-bottom: #D9D9D9 1px solid;
}

.sort {
  background: #fafafa;
  margin-top: 1px;
  border: 1px solid #ececec;
  padding-bottom: 20px;
}

.sort li {
  position: relative;
  z-index: 9999;
}

.sort li .about_b {
  position: absolute;
  left: 210px;
  top: 0px;
  width: 210px;
  padding: 10px 20px;
  background: #f5f6f6;
  border-bottom: 2px solid #3cb98c;
  z-index: 9999;
}

.sort li .layer2 {
  position: absolute;
  left: 210px;
  top: 0px;
  width: 210px;
  padding: 10px 20px;
  background: #f5f6f6;
  border-bottom: 2px solid #3cb98c;
  z-index: 9999;
}

.sort li .layer2 li {
  overflow: hidden;
}

.sort li .layer2 li a:hover {
  text-decoration: none;
  color: #3cb98c;
}

.sort li .layer2 li .layer3 li {
  border-bottom: 1px dashed #d5d5d5;
  margin: 6px 0px;
  height: 24px;
  line-height: 24px;
}

.sort li .layer2 li .layer3 li a {
  font: normal 12px/24px "微软雅黑";
  background: none;
}

.sort li a {
  color: #555555;
  display: block;
  line-height: 45px;
  font-family: "微软雅黑";
  border-bottom: 1px dashed #dfdfdf;
  padding-left: 28px;
  font-size: 15px;
}


.sort .layer2 li {
  width: 200px;
  height: 35px;
  margin-bottom: 0;
  background: none;
}

/*内页留言*/
.message {
  padding-left: 30px;
  padding-top: 10px;
  z-index: 100;
  position: relative;
}

.message input {
  vertical-align: middle;
}

.message #name {
  display: block;
  height: 26px;
  line-height: 26px;
  padding: 0;
  padding-left: 6px;
  border: 1px solid #dedede;
  width: 200px;
}

.message #contact {
  display: block;
  height: 26px;
  line-height: 26px;
  padding: 0;
  padding-left: 6px;
  border: 1px solid #dedede;
  width: 200px;
}

.message #email {
  display: block;
  height: 26px;
  line-height: 26px;
  padding: 0;
  padding-left: 6px;
  border: 1px solid #dedede;
  width: 200px;
}

.message #address {
  display: block;
  height: 26px;
  line-height: 26px;
  padding: 0;
  padding-left: 6px;
  border: 1px solid #dedede;
  width: 200px;
}

.message #content {
  display: block;
  width: 460px;
  height: 120px;
  padding: 6px;
  font-size: 12px;
  border: 1px solid #dedede;
  margin-top: 6px;
}

.message .msgbtn {
  background: #3cb98c;
  cursor: pointer;
  width: 90px;
  height: 30px;
  line-height: 30px;
  text-align: center;
  border: none;
  color: #fff;
  font-size: 14px;
  border-radius: 3px;
  margin-top: 15px;
  font-family: "Microsoft YaHei";
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
}

#code {
  padding-top: 10px;
  line-height: 26px;
}

#checkcode {
  height: 32px;
  line-height: 32px;
  width: 120px;
  border: 1px solid #dedede;
}

#message_main tr {
  position: relative;
}

#message_main tr th {
  font-weight: normal;
  text-align: right;
  height: 42px;
  line-height: 42px;
  color: #666;
}

.m_label {
  position: absolute;
  width: 160px;
  text-align: left;
  line-height: 26px;
  padding-left: 8px;
  color: #ccc;
  z-index: 1;
  cursor: text;
}

.c_label {
  line-height: 18px;
  padding-top: 12px;
}

/*首页留言表单*/
.index_message {
  position: relative;
}

.name_input {
  border: 1px solid #cccccc;
  margin-top: 5px;
  background: #fff;
  height: 22px;
  width: 189px;
}

.input_right {
  position: relative;
  float: right;
}

.input_right input {
  height: 22px;
  line-height: 22px;
}

.input_right .m_label {
  position: absolute;
  width: 100px;
  text-align: left;
  line-height: 22px;
  padding-left: 6px;
  color: #ccc;
  z-index: 1;
  cursor: text;
}


#m_div {
  width: 222px;
  position: fixed;
  right: 2px;
  bottom: 0px;
  padding-bottom: 1px;
  z-index: 99999;
  background: none;
}

.d_label {
  line-height: 18px;
  padding-top: 8px;
  width: 160px;
}

.w_message {
  border: 1px solid #4a9cf9;
  padding: 7px;
  padding-top: 3px;
}

/*height:238px; */

.w_message #name {
  width: 142px;
  height: 22px;
  line-height: 22px;
  border: none !important;
}

.w_message #contact {
  width: 142px;
  height: 20px;
  line-height: 20px;
  border: none !important;
}

.w_message #email {
  width: 142px;
  height: 20px;
  line-height: 20px;
  border: none !important;
}

.w_message #address {
  width: 142px;
  height: 20px;
  line-height: 20px;
  border: none !important;
}

.w_message #content {
  width: 176px;
  height: 65px;
  resize: none;
  overflow-y: auto;
  overflow-x: hidden;
}

.w_message #checkcode {
  width: 82px;
  height: 22px;
  line-height: 22px;
  border: 1px solid #ccc;
  background-color: #fff;
}


#message_main {
  display: table-cell;
}

.w_message #message_main tr {
  display: block;
  width: 100%;
  overflow: hidden;
  line-height: 28px;
}

.w_message #message_main tr th {
  height: 28px;
  line-height: 28px;
  width: 37px;
  text-align: center;
  vertical-align: middle;
  overflow: hidden;
}

.w_message #code {
  padding-top: 0px;
  margin-top: 5px;
}

.w_title {
  background: none;
  color: #fff;;
  position: relative;
  cursor: pointer;
  height: 33px;
  width: 222px;
  overflow: hidden;
}

.w_message #message_main .m_input {
  border: 1px solid #ccc;
  background-color: #fff;
}

.w_message .msgbtn_hover {
  background: #3c96fc;
  color: #fff;
  border: 1px solid #3c96fc;
}


.w_message .m_under {
  position: absolute;
  width: 227px;
  height: 37px;
  line-height: 41px;
  left: 0;
  bottom: 1px;
}

.w_message .support {
  color: #000;
  width: 100px;
  position: absolute;
  bottom: 1px;
  right: 8px;
  font-size: 12px;
}

#m_top {
  height: 1px;
  font-size: 0px;
  line-height: 1px;
  margin: 0 2px;
  background: #4a9cf9;
}

#m_mid {
  height: 1px;
  font-size: 0px;
  line-height: 1px;
  margin: 0 1px;
  background: #4a9cf9;
}

#m_bot {
  background: #4a9cf9;
  height: 31px;
  line-height: 31px;
  padding-left: 9px;
  font-family: "微软雅黑";
  font-size: 13px;
}


/*分页样式1*/
.pageController {
  padding-right: 10px;
  padding-top: 5px;
  padding-bottom: 5px;
  color: #505050;
  margin: 0 auto;
  border-top: 1px solid #E2E3E4;
  margin-top: 16px;
  line-height: 24px;
}

.pageController a {
  background-color: #FFF;
  vertical-align: middle;
  border: #efefef 1px solid;
  color: #505050;
  padding: 5px 8px;
  margin-right: 3px;
  margin-left: 3px;
}

.pageController a:hover {
  background-color: #efefef;
  color: #438ece;
  text-decoration: none;
  border: #efefef 1px solid;
}

.pageController .currPage {
  background-color: #efefef;
  color: #ff0000;
  border: #efefef 1px solid;
}

.pageController .t1 {
  float: left;
  margin-right: 5px;
  height: 24px;
  line-height: 22px;
  white-space: nowrap;
}

.pageController .t2 {
  float: right;
  vertical-align: middle;
  line-height: 24px;
}

.pageController .t2 #current {
  padding: 0 5px;
  line-height: 24px;
}

.pageController .t1 span {
  padding-left: 4px;
  padding-right: 4px;
}

.pageController select {
  height: 24px;
  vertical-align: middle;
  text-align: center;
  line-height: 24px;
}

.pageController select option {
  vertical-align: middle;
}

/*相关产品和新闻*/
.relate_list {
  margin-top: 10px;
}

.relate h4 {
  line-height: 30px;
  border-bottom: 1px solid #3cb98c;
  padding-left: 5px;
}

#relate_p .img img {
  width: 152px;
  height: 130px;
}

#relate_p li {
  margin-left: 10px;
  margin-right: 10px;
  _display: inline;
}

#relate_n li {
  width: 48%;
  float: left;
}

.relate ul {
  float: none;
}

/*博客列表*/
.blog_list {
}

.blog_list li {
  border-bottom: 1px solid #ccc;
  padding-bottom: 20px;
}

.blog_list li h2 {
  line-height: 42px;
  height: 42px;
  padding-left: 10px;
  padding-left: 20px;
  border-bottom: 1px dashed #ccc;
}

.blog_list li h2 a {
  font-size: 14px;
  font-family: "Microsoft YaHei";
  font-weight: bold;
  color: #4C4C4C;
  line-height: 42px;
  color: #204e7d;
}

.blog_list li .summary {
  color: #878787;
  line-height: 28px;
  height: 28px;
  text-indent: 20px;
  padding-top: 5px;
  padding-bottom: 5px;
}

.blog_list li .under {
  padding-left: 20px;
  padding-top: 5px;
  height: 24px;
  line-height: 24px;
  padding-bottom: 5px;
  color: #2970a6;
}

.blog_list li .under a {
  color: #2970a6;
}

/*网站地图*/
h3.map_title {
  line-height: 30px;
  line-height: 30px;
  background-color: #f5f8fa;
  border: 1px solid #d6dbe1;
  text-indent: 20px;
  color: #3cb98c;
  border-bottom: 2px solid #3cb98c;
}

.map_list {
  line-height: 30px;
  padding-left: 20px;
  margin-top: 8px;
  margin-bottom: 8px;
}

.map_list a {
  padding: 4px;
  white-space: nowrap;
}

.map_list a:hover {
  text-decoration: none;
  background-color: #3cb98c;
  color: #fff;
  padding: 4px;
}

/*热推产品*/
.content-getkey {
  padding: 15px 10px;
}

.getkey_list {
}

.getkey_list li {
  float: left;
  margin-left: 20px;
  margin-right: 20px;
  padding-bottom: 15px;
  _display: inline;
}

.getkey_list li a.img {
  padding: 1px;
  border: 1px solid #e0e1dc;
}

.getkey_list li a.img img {
  width: 150px;
  height: 120px;
}

.getkey_list li h3 {
  text-align: center;
  padding-top: 5px;
}

.getkey_list li h3 a {
  font-weight: normal;
}

.getkey_list li a.img {
  display: block;
}

.getkey_list li a.img:hover {
  border-color: #3cb98c;
}

.content-getkey .content {
  line-height: 24px;
  overflow: hidden;
  padding: 15px 10px 10px;
}

.getkey_detail .content {
  line-height: 24px;
  overflow: hidden;
  padding: 15px 10px 10px;
}


.w1200 {
  width: 1200px;
  margin: 0 auto;
}

.head1 {
  height: 100px;
}

/*头部样式*/
.header {
  width: 1100px;
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.top {
  height: 137px;
}

.logo {
  float: left;
  line-height: 100px;
}

.topLink {
  float: right;
  text-align: right;
  position: relative;
  z-index: 9999;
}

.translate {
  width: 100px;
  position: absolute;
  left: 0;
  top: 10px;
  z-index: 9999;
}

.tran-in {
  left: 120px;
}

.translate li {
  border: 1px dashed #cccccc;
  line-height: 26px;
  text-align: left;
  background: #fff;
}

.translate li a:hover {
  text-decoration: none;
  color: #275cea;
  cursor: pointer;
}

.translate-en {
  display: none;
  padding: 6px;
  padding-top: 0px;
}

.translate li .translate-en a {
  padding-left: 0px;
  text-align: center;
  background: #fff;
  border-bottom: 1px solid #cccccc;
}

.translate li .translate-en a:hover {
  font-weight: bold;
}

.topLink .f_count {
  color: #ff0000;
  font-size: 13px;
  font-weight: bold;
}


#menu {
  width: auto;
  position: relative;
  margin-top: 25px;
}


a.ssk {
  display: block;
  margin-top: 36px;
  width: 34px;
  height: 34px;
  background: url(./assets/ssk1.png) no-repeat center;
}

a.ssk:hover {
  /*background:url(./assets/ssk2.png) no-repeat center;*/
}

/*热门搜索*/
.tiop1 {
  position: relative;
  margin-left: 28px;
}

.searchbg {
  font: 400 12px/50px "微软雅黑";
  color: #999999;
  position: absolute;
  right: 0;
  top: 100px;
  background: rgba(255, 255, 255, .9);
  padding: 25px 23px 10px;
  display: none;
}

.searchbg a {
  color: #999999;
}

.searchbg a:hover {
  color: #3cb98c;
}

.search {
  width: auto;
  margin: 0 auto;
}

#formsearch {
  width: 334px;
  background: url(./assets/ss.png) no-repeat center;
  margin-top: 10px;
}

.hotSearch {
  font-weight: normal;
  text-align: left;
}

/*搜索和热门搜索*/
.hotSearch a {
  margin-right: 6px;
}

#formsearch input {
  height: 44px;
  background: none;
  border: none;
  line-height: 44px;
  float: left;
}

#formsearch input#keyword {
  height: 44px;
  line-height: 44px;
  padding-left: 6px;
  color: #999999;
  width: 275px;
  text-indent: 20px;
}

#formsearch input#s_btn {
  width: 52px;
  height: 44px;
  line-height: 44px;
  cursor: pointer;
  color: #ffffff;
}

/*主体样式*/
#container {
  width: 1200px;
  margin: 0 auto 60px;
  margin-top: 30px;
}


/*cont1*/
.cont1 {
  margin-top: 42px;
}

.title_a1 {
  text-align: center;
}

.title_a1 h2 {
  color: #000000;
  font: 500 30px/38px "微软雅黑";
}

.title_a1 h3 {
  color: #999999;
  font: 500 15px/24px "微软雅黑";
  margin-top: 13px;
}

.xg_a3_b1 li {
  margin: 0 10px;
}

.xg_a3_b1 li a.img {
  display: block;
  position: relative;
}

.xg_a3_b1 li a.img > img {
  width: 100%;
}

.xg_a3_b1 li a.img h3 {
  position: absolute;
  left: 0;
  top: 0;
  background: rgba(60, 185, 140, .9);
  text-align: center;
  width: 100%;
  height: 100%;
  color: #fff;
  font: 500 22px/34px "微软雅黑";
  transition: all .5s ease;
  opacity: 0;
  transform: scale(0);
}

.xg_a3_b1 li:hover a.img h3 {
  opacity: 1;
  transform: scale(1);
}

.ghahg {
  position: absolute;
  width: 100%;
  top: 50%;
  transform: translateY(-50%);
}

.xg_a3_b1 li a.img h3 span {
  display: block;
  font: 500 16px/24px "Arial";
}

.xg_a3_b1 li a.img h3 i {
  display: block;
  text-align: center;
  margin-top: 20px;
}

.xg_a3_b1 li a.img h3 i img {
  display: inline-block;
}

.xg_a3_b1 li h2 a {
  display: block;
  color: #333333;
  font: 500 22px/45px "微软雅黑";
  margin-top: 8px;
  text-align: center;
}

.a1_v1 {
  margin-top: 44px;
  position: relative;
}

.a1_v1 .slick-dots {
  text-align: center;
  font-size: 0;
  margin-top: 40px;
}

.a1_v1 .slick-dots li {
  display: inline-block;
  width: 9px;
  height: 9px;
  border-radius: 50%;
  background: #cccccc;
}

.a1_v1 .slick-dots li.slick-active {
  background: #000000;
}

.a1_v1 .slick-dots li button {
  display: none;
}

/*cont2*/
.cont2 {
  background: url(./assets/bj1.jpg) no-repeat center top;
  padding-top: 54px;
  box-sizing: border-box;
  margin-top: 52px;
}

.title_a2 {
  text-align: center;
}

.title_a2 h2 {
  color: #fff;
  font: 500 30px/38px "微软雅黑";
}

.a2_v1 {
  margin-top: 45px;
}

.a2_b1 {
  width: 690px;
  color: #fff;
}

.a2_b2 {
  width: 416px;
  height: 240px;

  padding: 0 0 10px 10px;
}

.a2_b2 img {
  width: 416px;
  height: 240px;
}

.a2_b1 h2 {
  color: #fff;
  font: 500 20px/28px "微软雅黑";
  margin-top: 10px;
}

.a2_b1 .abt_wen {
  color: #fff;
  font: 500 14px/28px "微软雅黑";
  margin-top: 18px;
}

.abt_maa {
  margin-top: 44px;
}

.abt_maa a {
  display: block;
  float: left;
  width: 138px;
  height: 38px;
  border: 1px solid rgba(255, 255, 255, .5);
  color: #fff;
  font: 500 14px/38px "微软雅黑";
  text-indent: 45px;
}

.abt_maa a + a {
  margin-left: 10px;
}

.abt_maa a:hover {
  background-color: #3cb98c;
  border-color: #3cb98c;
}

.a2_v2 {
  padding: 36px 0;
  box-shadow: 0 0 13px rgba(0, 0, 0, .2);
  background: #fff;
  margin-top: 66px;
}

.a2_v2 li {
  float: left;
  width: 25%;
  text-align: center;
  height: 85px;
}

.a2_v2 li + li {
  border-left: 1px solid #e5e5e5;
  width: calc(25% - 1px);
}

.a2_v2 li + li h2 {
  text-indent: 28px;
}

.a2_v2 li h2 span {
  color: #666666;
  font: 600 48px/50px "Impact";
}

.a2_v2 li h2 b {
  color: #999999;
  font: 500 16px/24px "微软雅黑";
  vertical-align: top;
  margin-left: 14px;
}

.a2_v2 li h3 {
  color: #999999;
  font: 500 15px/38px "微软雅黑";
}

/*cont3*/
.cont3 {
  margin-top: 55px;

  padding-bottom: 72px;
}

.xw_sot1 {
  text-align: center;
  font-size: 0;
  margin-top: 30px;
}

.xw_sot1 li {
  display: inline-block;
  border: 1px solid #f2f2f2;
}

.xw_sot1 li + li {
  margin-left: -1px;
}

.xw_sot1 li a {
  display: block;
  width: 142px;
  color: #666666;
  font: 500 16px/42px "微软雅黑";
}

.xw_sot1 li:nth-child(1) {
  border-top-left-radius: 14px;
}

.xw_sot1 li:nth-child(3) {
  border-bottom-right-radius: 14px;
}

.xw_sot1 li:hover, .xw_sot1 li.cur {
  background: #3cb98c;
  border-color: #3cb98c;
}

.xw_sot1 li:hover a, .xw_sot1 li.cur a {
  color: #fff;
}

.tab_v1 {
  margin-top: 55px;
}

.xw_list1 li {
  width: 364px;
  float: left;
}

.xw_list1 li + li {
  margin-left: 54px;
}

.xw_list1 li .sj_hha {
  width: 70px;
  height: 70px;
  text-align: center;
  border: 2px solid #d9d9d9;
  box-sizing: border-box;
  padding-top: 13px;
  margin-top: 6px;
}

.xw_list1 li .sj_hha b {
  color: #333333;
  font: 600 26px/26px "Arial";
  display: block;
}

.xw_list1 li .sj_hha span {
  color: #666;
  font: 500 13px/20px "Arial";
  display: block;
}

.xw_list1 li .xw_ahhgag2 {
  width: 275px;
}

.xw_list1 li .xw_ahhgag2 h2 a {
  display: block;
  color: #333333;
  font: 500 16px/30px "微软雅黑";
}

.xw_list1 li:hover .xw_ahhgag2 h2 a {
  font-weight: 600;
}

.xw_list1 li .xw_ahhgag2 h3 {
  color: #999999;
  font: 500 12px/22px "微软雅黑";
  margin-top: 1px;
}

.xw_list1 li a.img {
  display: block;
  margin-top: 42px;
}

.xw_list1 li a.img img {
  width: 364px;
  height: 160px;
}

.xw_list1 li:hover .sj_hha {
  background: #3cb98c;
  border-color: #3cb98c;
}

.xw_list1 li:hover .sj_hha b, .xw_list1 li:hover .sj_hha span {
  color: #fff;
}

.xw_list1 li:hover .xw_ahhgag2 h2 a {
  color: #3cb98c;
}

/*产品中心*/
.menu_cate {
  width: 224px;
  float: left;
  border: 4px solid #0262b8;
}

.cate_title {
  height: 67px;
  background: #0262b8;
  color: #fff;
  font-size: 26px;
  text-align: center;
  padding-top: 3px;
}

.cate_title span {
  display: block;
  color: #8dacd6;
  font-size: 12px;
  font-weight: 400;
}

.sort1 {
  background: #fff;
  padding: 14px 11px 28px;
}

.sort1 li {
  margin-bottom: 11px;
}

.sort1 li a:hover {
  color: #fa7821;
}

.trust {
  background: #0262b8;
  text-align: center;
  padding-top: 32px;
  color: #fff;
  padding-bottom: 23px;
}

.trust h3 {
  font-size: 22px;
  line-height: 26px;
  margin-bottom: 25px;
}

.trust h3 span {
  display: block;
  font: 400 12px "微软雅黑";
  text-transform: uppercase;
}

.trust img {
  margin-bottom: 10px;
}


/*热门母线槽推荐*/
.recommend_product {
  width: 850px;
  float: right;
}


.recommend_product .title a {
  color: #848584;
  font: 400 12px/44px "微软雅黑";
  right: 20px;
  position: absolute;
  top: 0;
}

.recommend_product .title a:hover {
  color: #0262b8;
}

.recommend_product .content {
  padding-top: 25px;
}

.roll_product li {
  padding-bottom: 0px;
}


/*6大理由*/
.c1 {
  background: #f4f4f4;
  width: 1430px;
  position: relative;
  left: 50%;
  margin-left: -715px;
  padding-top: 55px;
  padding-bottom: 30px;
}

.reason {
  width: 1100px;
  margin: 0 auto;
}

.reason h2 {
  color: #0262b8;
  font: 600 30px "微软雅黑";
  text-align: center;
  position: relative;
}

.reason h2 span {
  display: block;
  color: #999;
  font: 400 12px "微软雅黑";
  text-transform: uppercase;
  margin-top: 4px;
}

.reason h2 i {
  color: #ff7300;
  font: italic 600 126px/56px "宋体";
  position: absolute;
  left: 574px;
  top: -13px;
}

.ysl {
  width: 560px;
  float: left;
  margin-top: 70px;
}

.ysr {
  width: 505px;
  float: right;
  margin-top: 65px;
}

.c1 h3 {
  color: #0262b8;
  font: 600 26px/42px "微软雅黑";
  margin-bottom: 3px;
}

.c1 h3 span {
  color: #fff;
  font: 400 30px/42px "微软雅黑";
  width: 42px;
  text-align: center;
  display: inline-block;
  margin-right: 15px;
  background: #ff7300;
  border-radius: 50%
}

.c1 .p1 {
  font: 400 14px/25px "微软雅黑";
  padding-bottom: 18px;
  margin-left: 55px;
  margin-bottom: 15px;
}

.c1 .p11 {
  border-bottom: 1px solid #d1d1d1
}

.c1 .p2 {
  margin-left: 44px;
  margin-bottom: 42px;
}

.c1 .p3 {
  margin-bottom: 82px;
  margin-left: 15px;
}

.c1 .p4 {
  margin-top: 45px;
}

/*关于中誉电气*/
.about {
  width: 1100px;
  margin: 0 auto;
  margin-top: 55px;
}

.about_title span {
  display: block;
  color: #999;
  text-transform: uppercase;
  font-size: 12px;
}

.about .content {
  width: 655px;
  float: right;
  color: #333;
  font: 400 14px/25px "微软雅黑";
}

.about .aimg {
  width: 408px;
  float: left;
}

.about .content a {
  display: block;
  width: 140px;
  height: 43px;
  background: #ff7300;
  font: 400 14px/43px "微软雅黑";
  color: #fff;
  text-align: center;
  margin-top: 22px;
}

.about .content a:hover {
  color: #efefef;
}


/*工程案例展示*/
.c2 {
  background: #f4f4f4;
  width: 1430px;
  position: relative;
  left: 50%;
  margin-left: -715px;
  padding-top: 25px;
  margin-top: 85px;
  padding-bottom: 28px;
}

.case {
  width: 1100px;
  margin: 0 auto;
}

.ctitle {
  color: #0262b8;
  font: 400 26px/45px "微软雅黑";
  position: relative;
  border-bottom: 1px solid #d8d8d8
}

.ctitle a {
  position: absolute;
  right: 18px;
  top: 0;
  font-size: 12px;
}

.case .content {
  padding-top: 28px;
}


/*首页新闻*/
.news {
  width: 1100px;
  margin: 0 auto;
}

.news_company {
  width: 672px;
  float: left;
  margin-top: 50px;
}

.news1_title a {
  font: 400 12px/55px "微软雅黑";
  position: absolute;
  right: 5px;
  top: 5px;
}

.news_company .content {
  padding-top: 20px;
}

.nlist {
  padding: 6px 35px 13px;
  background: #eeeeee
}

.nlist li a {
  color: #333;
  font: 400 22px/48px "微软雅黑";
  text-align: center;
  display: block
}

.nlist li span {
  display: block;
  font: 400 14px/26px "微软雅黑";
  text-indent: 2em;
}

.nlist li span a {
  color: #ff7300;
  display: inline;
  font: 400 14px/26px "微软雅黑";
}

.nlist li a:hover {
  color: #0071cc;
}

.news_list1 {
  margin-bottom: 15px;
  margin-top: 28px;
}

.news_list1 dd {
  width: 84px;
  border: 1px solid #cfcfcf;
  text-align: center;
  font: 600 36px "arial";
  color: #9696a3;
  float: left;
  height: 74px;
  padding-top: 10px;
}

.news_list1 dd span {
  display: block;
  font: 400 14px "arial";
}

.news_list1 dt {
  width: 535px;
  float: left;
  margin-left: 32px;
}

.news_list1 dt a {
  color: #333;
  font: 400 16px/36px "微软雅黑";
}

.news_list1 dt span {
  display: block;
  font: 400 12px/24px "微软雅黑";
  text-indent: 2em;
}

.news_list1 dt span a {
  color: #ff7300;
  display: inline;
  font: 400 12px/24px "微软雅黑";
}

.news_list1:hover dd {
  background: #0071cc;
  border-color: #0071cc;
  color: #fff;
}

.news_list1:hover dt a {
  color: #0071cc;
}


.news2_company {
  width: 375px;
  float: right;
  margin-top: 50px;
}

.news2_company .content {
  padding-top: 20px;
}

.nlist1 li img {
  width: 375px;
  height: 204px;
}

.nlist1 h3 {
  margin-top: 18px;
}

.nlist1 h3 a {
  color: #333;
  font: 400 14px/30px "微软雅黑";
}

.nlist1 h3 span {
  display: block;
  font: 400 12px/25px "微软雅黑";
  text-indent: 2em;
}

.nlist1 h3 span a {
  color: #ff7300;
  display: inline;
  font: 400 12px/25px "微软雅黑";
}

.nlist1 li h3 a:hover {
  color: #0071cc;
}

.news_list2 {
  margin-top: 20px;
}

.news_list2 li a {
  color: #333;
  font: 400 14px/33px "微软雅黑";
  border-bottom: 1px dashed #999;
  display: block;
}

.news_list2 li a:hover {
  color: #0071cc;
}


.navigation {
  float: right;
  width: 100px;
}


.index-table td {
  border: solid #add9c0;
  border-width: 0px 1px 1px 0px;
  padding: 10px 5px;
}

.index-table {
  border: solid #add9c0;
  border-width: 1px 0px 0px 1px;
  margin-top: 10px;
}

/*----- Common css ------*/
.fl {
  float: left;
}

.fr {
  float: right;
}

.di {
  _display: inline;
}

.fwn {
  font-weight: normal;
}

.dib {
  *display: inline;
  _zoom: 1;
  _display: inline;
  _font-size: 0px;
}


/*首页左侧联系我们*/
.contact {
  width: 218px;
  float: left;
  padding-bottom: 5px;
  margin-top: 10px;
}

.contact_title {
  line-height: 31px;
  padding-left: 15px;
  font-weight: bold;
  font-family: "微软雅黑";
}

.contact .content {
  padding: 5px;
  padding-left: 8px;
}

/*工程案例*/


/*友情链接*/
.d_jjaj {
  background: #3cb98c;
  padding: 20px 0;
}

.f_link a {
  padding: 0 5px;
  color: #fff;
  line-height: 22px;

}

.d_jjaj .k1 a, .d_jjaj .k1 {
  line-height: 26px;
  color: #fff;
}

.d_jjaj .k1 a:hover {
  color: #fff;
}

/*页面底部*/
.foot_bj {
  background: #3b3c3e;
  padding: 58px 0 0;
}

.fo_at1 {
  width: 744px;
}

.fo_at2 {
  width: 338px;
}

.d_nav a {
  color: #ffffff;
  font: 500 14px/36px "微软雅黑";
  margin-right: 50px;
}

.d_nav a:hover {
  color: #3cb98c;
}

.fo_at1 .d_lanxi {
  color: #9c9ca2;
  font: 500 13px/29px "微软雅黑";
  margin-top: 18px;
}

.d_ahjhj {
  text-align: right;
  color: #fff;
  margin-right: 28px;
}

.d_ahjhj a.msg_more {
  display: block;
  color: #fff;
  font: 500 12px/32px "微软雅黑";
  width: 136px;
  text-align: left;
  background: #3cb98c;
  text-indent: 49px;
  margin-top: 8px;
}

.d_ahjhj h2 {
  font: 500 12px/24px "微软雅黑";
  margin-top: 30px;
}

.d_ahjhj h2 span {
  font: 500 28px/34px "Arial";
  display: block;
}

.foot2 {
  border-top: 1px solid #545453;
  padding: 18px 0;
  margin-top: 45px;
}

.foot2, .foot2 a {
  color: #9c9ca2;
  font: 500 13px/38px "微软雅黑";
}

.foot2 a:hover {
  color: #3cb98c;
}


/*悬浮*/
.xg_ycxuf {
  position: fixed;
  right: 12px;
  top: 50%;
  z-index: 99999;
  /*display: none;*/
}

.xg_ycxuf a {
  display: block;
  margin-bottom: 20px;
}

.foot {
  background: #f3f3f3;
  width: 1430px;
  position: relative;
  left: 50%;
  margin-left: -715px;
  padding-top: 28px;
  padding-bottom: 15px;
}

#footer {
  width: 1100px;
  margin: 0 auto;
}

#footer a {
  color: #666;
}

#footer a:hover {
  color: #0262b8;
  text-decoration: none;
}

.logo1 {
  float: left;
  margin-left: 100px;
}

.copyright {
  width: 670px;
  float: left;
  margin-left: 30px;
  line-height: 24px;
  margin-top: 12px;
}

.left .box {
  margin-top: 20px;
}

.left .box h3 {
  background: #3cb98c;
  color: #fff;
  font: 500 18px/48px "微软雅黑";
  position: relative;
  text-indent: 30px;
}

.left .box h3:after {
  content: "";
  display: block;
  width: 4px;
  height: 16px;
  position: absolute;
  left: 15px;
  background: #fff;
  top: 16px;
}

.left .box .content {
  padding: 10px 0px 16px;
  border: 1px solid #ececec;
  background: #fafafa;
  margin-top: 1px;
}

.prodescription {
  border: 1px solid #e5e5e5;
  background: #f9f9f9;
  line-height: 24px;
  padding: 10px;
  margin-bottom: 15px;
  text-indent: 20px;
}

.n_banner {
  width: 100%;
  margin: 0 auto;
}

.n_banner img {
  width: 100%;
  margin: 0 auto
}

.left {
  width: 235px;
  float: left;
}

.sort_menu {
}

.sort_menu h3 {
  background-color: #ececec;
  line-height: 28px;
  padding-left: 15px;
  font-weight: bold;
}

.sort_product {
  margin-top: 10px;
}

.sort_product h3 {
  background-color: #ececec;
  line-height: 28px;
  padding-left: 15px;
  font-weight: bold;
}

.n_contact {
  margin-top: 10px;
}

.n_contact h3 {
  background-color: #ececec;
  line-height: 28px;
  padding-left: 15px;
  font-weight: bold;
}

.n_contact .content {
  padding: 5px;
  line-height: 24px;
}

.right {
  width: 924px;
  float: right;
  padding-bottom: 10px;
}

.sitemp h2 {
  width: auto;
  float: left;
  line-height: 42px;
  text-align: center;
  text-align: left;
  text-indent: 18px;
  color: #333333;
  font-size: 18px;
  font-weight: 500;
}

.sitemp .site {
  width: auto;
  float: right;
  text-align: right;
  line-height: 42px;
}

.sitemp .site, .sitemp .site a {
  color: #999999;
  font: 500 12px/42px "微软雅黑";
}

.sitemp .site a:hover {
  color: #3cb98c;
}

.right .content {
  padding: 10px;
  padding-top: 15px;
  overflow: hidden;
  line-height: 24px;
}

/*内页*/
.sort_menu h3 {

  box-sizing: border-box;
  padding: 16px 27px;
  color: #fff;
  font: 600 24px/42px "微软雅黑";
  border-top-left-radius: 6px;
  border-top-right-radius: 6px;
}


/* Slider */
.slick-slider {
  position: relative;

  display: block;
  box-sizing: border-box;

  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;

  -webkit-touch-callout: none;
  -khtml-user-select: none;
  -ms-touch-action: pan-y;
  touch-action: pan-y;
  -webkit-tap-highlight-color: transparent;
}

.slick-list {
  position: relative;

  display: block;
  overflow: hidden;

  margin: 0;
  padding: 0;
}

.slick-list:focus {
  outline: none;
}

.slick-list.dragging {
  cursor: pointer;
  cursor: hand;
}

.slick-slider .slick-track,
.slick-slider .slick-list {
  -webkit-transform: translate3d(0, 0, 0);
  -moz-transform: translate3d(0, 0, 0);
  -ms-transform: translate3d(0, 0, 0);
  -o-transform: translate3d(0, 0, 0);
  transform: translate3d(0, 0, 0);
}

.slick-track {
  position: relative;
  top: 0;
  left: 0;

  display: block;
  margin-left: auto;
  margin-right: auto;
}

.slick-track:before,
.slick-track:after {
  display: table;

  content: '';
}

.slick-track:after {
  clear: both;
}

.slick-loading .slick-track {
  visibility: hidden;
}

.slick-slide {
  display: none;
  float: left;

  height: 100%;
  min-height: 1px;
}

[dir='rtl'] .slick-slide {
  float: right;
}

.slick-slide img {
  display: block;
}

.slick-slide.slick-loading img {
  display: none;
}

.slick-slide.dragging img {
  pointer-events: none;
}

.slick-initialized .slick-slide {
  display: block;
}

.slick-loading .slick-slide {
  visibility: hidden;
}

.slick-vertical .slick-slide {
  display: block;

  height: auto;

  border: 1px solid transparent;
}

.slick-arrow.slick-hidden {
  display: none;
}

.abt_maa a:nth-child(1) {
  background: url(./assets/aghgh.png) no-repeat 17px center;
}

.abt_maa a:nth-child(2) {
  background: url(./assets/aghgh1.png) no-repeat 17px center;
}

.abt_maa a:nth-child(3) {
  background: url(./assets/aghgh2.png) no-repeat 17px center;
}
</style>
