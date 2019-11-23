import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Value from '@/components/Value'
import Home from '@/components/Home'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: '',
            component: HelloWorld,
            hidden: true,
        },
        {
            path: '/home',
            name: '',
            component: Home,
            hidden: true,
            children: [
                {
                    path: 'value',
                    name: '价值观管理',
                    component: Value,
                    meta: {
                        keepAlive: true
                    }
                },
            ]
        }
    ]
})
