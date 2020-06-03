import Vue from 'vue'
import Router from 'vue-router'

import  Main from '../views/main'
import Search from '../views/search'

Vue.use(Router)

export default new Router({
    routes:[
        {
            // 主页面
            path: '/',
            name: 'Main',
            component: Main
        },
        {
            // 搜索页面
            path: '/search/:key_word',
            name: 'Search',
            component: Search
        },
    ]
})