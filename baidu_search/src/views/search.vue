<template>
    <el-container>
        <el-header style="padding: 0">
            <el-row>
                <el-col :md="2">
                    <el-image style="width: 88%;"
                              src="https://www.baidu.com/img/flexible/logo/pc/result.png"></el-image>
                </el-col>
                <el-col :md="8" style="margin-top: 0.2%">
                    <el-autocomplete
                            v-model="key_word"
                            placeholder="请输入内容"
                            :fetch-suggestions="querySearch"
                            @select="handleSelect"
                            :trigger-on-focus="false">
                        <el-link slot="suffix" icon="el-input__icon el-icon-camera" :underline="false"
                                 style="font-size: 20px;"></el-link>
                        <el-button id="search_btn" slot="append" @click="search_btn">百度一下</el-button>
                        <template slot-scope="{ item }">
                            <div class="title">{{ item.tags }}</div>
                        </template>
                    </el-autocomplete>
<!--                    <el-input v-model="key_word" placeholder="请输入内容">-->
<!--                        <el-link slot="suffix" icon="el-input__icon el-icon-camera" :underline="false"-->
<!--                                 style="font-size: 20px;"></el-link>-->
<!--                        <el-button slot="append" id="search_btn">百度一下</el-button>-->
<!--                    </el-input>-->
                </el-col>
                <el-col :md="4" :offset="10">
                    <el-link class="header-right" :underline="false">百度首页</el-link>
                    <el-link class="header-right" :underline="false">消息</el-link>
                    <el-link class="header-right" :underline="false">▼设置</el-link>
                    <el-link class="header-right" :underline="false">▼zzp</el-link>
                </el-col>
            </el-row>
        </el-header>
        <el-main style="padding: 0">
            <el-row>
                <el-col :md="24">
                    <el-tabs v-model="search_title" @tab-click="handleClick">
                        <el-tab-pane label="网页" name="one">
                            <el-row>
                                <el-col :md="8" :offset="2">
                                    <div class="news-content"
                                         style="margin-top: 3%"
                                         v-for="text in searchResults" :key="text.id">
                                        <div class="news_title" style="margin-top: 1%">
                                            <a :href="text.url" v-html="text.title" target="_blank"/>
                                        </div>
                                        <div class="text-item limit-line" v-html="text.content"/>
                                    </div>
                                </el-col>
                            </el-row>
                        </el-tab-pane>
                        <el-tab-pane label="资讯" name="tow">有道无术</el-tab-pane>
                        <el-tab-pane label="视频" name="third">术尚可求</el-tab-pane>
                        <el-tab-pane label="图片" name="fourth">有术无道</el-tab-pane>
                        <el-tab-pane label="知道" name="five">止于术</el-tab-pane>
                        <el-tab-pane label="文库" name="six">天下发生了一大事</el-tab-pane>
                        <el-tab-pane label="贴吧" name="seven">震惊了所有的人</el-tab-pane>
                        <el-tab-pane label="采购" name="eight">每个科学家都非常无解</el-tab-pane>
                        <el-tab-pane label="地图" name="nigh">那件事就是...</el-tab-pane>
                    </el-tabs>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "Search",
        data() {
            return {
                key_word: '',
                search_title: 'one',
                searchResults: [
                    {id: 1, title: '没填台头', url: 'www.baidu.com', content: '没有康藤池'},
                    {
                        id: 2,
                        title: '没填台头',
                        url: 'www.baidu.com',
                        content: '没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池没有康藤池'
                    },
                    {id: 3, title: '没填台头', url: 'www.baidu.com', content: '没有康藤池'},
                    {id: 4, title: '没填台头', url: 'www.baidu.com', content: '没有康藤池'},
                ]
            }
        },
        methods: {
            handleClick(tag, event) {
                console.log(tag, event)
            },
            querySearch(queryString, cb) {
                this.axios.get("http://localhost:8888/news/suggest?prefix=" + queryString)
                    .then(resp => {
                        // 调用 callback 返回建议列表的数据
                        cb(resp.data);
                    })
            },
            search_btn(){
                this.axios.get("http://localhost:8888/news/text?kw=" + this.key_word)
                    .then(resp => {
                        this.searchResults = resp.data
                    })
            },
            handleSelect(item){
                this.key_word = item.tags
                console.log(item.tags)
            }
        },
        mounted() {
            this.key_word = this.$route.params.key_word
            this.axios.get("http://localhost:8888/news/text?kw=" + this.key_word)
                .then(resp => {
                    this.searchResults = resp.data
                })
        }
    }
</script>

<style scoped>
    /* 搜索按钮 */
    #search_btn {
        background: #409EFF;
        color: whitesmoke;
        border-bottom-left-radius: 0;
        border-top-left-radius: 0;
        height: 40px;
    }

    #search_btn:hover {
        background: #4060ff;
    }

    /* 右边连接 */
    .header-right {
        margin-top: 4%;
        margin-left: 5%;
    }

    /* 新闻内容 */
    .limit-line {
        overflow:hidden;
        text-overflow:ellipsis;
        display:-webkit-box;
        -webkit-box-orient:vertical;
        -webkit-line-clamp:5;
    }
    .text-item {
        margin-top: 1.5%;
    }
</style>