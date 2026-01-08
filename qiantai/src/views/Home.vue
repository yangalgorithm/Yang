<template>
  <div class="home" id="home" name="home">
    <div class="main-box">

      <div class="cont2">
        <div class="w1200">
          <div class="title_a2">
            <h2>关于我们</h2>
          </div>
          <div class="a2_v1 clearfix">
            <div class="a2_b1 fl">
              <h2>汽车养护电商平台</h2>
              <div class="abt_wen">	<p> 汽车预约公司，专注汽车后市场服务。凭借敏锐行业洞察与对用户需求的理解，我们融合线上线下资源，打造出一站式汽车预约系统。团队汇聚汽车、互联网、客服等专业人才，秉持 “便捷、透明、专业” 理念，为车主提供便捷预约、透明服务信息与专业汽车服务，致力于让车主享受省心、放心、舒心的汽车服务体验。</p></div>
              <div class="abt_maa clearfix">
                <a href="#">公司简介</a>
                <a href="#">资质荣誉</a>
                <a href="#">联系我们</a>
              </div>
            </div>
            <div class="a2_b2 fr"><p><img  style="HEIGHT: 248px; WIDTH: 400px" border="0"  src="../assets/3.jpg" width="400" height="248"/></p></div>
          </div>
          <ul class="a2_v2 clearfix">
            <li>
              <h2><span class="counter">22</span><b>年</b></h2>
              <h3>公司始建于20xx年3月</h3>
            </li>
            <li>
              <h2><span class="counter">3100</span><b>万元</b></h2>
              <h3>注册资金3100万元</h3>
            </li>
            <li>
              <h2><span class="counter">8,0000</span><b>m2</b></h2>
              <h3>占地面积8万平方米</h3>
            </li>
            <li>
              <h2><span class="counter">59</span><b>人</b></h2>
              <h3>公司团队人数</h3>
            </li>
          </ul>
        </div>
      </div>

      <br>
    </div>
  </div>
</template>
<script>
import {mapActions} from "vuex";
export default {
  data() {
    return {
	  objssp: [],
      objstx: [],
	  wbjxwtz1: [],
      wbjxwtz2: [],
    };
  },
  watch: {
    '$route'(to, from) {
      this.$router.go(0)
    },
  },
  created() {
    let user = localStorage.getItem("user");
    if(user) {
      this.userInfo = JSON.parse(localStorage.getItem("user"));
    }
	//loadsp1
	//loadtx2
	this.loadTablexw1(8,"站内新闻");
    this.loadTablexw2(8,"站内新闻2");

  },
  methods: {
    ...mapActions(["setUser", "setShowLogin", "setShoppingCart"]),
    goUrl() {
      window.location.href = 'http://localhost:9999'
    },
    //loadsphs
    //loadtxhs
	loadTablexw1(ns,lb) {
      this.$axios
              .get("/api/front/xinwentongzhi", {})
              .then(res => {
                let data = res.data.data;
                let filteredData = []; // 用于存储满足条件的数据
                let tt=0
                // 遍历data数组
                data.forEach(item => {
                  if (item.leibie === lb) {
                    tt++;
                    if(tt<=ns)
                    {
                    filteredData.push(item);
                    }
                  }
                });
                this.wbjxwtz1 = filteredData;
              })
              .catch(err => {
                return Promise.reject(err);
              });
    },
    loadTablexw2(ns,lb) {
      this.$axios
              .get("/api/front/xinwentongzhi", {})
              .then(res => {
                let data = res.data.data;
                let filteredData = []; // 用于存储满足条件的数据
                let tt=0
                // 遍历data数组
                data.forEach(item => {
                  if (item.leibie === lb) {
                    tt++;
                    if(tt<=ns)
                    {
                      filteredData.push(item);
                    }

                  }
                });
                this.wbjxwtz2 = filteredData;
              })
              .catch(err => {
                return Promise.reject(err);
              });
    },
  }
};
</script>

