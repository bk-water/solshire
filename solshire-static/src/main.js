import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import 'normalize.css/normalize.css'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/fonts/iconfont.css'
import '@/assets/styles/global.scss';

Vue.use(ElementUI);

Vue.config.productionTip = false

Vue.config.errorHandler = function(err, vm, info){
  console.error(info)
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
