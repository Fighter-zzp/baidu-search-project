/**
 * 这里是对状态的管理
 **/
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex);

// 存放组件的公共数据
const user= {
  state :  {
    // 初始化user对象
    user: {
      username: ''
    }
  },
// 用来监听并实时获取组件的公共数据（通过state）
  getters : {
    //获取user对象
    getUser(state) {
      return state.user;
    }
  },
//用来更新store内的数据，但是为同步更新
  mutations : {
    updateUser(state, user) {
      state.user = user;
    }
  },
// 用来触发mutations，以此达到异步
  actions : {
    asyncUpdateUser(context, user) {
      // 在组件中是通过 this.$store.dispatch('asyncUpdateUser', user); 来调用 actions
      context.commit("updateUser", user)
    }
  }
};


export default new Vuex.Store({
  modules: {
    user
  }
});