<style scoped>
  @import "../assets/css/index.scss";
  .message-item{
    margin-bottom: 20px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    display: flex;
    justify-content: center;
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    width: 100%;
    text-align: center;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
  .el-row {
    margin-bottom: 20px;
  }
  .last-child {
    margin-bottom: 0;
  }

  .el-col {
    border-radius: 4px;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .info-item {
    display: flex;
    font-size: 13px;
    color: #606266;
    height: 28px;
    line-height: 28px;
  }
  .info-item :hover {
    color: #303133;
    cursor: pointer;
  }
  .info-item-left {
    flex: 1;
    flex-shrink: 0;
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
  }
  .rizhuti_v2-widget-search-bg>.container {
    max-width: none !important;
    padding: 0 !important;
  }
  .container, .container-fluid, .container-lg, .container-md, .container-sm, .container-xl {
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
  }
  .module.search-bg {
    z-index: 2 !important;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    min-height: calc(100vh - 70vh);
    position: relative;
    text-align: center;
    background-repeat: no-repeat;
    background-position: 50%;
    background-size: cover;
  }
  .module.search-bg .search-bg-overlay {
    height: 100%;
    width: 100%;
    top: 0;
    left: 0;
    position: absolute;
    filter: brightness( 100%) contrast( 100%) saturate( 100%) blur( 0px) hue-rotate( 0deg);
    background-color: #191e4b;
    opacity: 0.5;
    transition: background 0.3s, border-radius 0.3s, opacity 0.3s;
  }
  .module.search-bg .container {
    z-index: 1;
    margin: auto;
    padding-bottom: 140px;
    padding-top: 140px;
    max-width: 820px;
  }
  .module.search-bg .search-title {
    color: #fff;
    letter-spacing: 2px;
    font-size: 24px;
  }
  .module.search-bg .search-desc {
    color: #fff;
    margin-bottom: 25px;
  }
  .module.search-bg .search-form {
    max-width: 100%;
  }
  .search-form form {
    display: flex;
    -ms-flex-flow: row nowrap;
    flex-flow: row nowrap;
    -ms-flex-align: center;
    align-items: center;
    -ms-flex-pack: justify;
    justify-content: space-between;
    width: 100%;
    border-radius: 50px;
  }
  .search-form .search-fields {
    background-color: #ffffff;
    position: relative;
    display: inline-block;
    flex: 1;
    vertical-align: top;
    background: #ffffff;
    border-radius: 30px;
    opacity: 0.8;
    overflow: hidden;
  }
  .search-form .search-fields input {
    display: block;
    height: 50px;
    line-height: 20px;
    width: 100%;
    border: 2px solid #fff;
    position: relative;
    z-index: 100;
    margin: 0;
    font-size: 16px;
    outline: 0;
    -webkit-appearance: none;
  }
  .search-form .search-fields button {
    position: absolute;
    height: 54px;
    width: 50px;
    right: 0;
    top: 0;
    z-index: 1000;
    border: none !important;
    background: 0 0 !important;
    max-height: 50px;
  }
  .module.search-bg .popula-search-key {
    text-align: left;
    color: #fff;
    margin-top: 10px;
    opacity: 0.5;
  }
  .module.search-bg .popula-search-key>a {
    color: #fff;
  }
  .modular-title-1 .section-title {
    font-size: 24px;
    letter-spacing: .5px;
    margin-bottom: 30px;
    text-transform: uppercase;
  }
  .image {
    width: 100%;
    display: block;
    max-height: 120px;
    min-height: 120px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
  .clearfix{
    font-size: 10px;
    line-height: 1.9;
  }
  .title{
    font-size: 15px;
    letter-spacing: -0.2px;
    margin-bottom: 0;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient: vertical;
    white-space: normal;
    height: 36px;
    line-height: 18px;
    font-weight: 700;
  }
  .clear {
    clear: both;
  }

  .el-form-item {
    margin-bottom: 0px !important;
  }
</style>
