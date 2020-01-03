import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false;


import {getRequest} from "./util/api";
import {postRequest} from "./util/api";
import {putRequest} from "./util/api";
import {deleteRequest} from "./util/api";


Vue.prototype.getRequest = getRequest;
Vue.prototype.postRequest = postRequest;
Vue.prototype.putRequest = putRequest;
Vue.prototype.deleteRequest = deleteRequest;

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'


Vue.use(ElementUI);

//
// router.beforeEach((to, from, next) => {
//     if (to.fullPath === '/') {
//         next({
//             path: '/login',
//         });
//     } else {
//         next();
//     }
// });

new Vue({
    render: h => h(App),
    router,
    store,
}).$mount('#app');
