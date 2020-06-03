import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router'
import store from './store'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Vuex from 'vuex'

Vue.config.productionTip = false

Vue.use(VueAxios, axios)
Vue.use(ElementUI)
Vue.use(Vuex);

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
