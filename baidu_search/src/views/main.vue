<template>
    <el-container>
        <el-header style="margin-top: 0.6%;height: 4.5%">
            <el-row>
                <el-col :md="8">
                    <el-link class="header-left" :underline="false">新闻</el-link>
                    <el-link class="header-left" :underline="false">hao123</el-link>
                    <el-link class="header-left" :underline="false">地图</el-link>
                    <el-link class="header-left" :underline="false">视频</el-link>
                    <el-link class="header-left" :underline="false">贴吧</el-link>
                    <el-link class="header-left" :underline="false">学术</el-link>
                    <el-popover
                            placement="bottom"
                            width="305"
                            trigger="hover">
                        <div style="margin: 0;padding: 0">
                            <el-row style="padding: 0">
                                <el-col :md="5" v-for="(cont,i) in mini_content" :key="i"
                                        style="text-align: center;margin: 0 4% 5% 0">
                                    <el-link :underline="false" href="https://pan.baidu.com/">
                                        <el-image :src='cont.url'
                                                  style="width: 40px; height: 40px;">
                                        </el-image>
                                        <span style="display: block">{{cont.title}}</span>
                                    </el-link>
                                </el-col>
                            </el-row>
                            <el-row id="popover-more">
                                <el-col :md="24" style="text-align: center">
                                    <el-link type="info"
                                             :underline="false"
                                             href="http://www.baidu.com/more/"
                                             style="font-size: 12px">
                                        查看全部百度产品 >
                                    </el-link>
                                </el-col>
                            </el-row>
                        </div>

                        <el-link class="header-left" :underline="false" slot="reference">更多</el-link>
                    </el-popover>
                </el-col>
                <el-col :md="4" :offset="12">
                    <el-link class="header-right" type="danger" :underline="false">抗击肺炎</el-link>
                    <el-link class="header-right" :underline="false">设置</el-link>
                    <el-button
                            id="login"
                            type="primary"
                            class="header-right"
                            size="mini"
                            @click="dialogLogin = true"
                            v-if="this.$store.getters.getUser.username===null||this.$store.getters.getUser.username===''">
                        登录
                    </el-button>

                    <!--登录消息框-->
                    <el-dialog :visible.sync="dialogLogin" style="width: 50%;margin: 0 auto">
                        <el-row>
                            <el-col :md="8">
                                <img src="https://passport.baidu.com/passApi/img/loginlogo.png"/>
                            </el-col>
                            <el-col :md="16" style="height: 34px"><span
                                    style="font-size: 16px;line-height: 38px">用户密码登录</span></el-col>
                        </el-row>
                        <el-row>
                            <el-form :model="user" :rules="rules" ref="loginForm">
                                <el-col :md="24" style="margin-top: 15%">
                                    <el-form-item prop="username">
                                        <el-input v-model="user.username" placeholder="用户名/邮箱/手机号"></el-input>
                                    </el-form-item>
                                    <el-form-item prop="password">
                                        <el-input v-model="user.password" placeholder="密码"
                                                  show-password></el-input>
                                    </el-form-item>
                                </el-col>
                                <el-col :md="24">
                                    <el-form-item>
                                        <el-checkbox label="记住密码"></el-checkbox>
                                    </el-form-item>
                                </el-col>
                                <el-col :md="24" style="margin-top: 2%">
                                    <el-form-item>
                                        <el-button type="primary" style="width: 100%;font-size: 16px"
                                                   v-on:click="onSubmit('loginForm')">登录
                                        </el-button>
                                    </el-form-item>
                                </el-col>
                                <el-col :md="24" style="margin-top: 2%">
                                    <el-link type="primary" :underline="false">忘了密码</el-link>
                                </el-col>
                            </el-form>
                        </el-row>
                        <el-row style="margin-top: 15%">
                            <el-col :md="6">
                                <el-link type="primary" :underline="false">扫码登录</el-link>
                                <span style="margin-left: 20%;color: #c4c7ce">|</span>
                            </el-col>
                            <el-col :md="12">
                                <i class="el-icon-platform-eleme i-other"></i>
                                <i class="el-icon-info i-other"></i>
                                <i class="el-icon-s-promotion i-other"></i>
                            </el-col>
                            <el-col :md="6">
                                <el-link type="primary" :underline="false">立即注册</el-link>
                            </el-col>
                        </el-row>
                    </el-dialog>

                    <el-dropdown
                            class="header-right"
                            v-if="this.$store.getters.getUser.username">
                        <span>▼zzp</span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>个人中心</el-dropdown-item>
                            <el-dropdown-item>账号设置</el-dropdown-item>
                            <el-dropdown-item>意见反馈</el-dropdown-item>
                            <el-dropdown-item>
                                <el-button type="text" @click='loginout()'>退出</el-button>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>


                </el-col>
            </el-row>
        </el-header>
        <el-main style="margin: 0;padding: 0">
            <el-row>
                <el-col :md="6" :offset="10">
                    <img hidefocus="true" src="//www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"
                         width="270"
                         height="129"
                         onerror="this.src='//www.baidu.com/img/flexible/logo/pc/index.png';this.onerror=null;"
                         usemap="#mp">
                </el-col>
            </el-row>
            <el-row style="margin-top: 2%">
                <el-col :md="9" :offset="7" class="key-col">
                    <!--<el-input id="key-word" placeholder="请输入内容" v-model="search_word">
                        <el-link slot="suffix" icon="el-input__icon el-icon-camera" :underline="false"
                                 style="font-size: 20px;"></el-link>
                    </el-input>-->

                    <el-autocomplete
                            id="key-word"
                            v-model="search_word"
                            :fetch-suggestions="querySearch"
                            placeholder="请输入内容"
                            :trigger-on-focus="false"
                            @select="handleSelect"
                            style="width: 100%;">
                        <el-link slot="suffix" icon="el-input__icon el-icon-camera" :underline="false"
                                 style="font-size: 20px;"></el-link>
                        <template slot-scope="{ item }">
                            <div class="title">{{ item.tags }}</div>
                        </template>
                    </el-autocomplete>

                </el-col>
                <el-col :md="4">
                    <el-button id="search_word" type="primary" @click="search_method(search_word)">百度一下</el-button>
                </el-col>
            </el-row>
        </el-main>
        <el-footer style="width: 100%;height: 40px;bottom: 0;position: absolute;">
            <el-row>
                <el-col :md="9">
                    <el-link class="bottom-left" :underline="false">设为首页</el-link>
                    <el-link class="bottom-left" :underline="false">关于百度</el-link>
                    <el-link class="bottom-left" :underline="false">About Baidu</el-link>
                    <el-link class="bottom-left" :underline="false">百度推广</el-link>
                    <el-link class="bottom-left" :underline="false">使用百度前必读</el-link>
                    <el-link class="bottom-left" :underline="false">意见反馈</el-link>
                    <el-link class="bottom-left" :underline="false">帮助中心</el-link>
                </el-col>
                <el-col :md="10" :offset="5">
                    <span class="bottom-right">©2020 Baidu</span>
                    <span class="bottom-right">(京)-经营性-2017-0020</span>
                    <span class="bottom-right">京公网安备11000002000001号</span>
                    <span class="bottom-right">京ICP证030173号</span>
                </el-col>
            </el-row>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name: 'Main',
        data() {
            return {
                search_word: '',
                mini_content: [
                    {
                        title: '网盘',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/baiduyun@2x-e0be79e69e.png'
                    },
                    {
                        title: '知道',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/zhidao@2x-e9b427ecc4.png'
                    },
                    {
                        title: '百科',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/baike@2x-1fe3db7fa6.png'
                    },
                    {
                        title: '图片',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/tupian@2x-482fc011fc.png'
                    },
                    {
                        title: '宝宝知道',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/baobaozhidao@2x-af409f9dbe.png'
                    },
                    {
                        title: '文库',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/wenku@2x-f3aba893c1.png'
                    },
                    {
                        title: '经验',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/jingyan@2x-e53eac48cb.png'
                    },
                    {
                        title: '音乐',
                        url: 'https://dss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/topnav/yinyue@2x-c18adacacb.png'
                    },
                ],
                dialogLogin: false,
                user: {
                    username: '',
                    password: '',

                },
                rules: {
                    username: [{required: true, message: '账号不可为空', trigger: 'blur'}],
                    password: [{required: true, message: '密码不可为空', trigger: 'blur'}]
                }
            }
        },
        methods: {
            loginout() {
                this.user.username = ''
                this.$store.dispatch("asyncUpdateUser", this.user);
            },
            onSubmit(formName) {
                // 为表单绑定验证功能
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        window.console.log('登录')
                        this.$store.dispatch("asyncUpdateUser", this.user);
                        this.dialogLogin = false
                    } else {
                        this.dialogLogin = true
                        return false
                    }
                })
            },
            querySearch(queryString, cb) {
                this.axios.get("http://localhost:8888/news/suggest?prefix=" + queryString)
                    .then(resp => {
                        // 调用 callback 返回建议列表的数据
                        cb(resp.data);
                    })
            },
            handleSelect(item) {
                console.log(item.tags)
            },
            search_method(key_word) {
                this.$router.push({
                    name: 'Search',
                    params: {
                        key_word: key_word
                    }
                })
            }
        },


    };
</script>

<style scoped>
    /* 按钮鼠标事件样式 */
    .el-link.el-link--danger:hover, .el-link.el-link--info:hover {
        color: #409EFF;
    }

    /* 标题栏-header-start */
    .header-left, .header-right {
        color: black;
        line-height: initial;
        font-family: "微软雅黑", serif;
        font-size: 13px;
    }

    .header-left {
        margin-right: 6%;
    }

    .el-popover {
        border: none;
    }

    /* more-弹出框 */
    #popover-more {
        margin-top: 1%;
        margin-bottom: 1%;
    }

    .header-right {
        margin-left: 13%;
    }

    /* login-start */
    #login {
        color: whitesmoke;
    }

    .i-other {
        margin-top: 2%;
        margin-left: 4%;
        font-size: 18px;
        color: #409EFF;
    }

    /* login-end */
    /* 标题栏-header-end */

    /* input-搜索框-start */
    >>> #key-word {
        border-radius: 10px 0 0 10px;
        border: 2px solid #c4c7ce;
        border-right: none;
        height: 45px;
    }

    >>> #key-word:hover {
        border: 2px solid #b3b3bb;
        border-right: none;
    }

    >>> #key-word:focus {
        border: 2px solid #409EFF;
    }

    #search_word {
        border-radius: 0 10px 10px 0;
        height: 45px;
        font-size: 17px;
    }

    /* input-搜索框-end */

    /* 底部-start */
    .el-footer {
        margin-left: 0;
        margin-right: 0;
        margin-top: 5%;
        padding: 0;
        background: rgb(250, 250, 250);
    }

    .bottom-left, .bottom-right {
        font-size: 12px;
        line-height: 40px;
    }

    .bottom-left {
        margin-left: 4%;
        color: rgb(145, 162, 194);
    }

    .bottom-right {
        color: #c4c7ce;
        margin-left: 5%;
    }

    /* 底部-end */
</style>